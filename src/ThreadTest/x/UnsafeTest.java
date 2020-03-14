package ThreadTest.x;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class UnsafeTest {
    private static Unsafe unsafe;
    static {
        try{
            //通过反射获取rt.jar下的Unsafe类
//            1）、Unsafe类的构造函数是私有的；
//            2）、虽然它有静态的getUnsafe()方法，但是如果你尝试调用Unsafe.getUnsafe()，会得到一个SecutiryException。这个类只有被JDK信任的类实例化。
//            但是这总会是有变通的解决办法的，一个简单的方式就是使用反射进行实例化
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe)field.get(null);
        }catch (Exception e){
            System.out.println("Get Unsafe instance occur error "+"\n"+e);
        }
    }

    public static void main(String[] args) {
//        Class clazz = Target.class;
//        Field[] fields = clazz.getDeclaredFields();
//        System.out.println("fieldName:fieldOffset");
//        for(Field f:fields){
//            //获取属性偏移量，可以通过这个偏移量给属性设置
//            System.out.println(f.getName()+":"+unsafe.objectFieldOffset(f));
//        }
//        Target target = new Target()
    }
}
