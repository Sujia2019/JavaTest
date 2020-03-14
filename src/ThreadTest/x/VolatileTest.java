package ThreadTest.x;

import java.util.concurrent.CountDownLatch;

public class VolatileTest {
    public volatile int inc = 0;
    public void increase(){
        inc++;
    }

    public static void main(String[] args) throws InterruptedException {
        final VolatileTest test = new VolatileTest();
        final CountDownLatch cdl = new CountDownLatch(10);
        for(int i=0;i<10;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int j=0;j<1000;j++){
                        test.increase();
                    }
                    cdl.countDown();
                }
            }).start();
        }
        cdl.await();
        System.out.println(test.inc);
    }
}
