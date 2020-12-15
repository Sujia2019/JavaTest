package BaseTest;

/**
 * @author ：sujia
 * @date ：Created in 2020/12/15 8:26 下午
 * @description：
 * @modified By：
 * @version:
 */
public class BasalTest {
    public static void main(String[] args) {
        System.out.println(tryCatchTest("1"));
    }


    /**
     * 先打印finally再return
     *
     * @param name
     * @return
     */
    public static String tryCatchTest(String name) {
        try {
            int i = Integer.parseInt(name);
            return Integer.toString(i);
        } catch (Exception e) {
            return "catch error";
        } finally {
            System.out.println("hello");
        }
    }
}
