package BaseTest;

import org.springframework.util.CollectionUtils;

import java.util.*;
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

    public static ArrayList<Integer> array = new ArrayList<>();
    public static int number = 0;

    public static void main(String[] args) {
//        Collections
//        Collection
        // 顺序执行
//        threadPool.submit(new Arr());
//        threadPool.submit(new Arr());
//        threadPool.submit(new Arr());
    }

    /**
     * 线程安全问题
     */
    public static void c2() {
        new Thread(() -> {
            while (number < 100) {
                array.add(0);
                System.out.println(array.size());
                number++;
            }
        }).start();
    }

    static class Arr implements Runnable {
        @Override
        public void run() {
            while (number < 100) {
                array.add(0);
                System.out.println(array.size());
                number++;
            }
        }
    }

    public static void copyOnWrite() {
        // 写时复制 Arrays.copy
        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();
    }

    public static void arrayThings() {
//        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        List<Integer> list1 = Collections.synchronizedList(list);

        // 几种排序策略   29  47   286
        Arrays.sort(list.toArray());
    }

    public static void c1() {
        ArrayList<Integer> testList = new ArrayList<>();
        testList.add(10);
        testList.add(7);
        testList.add(6);
        testList.add(19);
        testList.add(1);
        int re = testList.get(2);

        ArrayList<Mode> testList2 = new ArrayList<>();
        testList2.add(new Mode("n1", "r1", 10));
        testList2.add(new Mode("n2", "r2", 7));
        testList2.add(new Mode("n3", "r3", 6));
        testList2.add(new Mode("n4", "r4", 19));
        testList2.add(new Mode("n5", "r5", 1));

        /*
         * 返回空集合
         */
        List list = Collections.EMPTY_LIST;
        /*
         * 集合查找 二分查找
         */
        int index = Collections.binarySearch(testList2, 6, new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Mode && o2 instanceof Mode) {
                    Mode m1 = (Mode) o1;
                    Mode m2 = (Mode) o2;
                    return m1.getNumber() - m2.getNumber();
                }
                return 0;
            }

            @Override
            public boolean equals(Object obj) {
                return false;
            }
        });
        System.out.println(index);
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
