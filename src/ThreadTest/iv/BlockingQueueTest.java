package ThreadTest.iv;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class BlockingQueueTest {
    public static void main(String[] args) throws InterruptedException {
        ArrayList list1 = new ArrayList();
        list1.add("aaa");

        CopyOnWriteArrayList list = new CopyOnWriteArrayList();
        list.add("a");
        ConcurrentHashMap map = new ConcurrentHashMap();
        map.put("","");


        //定义一个长度为2的阻塞队列
        BlockingQueue<String> bq = new ArrayBlockingQueue<>(2);
        bq.put("java");

//        bq.put("java");
//        bq.put("java");
//        System.out.println(bq.take());
//        bq.offer("aaa");
//        bq.offer("aaa");
        boolean b = bq.offer("aaa");
        System.out.println(bq.poll());
        System.out.println(b);
    }
}
