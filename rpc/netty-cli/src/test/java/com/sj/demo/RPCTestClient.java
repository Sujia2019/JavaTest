package com.sj.demo;

import com.sj.demo.net.NettyClient;
import com.sj.demo.net.RpcReferenceBean;
import com.sj.demo.serialize.Serializer;

public class RPCTestClient {
    public static void main(String[] args) {
        HelloService hello =
                (HelloService) new RpcReferenceBean(
                        NettyClient.class, Serializer.SerializerEnum.GSON.getSerializer(),
                        null, null,HelloService.class,
                        "localhost:16666",null,
                        10000,null).getObject();
        hello.sayHello("sujia");
    }
}
