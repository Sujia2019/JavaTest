package BaseTest;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author ：sujia
 * @date ：Created in 2020/12/3 4:44 下午
 * @description：线程部分
 * @modified By：
 * @version:
 */
public class ThreadTest {
    public static void main(String[] args) {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(3, 5,
                1, TimeUnit.SECONDS, new ArrayBlockingQueue<>(3));
        pool.submit(new Test("1号"));
        pool.submit(new Test("2号"));
        pool.submit(new Test("3号"));
        pool.submit(new Test("4号"));
        pool.submit(new Test("5号"));
        pool.submit(new Test("6号"));
        pool.submit(new Test("7号"));
        pool.submit(new Test("8号"));
        pool.submit(new Test("9号"));
    }

    static class Test implements Runnable {
        String name;

        Test(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println(name + "，睡前");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + "，睡后");
        }
    }
}
