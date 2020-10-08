package com.sj.demo.net;

import com.sj.demo.param.RpcRequest;

public abstract class Client {
    //---------------------init--------------------------
    protected volatile RpcReferenceBean rpcReferenceBean;

    public void init(RpcReferenceBean rpcReferenceBean) {
        this.rpcReferenceBean = rpcReferenceBean;
    }

    public abstract void asyncSend(RpcRequest request) throws InterruptedException;

    public abstract void close();

    public abstract boolean isValidate();
}
