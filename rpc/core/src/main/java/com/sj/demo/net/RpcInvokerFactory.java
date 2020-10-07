package com.sj.demo.net;

import com.sj.demo.registry.ServiceRegistry;
import com.sj.demo.registry.imp.LocalRegistry;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class RpcInvokerFactory {

    private static final Logger LOGGER = LoggerFactory.getLogger(RpcInvokerFactory.class);

    // ----------------------  instance ----------------------

    private static volatile RpcInvokerFactory instance =
            new RpcInvokerFactory();

    public static RpcInvokerFactory getInstance() {
        return instance;
    }


    private Class<? extends ServiceRegistry> serviceRegistryClass;
    // 注册中心的参数
    private Map<String, String> serviceRegistryParam;

    public void setServiceRegistryClass(Class<? extends ServiceRegistry> registryClass) {
        this.serviceRegistryClass = registryClass;
    }

    public void setServiceRegistryParam(Map<String, String> params) {
        this.serviceRegistryParam = params;
    }


    private RpcInvokerFactory() {
    }

    public RpcInvokerFactory(Class<? extends ServiceRegistry> serviceRegistryClass, Map<String, String> serviceRegistryParam) {
        this.serviceRegistryClass = serviceRegistryClass;
        this.serviceRegistryParam = serviceRegistryParam;
    }
    //---------------------注册中心start / stop--------------------

    public void start() throws Exception {
        //start registry
        if (serviceRegistryClass != null) {
            serviceRegistry = serviceRegistryClass.newInstance();
            serviceRegistry.start(serviceRegistryParam);
        }
    }

    public void stop() throws Exception {
        //stop registry
        if (serviceRegistry != null) {
            serviceRegistry.stop();
        }


    }

    //---------------------service registry-------------------
    private ServiceRegistry serviceRegistry;

    public ServiceRegistry getServiceRegistry() {
        return serviceRegistry;
    }


}
