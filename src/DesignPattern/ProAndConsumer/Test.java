package DesignPattern.ProAndConsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


public class Test {
    // 模拟一个消息队列，可重入锁，在put和take的过程线程安全
    public static ArrayBlockingQueue<Stuff> stuffsQueue = new ArrayBlockingQueue<Stuff>(10);

    public static void main(String[] args) {
        Provider provider = new Provider();
        try {
            provider.provideStuff();
        } catch (Exception e) {
            System.out.println("生产异常");
        }


        Consumer consumer = new Consumer(5);
        consumer.consumeStuff();
    }

}

// 模拟一个生产者生产一个苹果
class Provider {
    // 生产者参数 略
    public Provider() {
        //
    }

    public void provideStuff() throws InterruptedException {
        Stuff stuff = new Stuff();
        stuff.setId("00001"); //假设用id生成器产生的
        stuff.setName("苹果");
        Test.stuffsQueue.put(stuff);
        System.out.println("生产了一个苹果");
    }
}

// 消费者
class Consumer implements Runnable {
    private ThreadPoolExecutor executor =
            new ThreadPoolExecutor(10, 20, 60,
                    TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(10));

    // 消费者参数 略
    public Consumer() {
        //
    }

    public Consumer(int core) {
        //
        executor.setCorePoolSize(core);
    }

    public void consumeStuff() {
        executor.execute(this);
    }

    @Override
    public void run() {
        while (true) {
            try {
                Stuff stuff = Test.stuffsQueue.take();
                System.out.println("------获取物品，开始消费------" + stuff.toString());
            } catch (Exception e) {
                System.out.println("拿取物品失败，进入等待");
            }
        }
    }
}

class Stuff {
    private String id;
    private String name;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "{\"id\":\"" + id + "\",\"name\":\"" + name + "\"}";
    }
}