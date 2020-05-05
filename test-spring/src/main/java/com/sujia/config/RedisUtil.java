package com.sujia.config;
import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.annotation.PostConstruct;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

@Configuration
@PropertySource("classpath:config.properties")
public class RedisUtil {
    private static StatefulRedisConnection<String,String> connection;
    private static RedisCommands<String,String> commands ;

    /*
    为啥一获取就是空呢！
     */
    @Value("${server.ip}")
    private String host;

    @Value("#{${redis.port}}")
    private  int port;

    public RedisUtil(){

    }

    @PostConstruct
    public void init(){
        RedisURI uri = RedisURI.builder()
                .withHost(host)
                .withPort(port)
                .withTimeout(Duration.of(10, ChronoUnit.SECONDS))
                .build();                                         //创建单机连接信息

        RedisClient client = RedisClient.create(uri);                         //创建客户端
        connection = client.connect();                            //创建线程安全
        commands = getConnection();
    }
    
    @Bean
    public RedisCommands<String,String> getConnection(){

        return connection.sync();
    }


}
