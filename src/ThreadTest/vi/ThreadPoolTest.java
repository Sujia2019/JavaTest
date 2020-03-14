package ThreadTest.vi;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTest {
    public static void main(String[] args) throws InterruptedException {
        //创建足够的线程来支持4个cpu并行的线程池
        //创建一个具有固定线程数(6)的线程池
        ExecutorService pool1 = Executors.newCachedThreadPool();
        ExecutorService pool2 = Executors.newScheduledThreadPool(100);
        ExecutorService pool3 = Executors.newSingleThreadExecutor();

        ExecutorService pool4 = Executors.newFixedThreadPool(2);

        Runnable target = new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<100;i++){
                    System.out.println(Thread.currentThread().getName()
                            +"的i值为："+i);
                }
            }
        };
        pool3.execute(target);
        pool3.submit(target);
        Thread.sleep(5000);
        pool3.execute(target);
        pool3.shutdown();
    }
}
