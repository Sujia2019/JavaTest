package beauty;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ：sujia
 * @date ：Created in 2020/11/27 4:00 下午
 * @description：代码整洁之道-注释
 * @modified By：
 * @version: 0.0.1-snapshot
 */
public class DocTest {
    public static void main(String[] args) {
//        HashMap<String,String>
        // 单行注释
        System.out.println("单行注释");
        /*
        多行注释
         */
        System.out.println("多行注释");

        test(null);
    }

    /**
     * 块注释
     *
     * @param a 被加数
     * @param b 加数
     * @return 和
     */
    public static int add(int a, int b) {
        return a + b;
    }

    public static boolean validate(String a, String b) {
        // TODO 校验参数合法性
        // FIXME 更加细分一些，常用TODO标记
        return a.equals(b);
    }

    public static void test(String test) {
        List<String> list = Arrays.asList(test.split(",")).stream().collect(Collectors.toList());
        for (String str : list) {
            System.out.println(str);
        }
    }
}
