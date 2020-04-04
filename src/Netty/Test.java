package Netty;

//import com.sun.javafx.webkit.EventLoopImpl;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;


public class Test {
    public static void main(String[] args) {
//        EventLoopGroup
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
//        try{
//            ServerBootstrap b = new ServerBootstrap();
//            b.group(bossGroup,workerGroup).channel(NioServerSocketChannel.class)
//                    .childHandler(new ChannelInitializer() {
//                        @Override
//                        protected void initChannel(Channel ch) throws Exception {
//                            ch.pipeline().addLast(new )
//                        }
//                    })
//        }catch (Exception e){
//            e.printStackTrace();
//        }
    }
}
