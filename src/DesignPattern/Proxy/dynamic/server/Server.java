package DesignPattern.Proxy.dynamic.server;

import DesignPattern.Proxy.dynamic.Request;
import DesignPattern.Proxy.dynamic.Response;
import DesignPattern.Proxy.dynamic.common.Commons;
import DesignPattern.Proxy.dynamic.common.LocalRegistry;
import DesignPattern.Proxy.dynamic.common.Utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.concurrent.CountDownLatch;

public class Server implements Runnable{
    CountDownLatch cdl ;
    /*
    属性
     */
    private String host = "localhost";
//    private int port = 8990;
//    public static String address = "localhost:8990";
    public String address = "";

    public Server(int port){
        this.address = host+":"+port;
        this.cdl = Commons.cdl;
    }

    public void init(){
        /*
        net
         */
        System.out.println("--------正在启动服务器--------");
        address = Utils.setAddressKey(address);
        LocalRegistry.registry(address,this);
    }

    public void registry(Class<?> clazz,Class<?> imp){
        String key = clazz.getName();
        String ar = Utils.setValue(address,imp.getName());
        LocalRegistry.registry(key,ar);
        System.out.println("--------正在进行本地注册--------");
    }

    public void registry(TreeSet<Class<?>> classes){
        Iterator<Class<?>> it = classes.iterator();
        while (it.next()!=null){
            String key = it.next().getName();
            LocalRegistry.registry(key,address);
        }
    }

    /**
     * 通过反射获得对象实例，
     * 实现具体业务
     * @return
     */
    public Response invokeResponse(Request request){
        String className = request.getClassName();
        String methodName = request.getMethodName();
        Response res = new Response();
        res.setResponseId(request.getRequestId()+"--->response");
        try {
            //通过request请求的接口名去注册中心找对应的类名
            String imp = Utils.getImp(LocalRegistry.get(className));
            //获取类对象
            Class<?> clazz = Class.forName(imp);
            //获取对象实例
            Object obj = clazz.newInstance();
            //设置返回
            res.setRes(executeMethod(obj,methodName,request.getParams()));
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        return res;
    }


    public Object executeMethod(Object o,String methodName,Object[] params){
        Object obj = null;
        //获取参数类型
        Class<?>[] classes = new Class<?>[params.length];
        for(int i=0;i<classes.length;i++){
            classes[i] = params[i].getClass();
        }

        try {
            //通过方法名获取方法实体
            Method m = o.getClass().getMethod(methodName,classes);
            //调用，并获得返回
            obj = m.invoke(o,params);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return obj;
    }

    @Override
    public void run() {
        init();
        cdl.countDown();
    }
}
