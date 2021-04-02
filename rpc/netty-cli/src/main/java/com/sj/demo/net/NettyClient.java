package com.sj.demo.net;

import com.sj.demo.codec.NettyDecoder;
import com.sj.demo.codec.NettyEncoder;
import com.sj.demo.param.Beat;
import com.sj.demo.param.RpcRequest;
import com.sj.demo.param.RpcResponse;
import com.sj.demo.serialize.Serializer;
import com.sj.demo.util.IpUtil;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.timeout.IdleStateHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class NettyClient extends Client {
    private EventLoopGroup group;
    private Channel channel;
    private static final Logger logger = LoggerFactory.getLogger(NettyClient.class);

    public NettyClient() {

    }

    public void init(String address, final Serializer serializer, final RpcInvokerFactory rpcInvokerFactory) throws InterruptedException {
        final NettyClient nettyClient = this;
        this.group = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(group)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline()
                                .addLast(new IdleStateHandler(0, 0, Beat.BEAT_INTERVAL, TimeUnit.SECONDS))  // beat N, close if fail
                                .addLast(new NettyEncoder(RpcRequest.class, serializer))
                                .addLast(new NettyDecoder(RpcResponse.class, serializer))
                                .addLast(new NettyClientHandler(rpcInvokerFactory,nettyClient));
                    }
                })
                .option(ChannelOption.TCP_NODELAY, true)
                .option(ChannelOption.SO_KEEPALIVE, true)
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 10000);

        Object[] array = IpUtil.parseIpPort(address);
        String host = (String) array[0];
        int port = (int) array[1];
        this.channel = bootstrap.connect(host, port).sync().channel();

        if (!isValidate()) {
            close();
            return;
        }
        logger.debug(">>>>>>>>>>>>>>>>rpc netty client proxy, connect to server success at host:{}, port:{}", host, port);
    }

    @Override
    public void asyncSend(RpcRequest request) throws InterruptedException {
        this.channel.writeAndFlush(request).sync();
    }

    @Override
    public void close() {
        if (this.channel != null && this.channel.isActive()) {
            this.channel.close();
        }
        if (this.group != null && !this.group.isShutdown()) {
            this.group.shutdownGracefully();
        }
        logger.debug("rpc netty client close");
    }

    @Override
    public boolean isValidate() {
        if (this.channel != null) {
            return this.channel.isActive();
        }
        return false;
    }
}
