package com.sj.demo.net;

import com.sj.demo.param.RpcRequest;
import com.sj.demo.param.RpcResponse;
import com.sj.demo.registry.ServiceRegistry;
import com.sj.demo.serialize.Serializer;
import com.sj.demo.util.BaseCallBack;
import com.sj.demo.util.IpUtil;
import com.sj.demo.util.NetUtil;
import com.sj.demo.util.RpcException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RpcProviderFactory {
    private static final Logger LOGGER = LoggerFactory.getLogger(RpcProviderFactory.class);

    //------------------------config--------------------------
    private Class<? extends Server> serverType;
    private Serializer serializer;


    private String ip;       //for registry
    private int port;        //default port
    private String accessToken;


    private Class<? extends ServiceRegistry> serviceRegistryClass;
    private Map<String, String> serviceRegistryParam;
    public RpcProviderFactory() {
    }

    public void initConfig(Class<? extends Server> serverType,
                           Serializer serializer,
                           int corePoolSize,int maxPoolSize,String ip,
                           int port, String accessToken, Class<? extends ServiceRegistry> serviceRegistryClass,
                           Map<String, String> serviceRegistryParam){
        this.serverType = serverType;
        this.serializer = serializer;
        this.ip = ip;
        this.port = port;
        this.accessToken = accessToken;
        this.serviceRegistryClass = serviceRegistryClass;
        this.serviceRegistryParam = serviceRegistryParam;

        //valid
        if (this.serverType == null) {
            throw new RuntimeException("rpc provider netType missing.");
        }
        if (this.serializer == null) {
            throw new RuntimeException("rpc provider serializer missing.");
        }

        if (this.ip == null) {
            this.ip = IpUtil.getIp();
            System.out.println("ip:"+this.ip);
        }
        if (this.port <= 0) {
            this.port = 7080;
        }
        if (NetUtil.isPortUsed(this.port)) {
            throw new RpcException("rpc provider port[" + this.port + "] is used.");
        }
        if (this.serviceRegistryClass != null) {
            if (this.serviceRegistryParam == null) {
                throw new RpcException("rpc provider serviceRegistryParam is Missing.");
            }
        }
    }

    public Serializer getSerializer() {
        return serializer;
    }

    public int getPort() {
        return port;
    }

    // ---------------- server ----------------
    private Server server;
    private ServiceRegistry serviceRegistry;
    private String serviceAddress;

    public void start() throws Exception {
        serviceAddress = IpUtil.getIpPort(this.ip, port);
        server = serverType.newInstance();
        server.setStartedCallback(new BaseCallBack() {
            @Override
            public void run() throws Exception {
                if (serviceRegistryClass != null) {
                    serviceRegistry = serviceRegistryClass.newInstance();
                    serviceRegistry.start(serviceRegistryParam);
                    if (serviceData.size() > 0) {
                        // key:类名，方法名，参数类型，参数列表 ; value:json类型的有实现类的服务器地址
                        for(Map.Entry<String,Object> entry: serviceData.entrySet()){
                            // 向服务器注册自己暴露的API 和 服务器地址
                            serviceRegistry.registry(entry.getKey(), serviceAddress);
                        }
                    }
                }
            }
        });

        server.setStopCallback(new BaseCallBack() {
            @Override
            public void run() throws Exception {
                //stop registry
                if (serviceRegistry != null) {
                    if (serviceData.size() > 0) {
                        for(Map.Entry<String,Object> entry: serviceData.entrySet()){
                            serviceRegistry.remove(entry.getKey());
                        }
                    }
                    serviceRegistry.stop();
                    serviceRegistry = null;
                }
            }
        });
        server.start(this);
    }

    // --------- local rpc service map
    private Map<String, Object> serviceData = new HashMap<>();

    public Map<String, Object> getServiceData() {
        return serviceData;
    }

    /**
     * make service key
     *
     * @param iface
     * @param version
     * @return
     */
    public static String makeServiceKey(String iface, String version) {
        String serviceKey = iface;
        if (version != null && version.length() > 0) {
            serviceKey += "#".concat(version);
        }
        return serviceKey;
    }

    // 在这里的本地注册服务 ， key为接口，value为实现类
    public void addService(String iface, String version, Object serviceBean) {
        String serviceKey = makeServiceKey(iface, version);
        serviceData.put(serviceKey, serviceBean);
        LOGGER.info(">>>>>>>>>>>rpc, provider factory add service success ,serviceKey = {} , serviceBean ={} ", serviceKey, serviceBean.getClass());
    }

    public RpcResponse invokeService(RpcRequest request){
        RpcResponse rpcResponse = new RpcResponse();
        rpcResponse.setResponseId(request.getRequestId());

        String serviceKey  = makeServiceKey(request.getClassName(), request.getVersion());
        Object serviceBean = serviceData.get(serviceKey);

        if (System.currentTimeMillis() - request.getCreateMillisTime() > 3 * 60 * 1000) {
            rpcResponse.setErrorMsg("The timestamp difference between admin and executor exceeds the limit.");
            return rpcResponse;
        }

        if (accessToken != null && accessToken.length() > 0 && !accessToken.equals(request.getAccessToken())) {
            rpcResponse.setErrorMsg("the access token["+request.getAccessToken()+"] is wrong");
            return rpcResponse;
        }

        try {
            //invoke
            Class<?> serviceClass=serviceBean.getClass();
            LOGGER.info("server class  "+serviceClass);
            String methodName=request.getMethodName();
            LOGGER.info("server class  "+methodName);
            Class<?>[] parameterTypes=request.getParameterTypes();
            LOGGER.info("server class  "+ Arrays.toString(parameterTypes));
            Object[] parameters=request.getParameters();
            LOGGER.info("server class  "+ Arrays.toString(parameters));
            Method method=serviceClass.getMethod(methodName,parameterTypes);
            LOGGER.info("server class  "+method);
            method.setAccessible(true);

            Object result=method.invoke(serviceBean,parameters);
            rpcResponse.setRetObject(result);
        } catch (Throwable e) {
            LOGGER.error("rpc provider invokeService error.",e);
            rpcResponse.setErrorMsg("Rpc Provider invokeService error-----"+e.getMessage());
        }
        return rpcResponse;
    }

    public void stop() throws Exception {
        server.stop();
    }
}
