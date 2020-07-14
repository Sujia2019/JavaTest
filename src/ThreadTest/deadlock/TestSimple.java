package ThreadTest.deadlock;
//最简单的一种死锁，互相调用 加锁
class A{
    int i=0;
    public B b = new B();
    public void doAdd(){
        synchronized (A.class){
            i++;
            System.out.println("A:"+i);
            b.doAdd();
        }
    }
}
class B{
    int i=0;
    public A a = new A();
    public void doAdd(){
        synchronized (B.class){
            i++;
            System.out.println("B:"+i);
            a.doAdd();
        }
    }
}
public class TestSimple {
    public static void main(String[] args) {
        A aa = new A();
        B bb = new B();
        aa.doAdd();
        bb.doAdd();
    }
}
