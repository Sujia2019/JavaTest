package com.sj.demo.util;

import java.util.concurrent.*;

public class ThreadPoolUtil {

    public static ThreadPoolExecutor makeServerThreadPool(final String serverType){
        return new ThreadPoolExecutor(30, 200, 60L,
                TimeUnit.SECONDS, new LinkedBlockingQueue<>(1000),
                r -> new Thread(r, "rpc " + serverType + "-serverHandlerPool-" + r.hashCode()),
                (r, executor) -> {
            throw new RuntimeException("rpc "+serverType+" Thread pool is EXHAUSTED!");
        });
    }
}
