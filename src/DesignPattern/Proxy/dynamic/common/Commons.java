package DesignPattern.Proxy.dynamic.common;

import java.util.concurrent.CountDownLatch;

public class Commons {
    public static volatile CountDownLatch cdl = new CountDownLatch(1);
}
