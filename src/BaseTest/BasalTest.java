package BaseTest;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author ：sujia
 * @date ：Created in 2020/12/15 8:26 下午
 * @description：
 * @modified By：
 * @version:
 */
public class BasalTest {
    public static void main(String[] args) {
        int i=1;
        System.out.println(++i);
        System.out.println(i);
//        short a =1;
        String a = "a"+2;
//        Arrays.copyOfRange()
        a = "b";
//        ArrayList
        System.out.println(a);
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
