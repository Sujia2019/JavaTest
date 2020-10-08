package com.sj.demo.net;

import com.sj.demo.util.BaseCallBack;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Data
public abstract class Server {
    private static final Logger logger = LoggerFactory.getLogger(Server.class);

    private BaseCallBack startedCallback;
    private BaseCallBack stopCallback;

    public abstract void start(RpcProviderFactory rpcProviderFactory);

    public abstract void stop();

}
