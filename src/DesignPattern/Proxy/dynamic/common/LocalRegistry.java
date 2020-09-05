package DesignPattern.Proxy.dynamic.common;

import DesignPattern.Proxy.dynamic.server.Server;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LocalRegistry {
    //方法与地址的映射
    public static volatile Map<String,String> map = new ConcurrentHashMap<>();
    //本地注册
    public static volatile Map<String, Server> mapServer = new HashMap<>();

    //本地注册,地址+实现类名
    public static void registry(String classInterface,String imp){
        map.put(classInterface,imp);
    }
    //获取实现类
    public static String get(String classInfo){
        return map.get(classInfo);
    }



    //本地模拟测试
    public static void registry(String name,Server server){
        mapServer.put(name,server);
    }
    //本地模拟连接
    public static Server getServer(String name){
        return mapServer.get(name);
    }
}
