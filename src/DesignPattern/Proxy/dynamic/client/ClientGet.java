package DesignPattern.Proxy.dynamic.client;
import DesignPattern.Proxy.dynamic.Request;
import DesignPattern.Proxy.dynamic.Response;
import DesignPattern.Proxy.dynamic.common.Commons;
import DesignPattern.Proxy.dynamic.common.LocalRegistry;
import DesignPattern.Proxy.dynamic.server.Server;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.CountDownLatch;

public class ClientGet implements Runnable{
    private Server server;
    private String address;
    CountDownLatch cdl;


    public ClientGet(String address){
        this.cdl = Commons.cdl;
        this.address = address;
    }

    public void init(){
        /*
        net
         */
        System.out.println("--------正在连接至服务器--------");
        //模拟网络连接成功
        server = LocalRegistry.getServer(address);
    }

    public Object getRemoteProxy(final Class<?> clazz) {
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),
                new Class[]{clazz}, new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Request request = createRequest(method,args,clazz);
                        return send(request);
                    }
                });
    }
    //创建请求
    public Request createRequest(Method method,Object[] args,Class<?> clazz){
        Request request = new Request();
        request.setRequestId("20200714--->request");
        request.setClassName(clazz.getName());
        request.setMethodName(method.getName());
        request.setParams(args);

        Class<?>[] parameterTypes = method.getParameterTypes();
        request.setParamTypes(parameterTypes);
        return request;
    }

    public Response send(Request request){
        return server.invokeResponse(request);
    }

    @Override
    public void run() {
        try {
            cdl.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        init();
    }
}
