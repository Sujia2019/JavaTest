package ClassLoader;

import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;

class Base{
    Base(){
        System.out.println("B");
    }
}

public class Test extends Base{
    public static void main(String[] args) {
//        Class c1 = ClassA.class;
//        ClassLoader cA = c1.getClassLoader();
//
//        Class c2 = ClassB.class;
//        ClassLoader cB = c2.getClassLoader();
//
//        Class i = MyInterface.class;
//        ClassLoader ci = i.getClassLoader();
//
//        System.out.println("A类和B类的classloader:"+cA.equals(cB));
//        System.out.println("A类和interface的classloader:"+cA.equals(ci));
//        System.out.println("B类和interface的classloader:"+cB.equals(ci));
        new Test();
        new Base();
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
    }
}
