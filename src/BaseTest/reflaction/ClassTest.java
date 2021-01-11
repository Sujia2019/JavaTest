package BaseTest.reflaction;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author ：sujia
 * @date ：Created in 2020/12/16 7:42 下午
 * @description：
 * @modified By：
 * @version:
 */
public class ClassTest {
    public static void main(String[] args) throws Exception {
        test1();
    }

    // Class.forName
    public static void test1() throws Exception {
        Class yc = Class.forName("BaseTest.reflaction.Y");
        // 获取构造器
        Constructor cc = yc.getConstructor();
        XY xy1 = (XY) yc.newInstance();
        XY xy2 = (XY) cc.newInstance();

        xy1.show();

        XY x = new X();

        Class xc = Class.forName("BaseTest.reflaction.X");
        System.out.println(xc.isInstance(x));
        System.out.println(xy2 instanceof XY);
        System.out.println(xy1 instanceof XY);
        System.out.println(xy1.getClass() == Y.class);
    }

    public static void test2() throws Exception {
        Class modelClass = Class.forName("BaseTest.reflaction.ClassModel");
        showFields(modelClass);
        showMethods(modelClass);
        showConstructors(modelClass);
    }

    /* 得到该类的所有数据字段 */
    public static void showFields(Class c) {
        Field fields[] = c.getDeclaredFields();
        for (Field f : fields) {
            // 1./*数据字段修饰符*/
            String m = Modifier.toString(f.getModifiers());
            // 2./*字段数据类型名*/
            Class type = f.getType();
            String t = type.getName();
            // 3./*类的属性名称*/
            String n = f.getName();
            System.out.println(m + " " + t + " " + n);
        }
    }

    /* 得到构造器 */
    public static void showConstructors(Class c) {
        Constructor[] cons = c.getDeclaredConstructors();
        for (Constructor con : cons) {
            String m = Modifier.toString(con.getModifiers());
            String n = con.getName();
            System.out.print(m + " " + n + "(");
            Class[] params = con.getParameterTypes();
            for (int j = 0; j < params.length; j++) {
                if (j == params.length - 1) {
                    System.out.print(params[j].getSimpleName());
                } else
                    System.out.print(params[j].getSimpleName() + ",");
            }
            System.out.println(")");
        }
    }

    /* 得到类里所有方法 */
    public static void showMethods(Class c) {
        Method[] m = c.getMethods();
        for (int i = 0; i < m.length; i++) {
            /* 方法修饰符 */
            String modify = Modifier.toString(m[i].getModifiers());
            System.out.print(modify + " ");
            /* 方法返回类型 */
            Class returntype = m[i].getReturnType();
            System.out.print(returntype.getName() + " ");
            /* 方法名称 */
            String name = m[i].getName();
            System.out.print(name + "(");
            /* 方法参数 */
            Class[] params = m[i].getParameterTypes();
            for (int j = 0; j < params.length; j++) {
                if (j == params.length - 1) {
                    System.out.print(params[j].getSimpleName());
                } else
                    System.out.print(params[j].getSimpleName() + ",");
            }
            System.out.println(")");
        }
    }
}
