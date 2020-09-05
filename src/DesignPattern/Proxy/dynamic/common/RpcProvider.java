package DesignPattern.Proxy.dynamic.common;

import DesignPattern.Proxy.dynamic.client.ClientGet;
import DesignPattern.Proxy.dynamic.server.Server;

public class RpcProvider {
    Server server;

    public RpcProvider(int port){
        try{
            this.server = new Server(port);

            new Thread(server).start();
        }catch (RuntimeException e){
            throw new RuntimeException("---->服务器启动失败---->");
        }
    }

    public void register(Class<?> iface,Class<?> imp){
        if(server!=null){
            server.registry(iface,imp);
        }
    }
}
