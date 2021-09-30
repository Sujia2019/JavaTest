# Java基础

## 数据类型
* 基本数据类型：byte，char，short，int，long，boolean，double，float
* 引用数据类型(非基本数据类型)

## == 和 equals的区别
1. 功能不同
    * "=="是判断两个变量或实例是不是指向同一个内存空间。
    * "equals"是判断两个变量或实例所指向的内存空间的值是不是相同。
2. 定义不同
    * "equals"在JAVA中是一个方法。
    * "=="在JAVA中只是一个运算符合。
    * == 比较的是变量(栈)内存中存放的对象的(堆)内存地址，
    用来判断两个对象的地址是否相同，即是否是指相同一个对象。比较的是真正意义上的指针操作。   
    1. 比较的是操作符两端的操作数是否是同一个对象。
    2. 两边的操作数必须是同一类型的（可以是父子类之间）才能编译通过。
    3. 比较的是地址，如果是具体的阿拉伯数字的比较，值相等则为true，如：
    4. int a=10 与 long b=10L 与 double c=10.0都是相同的（为true），因为他们都指向地址为10的堆。
* equals：

        equals用来比较的是两个对象的内容是否相等，
        由于所有的类都是继承自java.lang.Object类的，
        所以适用于所有对象，如果没有对该方法进行覆盖的话，
        调用的仍然是Object类中的方法，而Object中的equals方法返回的却是==的判断。
        
* 用于判断两个变量是否是对同一个对象的引用，即堆中的内容是否相同，返回值为布尔类型                        
* String类型比较不同对象内容是否相同，应该用equals，因为==用于比较引用类型和比较基本数据类型时具有不同的功能。
```java
public class test1 {
    public static void main(String[] args) {
        String a = new String("ab"); // a 为一个引用
        String b = new String("ab"); // b为另一个引用,对象的内容一样
        String aa = "ab"; // 放在常量池中
        String bb = "ab"; // 从常量池中查找
        if (aa == bb) // true
            System.out.println("aa==bb");
        if (a == b) // false，非同一对象
            System.out.println("a==b");
        if (a.equals(b)) // true
            System.out.println("aEQb");
        if (42 == 42.0) { // true
            System.out.println("true");
        }
    }
}
```
## 继承与多态
* 继承父类的方法，可以重写父类的方法实现想要的，某些字段不可继承 private， final， static
* 基类(父类)也可以使用派生类(子类)重写的方法，但不可以使用子类特定的方法

## HashMap
* 一些常用方法 keySet获取所有的key entrySet获取所有的k，v；

## Object类中的方法有哪些
* wait(),notify(),notifyAll(),equals(),toString(),getClass(),hashCode()

## String、StringBuffer、StringBuilder
* 如果单单去用String拼字符串，会创建多个String对象，用StringBuilder去拼接字符串会节约资源空间。是不可变对象
* StringBuffer线程安全，StringBuilder线程不安全

## 接口的意义
规范、扩展、回调

## 接口和抽象类
在java开发中90%使用的都是接口，抽象类往往只是实现一个过渡。抽象类定义的抽象方法与接口定义的方法有点不同，抽象类定义的方法父类不要求子类强制覆写，接口定义的方法，其实现子类必须覆写。

具体情况具体分析，举例如下：

如果你 **拥有一些方法并且想让它们中的一些有默认实现**，那么使用抽象类吧。

如果你想实现**多重继承**，那么你**必须使用接口**。由于Java不支持多继承，子类不能够继承多个类，但可以实现多个接口。因此你就可以使用接口来解决它。

如果基本功能在不断改变，那么就需要使用抽象类。如果不断改变基本功能并且使用接口，那么就需要改变所有实现了该接口的类。