package netty.springnetty.handler;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.springframework.stereotype.Component;


@ChannelHandler.Sharable
@Component
public class WebSocketHandler extends ChannelInboundHandlerAdapter {
}
