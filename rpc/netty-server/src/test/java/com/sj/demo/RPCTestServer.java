package com.sj.demo;

import com.sj.demo.imp.HelloServiceImp;
import com.sj.demo.net.RpcProviderFactory;
import com.sj.demo.serialize.Serializer;

import java.util.concurrent.TimeUnit;

public class RPCTestServer {
    public static void main(String[] args) throws Exception {
        RpcProviderFactory factory=new RpcProviderFactory();
        factory.initConfig(NettyServer.class,
                Serializer.SerializerEnum.GSON.getSerializer() ,
                5,30,"localhost",16666,
                null,null,null);
        factory.addService(HelloService.class.getName(),null,new HelloServiceImp());
        factory.start();
        Thread.sleep(50000);
//        while(!Thread.currentThread().isInterrupted()){
//            TimeUnit.HOURS.sleep(1);
//        }
//        factory.stop();
    }
}
