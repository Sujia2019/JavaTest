package com.sj.demo.net;

import com.sj.demo.param.RpcFutureResponse;
import com.sj.demo.param.RpcRequest;
import com.sj.demo.param.RpcResponse;
import com.sj.demo.registry.ServiceRegistry;
import com.sj.demo.registry.imp.LocalRegistry;
import com.sj.demo.serialize.Serializer;
import com.sj.demo.util.IdWorker;
import com.sj.demo.util.RpcException;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.TreeSet;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * config
 */
@Data
public class RpcReferenceBean {
    private static final Logger LOGGER = LoggerFactory.getLogger(RpcReferenceBean.class);

    //-------------------config-------------------
    private Serializer serializer;
    private Class<? extends Client> clientClass;
    private Class<? extends ServiceRegistry> serviceRegistry;
//    private CallType callType = CallType.SYNC;
//    private LoadBalance loadBalance = LoadBalance.ROUND;
    private Class<?> iface;
    private String version;
    private long timeout = 1000;
    private String address;
    private String accessToken;
    private Map<String,String> params;
    private Client client = null;
    private RpcInvokerFactory invokerFactory;

    public Client getClient() {
        return client;
    }
    private void initClient() {
        try {
            client = clientClass.newInstance();
            client.init(this);
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RpcException(e);
        }
    }

    public RpcReferenceBean() {
    }

    public RpcReferenceBean(Serializer serializer, Class<? extends Client> clientClass,
                            Class<? extends ServiceRegistry> serviceRegistry,
                            Map<String, String> params,
                            Class<?> iface,String address,String accessToken,
                            long timeout,String version) {
        // 配置
        this.serializer = serializer;
        this.clientClass = clientClass;
        this.serviceRegistry = serviceRegistry;
        this.params = params;
        this.iface = iface;
        this.version = version;
        this.timeout = timeout;
        this.address = address;
        this.accessToken = accessToken;
        if (null == this.clientClass) {
            throw new RpcException("rpc reference netType missing.");
        }
        if (null == this.serializer) {
            this.serializer = Serializer.SerializerEnum.GSON.getSerializer();
        }
        if (null == this.serviceRegistry){
            this.serviceRegistry = LocalRegistry.class;
        }
        if (null == this.iface) {
            throw new RpcException("rpc reference iface missing.");
        }
        if (0 >= this.timeout) {
            this.timeout = 0;
        }
        if (null == this.invokerFactory) {
            this.invokerFactory = RpcInvokerFactory.getInstance();
            this.invokerFactory.setServiceRegistryClass(this.serviceRegistry);
            this.invokerFactory.setServiceRegistryParam(this.params);
        }
        // init Client
        initClient();
    }

    public Object getObject() {
        return Proxy.newProxyInstance(Thread.currentThread()
                .getContextClassLoader(), new Class[]{iface}, (proxy, method, args) -> {
                String className = iface.getName();
                String version1 = version;
                String accessToken1 = accessToken;
                String methodName = method.getName();
                Class<?>[] paramTypes = method.getParameterTypes();
                Object[] parameters = args;
                String requestId =""+new IdWorker(1L,1L,1L).nextId();
                RpcRequest rpcRequest = new RpcRequest();
                rpcRequest.setRequestId(requestId);
                rpcRequest.setClassName(className);
                rpcRequest.setParameterTypes(paramTypes);
                rpcRequest.setAccessToken(accessToken1);
                rpcRequest.setVersion(version1);
                rpcRequest.setMethodName(methodName);
                rpcRequest.setParameters(args);
                LOGGER.info("====[Rpc Request]====[{}]",rpcRequest);
                // TODO 没有多回调类型判断
                //future-response set
                RpcFutureResponse futureResponse = new RpcFutureResponse(invokerFactory, rpcRequest);

            try {
                // do invoke
                client.asyncSend(rpcRequest);

                // future get
                RpcResponse response = futureResponse.get(timeout, TimeUnit.MILLISECONDS);
                if (response.getErrorMsg() != null) {
                    throw new RpcException(response.getErrorMsg());
                }
                // return object
                return response.getRetObject();
            } catch (Exception e) {
                LOGGER.info(">>>>>>>>>>>>>>>rpc ,invoke error , address:{}, rpcRequest:{}", address, rpcRequest);
                throw (e instanceof RpcException) ? e : new RpcException(e);
            } finally {
                //future-response remove
                futureResponse.removeInvokerFuture();
            }
        });
    }

    public Class<?> getObjectType() {
        return iface;
    }
}
