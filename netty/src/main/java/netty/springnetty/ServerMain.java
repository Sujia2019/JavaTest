package netty.springnetty;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ServerMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(NettyConfig.class);
        NettyServer nettyServer = context.getBean(NettyServer.class);
        nettyServer.start(9999);
    }
}
