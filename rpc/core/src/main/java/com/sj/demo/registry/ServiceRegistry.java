package com.sj.demo.registry;

import java.util.Map;

public abstract class ServiceRegistry {
    /**
     * start
     */
    public abstract void start(Map<String, String> param);

    /**
     * stop
     */
    public abstract void stop();


    // 服务注册
    public abstract boolean registry(String key, String value);

    // 移出服务
    public abstract boolean remove(String key);

    // 服务发现
    public abstract String discovery(String key);


}
