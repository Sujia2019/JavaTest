package com.sj.demo.registry.imp;

import com.sj.demo.registry.ServiceRegistry;
import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisStringCommands;

import java.util.Map;

public class RedisRegistry extends ServiceRegistry {

    private RedisClient client;
    // connection, 线程安全的长连接，连接丢失时会自动重连，直到调用 close 关闭连接。
    private StatefulRedisConnection<String, String> connection;
    // sync, 默认超时时间为 60s.
    private RedisStringCommands<String, String> sync;

    @Override
    public void start(Map<String, String> param) {
        String host = param.get("host");
        String port = param.get("port");
        client = RedisClient.create("redis://" + host + ":" + port);
        connection = client.connect();
        sync = connection.sync();
    }

    @Override
    public void stop() {
        if (connection != null) {
            // close connection
            connection.close();
        }
        if (client != null) {
            // shutdown
            client.shutdown();
        }

    }

    @Override
    public boolean registry(String key, String value) {
        if (value == null || key == null) {
            return false;
        }
        sync.set(key, value);
        return true;
    }

    @Override
    public boolean remove(String key) {
        if (key == null) {
            return false;
        }
        connection.sync().del(key);
        return true;
    }

    @Override
    public String discovery(String key) {
        if (key != null) {
            return sync.get(key);
        }
        return null;
    }
}
