package ThreadTest.iii;

class A{
    public synchronized void f1(B b){
        System.out.println("当前线程名："+Thread.currentThread().getName()
                +"进入了A实例的f1方法");
        try{
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("当前线程名："+Thread.currentThread().getName()
                +"企图调用B实例的f4方法");
        b.f4();

    }
    public synchronized void f2(){
        System.out.println("进入了A类的last()方法内部");
    }
}
class B{
    public synchronized void f3(A a){
        System.out.println("当前线程名："+Thread.currentThread().getName()
                +"进入了B实例的f3方法");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("当前线程名："+Thread.currentThread().getName()
                +"企图调用A实例的f2方法");
        a.f2();
    }

    //因为我加了锁，导致我这个线程没跑完，A无法去调用我B里的这个方法，同样也无法调A里的方法，就死锁了，互斥了，俩人都没法走了
    public synchronized void f4(){
        System.out.println("进入了B类方法的内部f4方法");
    }
}
public class DeadLock implements Runnable{
    A a = new A();
    B b = new B();

    public void init(){
        Thread.currentThread().setName("主线程");
        a.f1(b);
        System.out.println("进入了主线程之后");
    }

    public void run(){
        Thread.currentThread().setName("副线程");
        b.f3(a);
        System.out.println("进入了副线程之后");
    }

    public static void main(String[] args) {
        DeadLock dl = new DeadLock();
        new Thread(dl).start();
        dl.init();
    }














}
