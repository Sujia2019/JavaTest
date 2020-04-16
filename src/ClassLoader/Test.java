package ClassLoader;

import jdk.nashorn.internal.runtime.linker.Bootstrap;

import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;

//class Base{
//    Base(){
//        System.out.println("B");
//    }
//}

public class Test {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
//        Class c1 = ClassA.class;
//        ClassLoader cA = c1.getClassLoader();
//
//        Class c2 = ClassB.class;
//        ClassLoader cB = c2.getClassLoader();
//
//        Class i = MyInterface.class;
//        ClassLoader ci = i.getClassLoader();
//
//        System.out.println("A类和B类的classloader:"+cA.equals(cB)+"----"+cA.getClass());
//        System.out.println("A类和interface的classloader:"+cA.equals(ci)+"----"+cA.getClass().getClassLoader());
//        System.out.println("B类和interface的classloader:"+cB.equals(ci)+"----"+cB.getClass());
//
//        System.out.println(ci);
//        System.out.println("ClassLoader----"+Bootstrap.class.getClassLoader());

//        new Test();
////        new Base();
//        PreparedStatement
//        CallableStatement
//        InputStream

//        Integer var1=new Integer(1);
//        Integer var2=var1;
//        doSomething(var2);
//        System.out.print(var1.intValue());
//        System.out.print(var1==var2);
//    }
//    public static void doSomething(Integer integer){
//        integer=new Integer(2);
//    }

        MyClassLoader my = new MyClassLoader("E:\\Project\\JavaTest\\src\\ClassLoader\\","random");
        Class c = my.loadClass("Hello");
        System.out.println(c.getClassLoader());
        Object o = c.newInstance();
    }
}
