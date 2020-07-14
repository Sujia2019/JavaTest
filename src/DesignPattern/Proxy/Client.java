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
//        SayHello hello = new SayHello();
//        RobotStaticProxy proxy = new RobotStaticProxy(hello);
//        proxy.saySomething("test");

        //---------------动态代理测试--------------------------
        //启动服务器
//        new Thread(new Server(8990)).start();
        new RpcProvider(8990).register(Say.class,SayHello.class);
        //调用rpc
        Say say = (Say)new RpcReferenceBean(Say.class).getRemoteObject();
        say.saySomething("RPC 调用成功");
    }
}
