package DesignPattern.Proxy;

import DesignPattern.Proxy.dynamic.client.ClientGet;
import DesignPattern.Proxy.dynamic.common.Commons;
import DesignPattern.Proxy.dynamic.common.RpcProvider;
import DesignPattern.Proxy.dynamic.common.RpcReferenceBean;
import DesignPattern.Proxy.dynamic.server.Server;
import DesignPattern.Proxy.imp.SayHello;
import DesignPattern.Proxy.robot.RobotStaticProxy;

import java.util.concurrent.CountDownLatch;

public class Client {
    public static void main(String[] args) {
        //---------------静态代理测试--------------------------
        SayHello hello = new SayHello();
        RobotStaticProxy proxy = new RobotStaticProxy(hello);
        proxy.saySomething("test");

        //---------------动态代理测试--------------------------
        //启动服务器
        new RpcProvider(8990).register(Say.class,SayHello.class);
        //调用rpc
        Say say = (Say)new RpcReferenceBean(Say.class).getRemoteObject();
        say.saySomething("RPC 调用成功");

        /**
         * Rpc，需要知道以下参数
         *
         *   需要调用的接口名
         *   需要调用的方法名
         *   需要调用的参数类型
         *   需要调用的参数列表
         * ----------------------
         *
         *   通过查询注册中心--->经过负载均衡router--->找到对应的服务器ip和port
         *
         *   向对应的服务器发起连接--->发送Request数据包--->sync等待返回
         *
         *   服务器收到request--->通过动态代理获取实例对象--->调用--->返回调用结果
         *
         *   关闭连接
         */
    }
}
