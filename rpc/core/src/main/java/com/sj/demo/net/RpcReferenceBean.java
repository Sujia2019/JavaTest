package com.sj.demo.net;

import com.sj.demo.registry.ServiceRegistry;
import com.sj.demo.registry.imp.LocalRegistry;
import com.sj.demo.serialize.Serializer;
import com.sj.demo.util.RpcException;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

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

    private Client client = null;
    private RpcInvokerFactory invokerFactory;

    public Client getClient() {
        return client;
    }

    public RpcReferenceBean() {
        // 默认方法 缺省客户端连接
        this.serializer = Serializer.SerializerEnum.GSON.getSerializer();
        this.serviceRegistry = LocalRegistry.class;
        this.invokerFactory.setServiceRegistryClass(serviceRegistry);
        this.invokerFactory.setServiceRegistryParam(null);
    }

    public RpcReferenceBean(Serializer serializer, Class<? extends Client> clientClass,
                            Class<? extends ServiceRegistry> serviceRegistry, Map<String, String> params) {
        // 配置
        this.serializer = serializer;
        this.clientClass = clientClass;
        this.serviceRegistry = serviceRegistry;
        this.invokerFactory.setServiceRegistryClass(serviceRegistry);
        this.invokerFactory.setServiceRegistryParam(params);
    }

    // 加载
    public void init() {
        if (null == this.clientClass) {
            throw new RpcException("rpc reference netType missing.");
        }
        if (null == this.serializer) {
            throw new RpcException("rpc reference serializer missing.");
        }
        if (null == this.serviceRegistry) {
            throw new RpcException("rpc reference serviceRegistry missing.");
        }
        if (0 >= this.timeout) {
            this.timeout = 1000;
        }
        if (null == this.invokerFactory) {
            this.invokerFactory = RpcInvokerFactory.getInstance();
        }
        try {
            client = clientClass.newInstance();
            client.init(this);
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RpcException(e);
        }
    }

    public Object getObject() {
        return client.getRemoteProxy(iface);
    }

    public Class<?> getObjectType() {
        return iface;
    }
}
