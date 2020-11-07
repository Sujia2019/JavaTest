package note 复习

        代码段
        数据段（BSS，数据段）
        函数栈
        堆

        static会放进一个特殊区

        锁*****

synchronized
class Myint {
    public static int i;
}
i++底层做了几件事？  load ，incr

        线程不安全：   t1 t2两个线程同时i++
        有可能的排序：
        load incr load incr，正常。但若load load incr incr就冲突了
        有原子一定会慢，因为是串行的
        令牌{    //做了一个原子的东西，还做了一件原子的事儿
        }
        无锁
        xxx（位置，是0就给改成1，不是就报错）相当于判断

public static synchronized void incr(){
        i++;      //加令牌
        }

public static void incr(){
synchronized(这里写加锁范围){
        i++;      //加令牌的第二种方法，加锁范围
        }
        }

        ps-ef 启动进程
        ps-ef|grep java 过滤grep 后面是关键字 jps 是java进程直接输就行 不加前面的东西。
        可以找到java进程 gostack进程号

        每个线程都在栈里
        死锁就不报错了就用这样的方法去找进程

        盲锁
        通过两次gostack看比较半分钟内没有变化的那个线程有问题

        线程调度解决活锁

        搞清楚内存位，Synchronized也会锁对象
        见手机照片；

class X {
    public int a = 10;

    public synchronized void xxx() {
        System.out.println("xxx" + "   a=" + a);
        while (true) ;
    }
}

class Y extends Thread {
    private X x;
    public int b = 10;

    public Y(X x) {
        this.x = x;
    }

    public void run() {
        synchronized (x) {
            int result = x.a + b;
            System.out.println("run" + "   result=" + result);
            while (true) ;
        }
    }
}

public class TestSyr {

    public static void main(String[] args) {
        X x = new X();
        X x2 = new X();
        Y y = new Y(x);
        y.start();
        x2.xxx();
        //如果写 x.xxx(); 因为锁的是一个位置，方法里都有死循环，所以第一个方法
        //没执行完不会执行第二个方法
        //共用了同一把锁，同一个位置只有一个锁（令牌）
    }
}
方法区的锁：
synchronized（A.class对象就是classinfo的对象） 锁classinfo！    对象.getClass（）也可以

        中断锁 底层实现
        自旋锁 省cpu 但不能及时调度
        时间片

        wait()函数
        a.wait()先归还令牌位，再把自己给隐了 看不见了，入死队列 睡眠
        a.notify()唤醒，进入活队列，不做还令牌 只能看见一个
        尽量使用notifyAll 唤醒的彻底 就是都能看见了 但只执行一个，因为就一个令牌


        轻锁*****
        lock()

        业务:读与读共享
        写与其他排他
        读写锁的实现


        单例对象 懒汉模型 饿汉模型

        栅栏闭锁
        时间线

        .pack
        .unpack

        sock core

        主频越高，线程跑的越好

        寻址 解析 锁存 计算 回写，释放

        池 算是个集合 有限数组 控制电路是串行的，有依赖关系

        线程池，防止线程申请太大
        ExecutorService pool1=Executors.newCachedThreadPool();
        //用的最多

        代码，栈单元乱序的

        内存屏障（是个什么鬼）在编译器中的作用，防止乱序 while(true)底层是true，所以最好不在里面加判断，最好在while循环内部加if break判断。

        atmt 汇编

        伪共享 Concurrent包多看