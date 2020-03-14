package ThreadTest.ix;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierTest {
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(3);
        //如果将参数改为4，但是下面只加入了3个选手，这永远等待下去
        //Waits until all parties have invoked await on this barrier.
        ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.submit(new Thread(new Runner(barrier,"1")));
        executor.submit(new Thread(new Runner(barrier,"2")));
        executor.submit(new Thread(new Runner(barrier,"3")));
        executor.shutdown();
    }
}

class Runner implements Runnable{
    private CyclicBarrier barrier;
    private String name;
    public Runner(CyclicBarrier cb,String name){
        super();
        this.barrier=cb;
        this.name=name;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println(name+"准备好了....");
//            System.out.println(barrier.getParties());
            barrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(name+"----起跑！");
    }
}
