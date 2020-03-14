package ThreadTest.x;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTest {
    public int xl;
    public AtomicInteger inc = new AtomicInteger(0);
    public void increase(){
        inc.getAndAdd(1);
    }
    public void increase2(){
        xl++;
        //此操作不原子，导致不一定等于10000
    }

    public static void main(String[] args) throws InterruptedException {
        final AtomicTest test = new AtomicTest();
        final CountDownLatch cdl=new CountDownLatch(10);
        for(int i=0;i<10;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int j=0;j<1000;j++){
                        test.increase();
                        test.increase2();
                    }
                    cdl.countDown();
                }
            }).start();
        }
        cdl.await();
        System.out.println(test.inc.get());
        System.out.println(test.xl);
    }
}
