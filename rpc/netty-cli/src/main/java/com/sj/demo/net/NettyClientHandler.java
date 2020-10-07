package com.sj.demo.net;

import com.sj.demo.param.RpcResponse;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NettyClientHandler extends SimpleChannelInboundHandler<RpcResponse> {

    private static final Logger LOGGER = LoggerFactory.getLogger(NettyClientHandler.class);

    private RpcInvokerFactory invokerFactory;

    public NettyClientHandler(RpcInvokerFactory rpcInvokerFactory) {
        this.invokerFactory = rpcInvokerFactory;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, RpcResponse msg) throws Exception {

    }
}
