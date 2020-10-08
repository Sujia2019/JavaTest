package com.sj.demo;

import com.sj.demo.codec.NettyDecoder;
import com.sj.demo.codec.NettyEncoder;
import com.sj.demo.net.RpcProviderFactory;
import com.sj.demo.net.Server;
import com.sj.demo.param.Beat;
import com.sj.demo.param.RpcRequest;
import com.sj.demo.param.RpcResponse;
import com.sj.demo.util.ThreadPoolUtil;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.timeout.IdleStateHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class NettyServer extends Server {
    private static final Logger LOGGER = LoggerFactory.getLogger(NettyServer.class);
    private Thread thread;

    @Override
    public void start(final RpcProviderFactory rpcProviderFactory) {
        thread = new Thread(()->{
            final ThreadPoolExecutor serverHandlerPool = ThreadPoolUtil.makeServerThreadPool("Netty Server");
            EventLoopGroup bossGroup = new NioEventLoopGroup();
            EventLoopGroup workGroup = new NioEventLoopGroup();

            try {
                ServerBootstrap bootstrap = new ServerBootstrap();
                bootstrap.group(bossGroup, workGroup).channel(NioServerSocketChannel.class).childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel channel) throws Exception {
                        channel.pipeline()
                                .addLast(new IdleStateHandler(0, 0, Beat.BEAT_INTERVAL * 3, TimeUnit.SECONDS))
                                .addLast(new NettyDecoder(RpcRequest.class, rpcProviderFactory.getSerializer()))
                                .addLast(new NettyEncoder(RpcResponse.class, rpcProviderFactory.getSerializer()))
                                .addLast(new NettyServerHandler(rpcProviderFactory, serverHandlerPool));
                    }
                }).childOption(ChannelOption.TCP_NODELAY, true)
                        .childOption(ChannelOption.SO_KEEPALIVE, true);

                //bind
                System.out.println("port:"+rpcProviderFactory.getPort());
                ChannelFuture future = bootstrap.bind(rpcProviderFactory.getPort()).sync();

                LOGGER.info(">>>>>>>>>>>>rpc remoting server start success , netType = {} , port ={}",NettyServer.class.getName(),rpcProviderFactory.getPort());

                future.channel().closeFuture().sync();
            } catch (InterruptedException e) {
                if (e instanceof InterruptedException){
                    LOGGER.info(">>>>>>>>>>>>>>>>>rpc remoting server stop");
                }else{
                    LOGGER.error(">>>>>>>>>>>>>rpc remoting server error.",e);
                }
            }finally {
                try {
                    serverHandlerPool.shutdown();
                    workGroup.shutdownGracefully();
                    bossGroup.shutdownGracefully();
                } catch (Exception e) {
                    LOGGER.error(e.getMessage(),e);
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
    }

    @Override
    public void stop() {
        //destroy server thread
        if (thread != null&& thread.isAlive()) {
            thread.interrupt();
        }

        //on stop
        onStop();
        LOGGER.info(">>>>>>>>>>> xxl-rpc remoting server destroy success.");
    }
}
