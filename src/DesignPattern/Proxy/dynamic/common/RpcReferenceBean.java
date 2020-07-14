package DesignPattern.Proxy.dynamic.common;

import DesignPattern.Proxy.dynamic.Request;
import DesignPattern.Proxy.dynamic.client.ClientGet;
import lombok.Data;

@Data
public class RpcReferenceBean {
    private Request request;
    private ClientGet clientGet;
    private Class<?> iface ;


    public RpcReferenceBean(Class<?> iface){
        this.iface=iface;
        //去注册中心找接口对应的地址和实体类
        String res = LocalRegistry.get(iface.getName());
        if(res==null|| res.equals("")){
            throw new RuntimeException("---->未找到方法实例---->");
        }
        try{
            String address = Utils.getAddress(res);
            System.out.println(address);
            this.clientGet = new ClientGet(address);

            new Thread(clientGet).start();
        }catch (RuntimeException e){
            throw new RuntimeException("---->连接失败---->");
        }
    }

    public Object getRemoteObject(){
        return this.clientGet.getRemoteProxy(iface);
    }
}
