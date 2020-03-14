package ThreadTest.ix;


import java.util.concurrent.locks.LockSupport;

class Thread1 extends Thread{
    public Thread1(String name){
        super.setName(name);
    }

    @Override
    public void run(){
        System.out.println("--------"+getName());
        LockSupport.park();//停下
        System.out.println("++++++++"+getName());
    }
}
public class LockSupportDemo {
    public static Object obj = new Object();
    public static void main(String[] args) throws InterruptedException {
        Thread1 t1 = new Thread1("t1");
        Thread1 t2 = new Thread1("t2");
        t1.start();
        Thread.sleep(1000);
        t2.start();
        Thread.sleep(1000);
        LockSupport.unpark(t1);//可以走了
        Thread.sleep(1000);
        LockSupport.unpark(t2);

        //park,unpark使用不会出现死锁现象，不同于wait和notify
    }
}
