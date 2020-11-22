package ThreadTest;


import java.nio.channels.Channel;
import java.util.HashMap;
import java.util.concurrent.*;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class Test {
    public static volatile boolean flag = true;
    public static void main(String[] args) {
//        AtomicIntegerArray atest = new AtomicIntegerArray(10);
//        atest.set(1,10);
//        System.out.println(atest.toString());
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        HashMap<Integer, Integer> hash = new HashMap<>();
        map.put("123", "456");
        Task t1 = new Task();
        Task2 t2 = new Task2();
//        ExecutorService pool = Executors.newSingleThreadExecutor();
//        pool.submit(t1);
//        flag = false;
//        pool.execute(t2);
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        service.scheduleWithFixedDelay(t1,500,500, TimeUnit.MILLISECONDS);
//        flag = false;
        service.scheduleWithFixedDelay(t2,500,500,TimeUnit.MILLISECONDS);
//        flag = true;

        Task3 t3 = new Task3();
        service.scheduleWithFixedDelay(t3,2,2,TimeUnit.SECONDS);
//        Channel
//        AbstractQueuedSynchronizer


    }

    private static class Task implements Runnable{
        int i=0;

        @Override
        public void run() {
            if (flag){
                System.out.println("---------"+i++);
            }
        }
    }

    private static class Task2 implements Runnable{
        int i=0;

        @Override
        public void run() {
            if (!flag){
                System.out.println("++++++++++"+i++);
            }
        }
    }

    private static class Task3 implements Runnable{

        @Override
        public void run() {
            if(flag){
                flag = false;
            }else{
                flag = true;
            }
        }
    }
}

