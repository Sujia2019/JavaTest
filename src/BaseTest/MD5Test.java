package BaseTest;

import org.springframework.util.DigestUtils;
import sun.misc.BASE64Encoder;

import java.util.Arrays;
import java.util.Base64;

/**
 * @author ：sujia
 * @date ：Created in 2020/12/7 8:55 下午
 * @description：
 * @modified By：
 * @version:
 */
public class MD5Test {
    public static void main(String[] args) {
//        DigestUtils.md5Digest("osc-admin".getBytes());
//        String base64Private = new BASE64Encoder().encode("800P_xuhd".getBytes());
//        System.out.println(base64Private);
//        System.out.println(DigestUtils.md5DigestAsHex(new BASE64Encoder().encode("osc-admin".getBytes()).getBytes()));
//        Integer[] ins = new Integer[]{1,2,3,4,5};
//        System.out.println(Arrays.toString(ins));
        String xxx = "[1,2,3,4,5]";
        xxx = xxx.substring(1, xxx.length() - 1);
        String[] xs = xxx.split(",");
        System.out.println(xxx);
        System.out.println(Arrays.toString(xs));
        for (String s : xs) {
            System.out.print(s.length());
        }

    }
}
