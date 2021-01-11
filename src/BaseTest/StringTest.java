package BaseTest;

/**
 * @author ：sujia
 * @date ：Created in 2020/12/16 3:55 下午
 * @description：
 * @modified By：
 * @version:
 */
public class StringTest {
    public static void main(String[] args) {
        contains();
    }

    public static void contains() {
        String x = "|";
        String[] xs = x.split("\\|");
        for (String s : xs) {
            System.out.println(s);
        }
        System.out.println(xs.length);
    }

    /**
     * StringBuilder和StringBuffer都继承ABS
     */
    public static void stringBuilder() {
        StringBuilder builder = new StringBuilder("");
        // sync 直接上锁
        StringBuffer buffer = new StringBuffer("");

//        String final修饰了 不可以被继承
    }
}
