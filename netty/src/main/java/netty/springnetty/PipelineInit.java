package netty.springnetty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpRequestEncoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
import netty.springnetty.handler.HttpHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class PipelineInit extends ChannelInitializer<SocketChannel> {
    @Autowired
    private HttpHandler httpHandler;


    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        //对response进行编码
        socketChannel.pipeline().addLast(new HttpRequestEncoder());
        //对request进行解码
        socketChannel.pipeline().addLast(new HttpRequestDecoder());
        socketChannel.pipeline().addLast(new HttpObjectAggregator(65536));
        //处理request并封装response的返回
        socketChannel.pipeline().addLast(httpHandler);
    }
}
