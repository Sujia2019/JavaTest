package BaseTest;

import java.util.Hashtable;
import java.util.concurrent.*;

/**
 * @author ：sujia
 * @date ：Created in 2020/12/3 4:44 下午
 * @description：集合学习
 * @modified By：
 * @version:
 */
public class CollectionTest {
    public static final ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
            3, 5, 50, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(10));

    public static void main(String[] args) {

    }

    public static void hashMapTest() {
        // 方法锁
        Hashtable<String, String> hashtable = new Hashtable<>();
        hashtable.put("a", "a");

    }

    public static void test3() {
        ConcurrentHashMap<String, String> chm = new ConcurrentHashMap<>();
        chm.put("a", "a");
    }

    class TestRunnable implements Runnable {
        String out;

        public TestRunnable(String out) {
            this.out = out;
        }

        @Override
        public void run() {
            System.out.println(out);
        }
    }
}
