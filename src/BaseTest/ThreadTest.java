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
//        threadPoolTest();
        threadLocalTest();
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

    private static void threadPoolTest() {
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

    private static void threadLocalTest() {
        User user1 = new User();
        user1.setName("test111");
        ThreadLocal<User> threadLocal = new ThreadLocal<>();
        threadLocal.set(user1);
        User user2 = threadLocal.get();
        user2.setName("222");
        System.out.println(threadLocal.get().getName());
    }

    static class User {
        String name;

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }
    }
}
