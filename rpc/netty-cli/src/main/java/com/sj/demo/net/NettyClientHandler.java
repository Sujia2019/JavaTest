package com.sj.demo.net;

import com.sj.demo.param.Beat;
import com.sj.demo.param.RpcResponse;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.timeout.IdleStateEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NettyClientHandler extends SimpleChannelInboundHandler<RpcResponse> {

    private static final Logger LOGGER = LoggerFactory.getLogger(NettyClientHandler.class);

    private RpcInvokerFactory invokerFactory;
    private Client nettyClient;

    public NettyClientHandler(RpcInvokerFactory rpcInvokerFactory,Client client) {
        this.invokerFactory = rpcInvokerFactory;
        this.nettyClient = client;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, RpcResponse msg) throws Exception {
        // TODO 回调
        invokerFactory.notifyInvokerFuture(msg.getResponseId(),msg);

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        LOGGER.error(">>>>>>>>>>>rpc netty client caught exception",cause);
        ctx.close();
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent){
            nettyClient.asyncSend(Beat.BEAT_PING);

            LOGGER.debug(">>>>>>>>>>>>>>>>>rpc netty client send beat-ping");
        }else{
            super.userEventTriggered(ctx,evt);
        }
    }
}
