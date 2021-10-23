package BaseTest;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author ：sujia
 * @date ：Created in 2020/12/15 8:26 下午
 * @description：
 * @modified By：
 * @version:
 *
 * java基础
 */
public class BasalTest {
    public static void main(String[] args) {
        int i=1;
        // ++i 先+再赋值
        System.out.println(++i);
        // i++ 先赋值再+
        System.out.println(i++);

        String a = "a"+2;
        // 实际上是StringBuilder做的事
        StringBuilder builder = new StringBuilder("a");
        builder.append(2);
        a = builder.toString();

        //  虽然String不可以被继承，是用final修饰的，String对象是不可变的
        //  s只是一个String对象的引用，并不是对象本身。对象在内存中是一块内存区，成员变量越多，这块内存区占的空间越大。
        //  引用只是一个4字节的数据，里面存放了它所指向的对象的地址，通过这个地址可以访问对象。
        //  也就是说，s只是一个引用，它指向了一个具体的对象，当s=“123”;
        //  这句代码执行过之后，又创建了一个新的对象“123”， 而引用s重新指向了这个新的对象，原来的对象“ABC”还在内存中存在，并没有改变。
        String s = "ABC";
        s = "123";

        // ==和equals的区别
        // ==是一个操作符，用来判断两个对象是否为同一个对象，一般的对象都会去判断两个对象在内存当中的地址，当地址一样时证明是同一个对象，返回true。
        // 但是关于字符串，由于字符串是存在字符串常量池中，创建的String对象会指向常量池，如果String s1 和String s2赋值一样时，两个对象指向的是同一字符串位置，所以 == 返回true
        // equals是一个方法，可以通过重写来自定义两个对象是否相等，String重写了equals方法，即使我们new两个不一样的string对象但赋予相同的字符串值，它也会去判断值是否相同
        // 如果没有重写，默认还是判断是否为同一个对象。Object类当中定义的equals方法返回的是 "this == obj"
        String s1 = "xxx";
        String s2 = "xxx1";
        Object o1 = new Object();
        Object o2 = new Object();
        System.out.println(s1==s2);

        //   继承与多态
        // * 继承父类的方法，可以重写父类的方法实现想要的，某些字段不可继承 private， final， static
        // * 基类(父类)也可以使用派生类(子类)重写的方法，但不可以使用子类特定的方法

        short aa = 1;
        aa+=1;
        aa = (short) (aa+1);

//        ThreadLocal

        System.out.println(s);
    }

    public static final class FinalTest{
        public String name;
        public int age;
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
