package com.sj.demo.net;

import com.sj.demo.param.RpcFutureResponse;
import com.sj.demo.param.RpcResponse;
import com.sj.demo.registry.ServiceRegistry;
import com.sj.demo.registry.imp.LocalRegistry;
import com.sj.demo.util.RpcException;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.*;

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

    //------------------------future-response pool----------------------------
    private ConcurrentMap<String, RpcFutureResponse> futureResponsePool=new ConcurrentHashMap<>();

    public void setInvokerFuture(String requestId, RpcFutureResponse futureResponse){
        futureResponsePool.put(requestId,futureResponse);
    }
    public void removeInvokerFuture(String requestId){
        futureResponsePool.remove(requestId);
    }

    public void notifyInvokerFuture(String requestId, final RpcResponse rpcResponse){
        //get
        final RpcFutureResponse futureResponse=futureResponsePool.get(requestId);
        if (futureResponse == null){
            return;
        }
        // 回调
       futureResponse.setResponse(rpcResponse);
        //删除该实例
        futureResponsePool.remove(requestId);
    }
    //------------------response callback ThreadPool-------------------
    private ThreadPoolExecutor threadPoolExecutor=null;
    private void executeResponseCallback(Runnable runnable) {
        if (null == threadPoolExecutor) {
            synchronized (this) {
                if (null == threadPoolExecutor) {
                    threadPoolExecutor = new ThreadPoolExecutor(20, 100, 60L, TimeUnit.SECONDS, new LinkedBlockingDeque<>(1000), r -> new Thread(r, "rpc, RpcInvokerFactory-responseCallbackThreadPool-" + r.hashCode()), (r, executor) -> {
                        throw new RpcException("rpc Invoke Callback Thread pool is EXHAUSTED!");
                    });

                }
            }
        }
        threadPoolExecutor.execute(runnable);
    }



    private void stopCallbackThreadPool() {
        if (null!=threadPoolExecutor){
            threadPoolExecutor.shutdown();
        }
    }
}
