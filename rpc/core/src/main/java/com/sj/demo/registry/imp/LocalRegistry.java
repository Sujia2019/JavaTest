package com.sj.demo.registry.imp;

import com.sj.demo.registry.ServiceRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LocalRegistry extends ServiceRegistry {
    private static final Logger logger = LoggerFactory.getLogger(LocalRegistry.class);
    private static volatile Map<String, String> registryData;

    @Override
    public void start(Map<String, String> param) {
        registryData = new ConcurrentHashMap<>();
    }

    @Override
    public void stop() {
        registryData.clear();
    }

    @Override
    public boolean registry(String key, String value) {
        if (key == null || value == null) {
            return false;
        }
        try {
            registryData.put(key, value);
            return true;
        } catch (Exception e) {
            logger.error("LocalRegistry error put:" + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean remove(String key) {
        if (key == null) {
            return false;
        }
        try {
            registryData.remove(key);
            return true;
        } catch (Exception e) {
            logger.error("LocalRegistry error remove:" + e.getMessage());
            return false;
        }
    }

    @Override
    public String discovery(String key) {
        if (key == null) {
            return null;
        }
        return registryData.get(key);
    }
}
