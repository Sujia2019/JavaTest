package note chi------集合

        （堆内存-已经使用的堆内存）/栈内存=jre线程最大值
        启动线程，最多七百多，启多了会报错

        task_struct(sp,ip)

        push t.ip
        ret

        纯java/封装c的

        本地 c溢出 stack overflow：native thread native指的是本地指令bulabula

        ***读一下Executors源代码

public class ThreadPoolTest {
    public static void main(String[] args)
            throws Exception {
        // 创建足够的线程来支持4个CPU并行的线程池
        // 创建一个具有固定线程数（6）的线程池

        ExecutorService pool1 = Executors.newCachedThreadPool();
        ExecutorService pool2 = Executors.newScheduledThreadPool(100);
        //设置什么时候真正qidong启动线程
        ExecutorService pool3 = Executors.newSingleThreadExecutor();
        //特殊需求
        ExecutorService pool = Executors.newFixedThreadPool(2);
        // 使用Lambda表达式创建Runnable对象
        Runnable target = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println(Thread.currentThread().getName()
                            + "的i值为:" + i);
                }
            }


        };
        // 向线程池中提交两个线程
        pool.execute(target);
        pool.submit(target);

        Thread.sleep(5000);
        pool.execute(target);
        // 关闭线程池
        pool.shutdown();
//        pool.execute(target);
    }
}
启线程池，启一个之后，下一个会判断上一个是否归还，定义一个线程上限，超过的线程会堵塞，造成服务假死


        所有的树 索引结构

        java线程和内核线程不是一一对应
        是一对多，可以节约调度时间
        两次启动，在JVMstart 后到内核中启

        JVM查找java启动的线程 jps
        jstack 线程号
        "VM Thread"os_prio=0tid=0x00007f8e14137000nid=0x122brunnable
        启动JVM
        两种启法-client c1编译器
        -server c2编译器

        线程报错 相当于throws 自己写的，很少用

class MyExHandler implements Thread.UncaughtExceptionHandler {
    // 实现uncaughtException方法，该方法将处理线程的未处理异常
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println(t + " 线程出现了异常：" + e);
    }
}

public class ExHandler {
    public static void main(String[] args) {
        // 设置主线程的异常处理器
        Thread.currentThread().setUncaughtExceptionHandler
                (new MyExHandler());
        int a = 5 / 0;
        System.out.println("aaaaa程序正常结束！");
    }
}

内存屏障

        伪共享问题*****不会联系代码

        共享

        多核

        linux
        任务门 结构体gss 绑给cpu wintel微软 几个cpu就有几个gss
        linux 一个gss改瓤
        调用门（没人用了！）  powerpc sparc x86（现用） arm
        缺陷门（系统门）  由软件引发的中断
        printf（） r3 syscall（）汇编__asm__(movl x,%rax,int 80h)
        中断门 rtc 由硬件引发的中断，走中断门

        r0（内核）-r3

        git里查找 openhft 第三方框架
        Affinity.setAffinity(7);//第7个cpu
        可以设置在第几个cpu启动
        AffinityLock readerLock=al.acquireLock(DIFFERENT_SOCKET,DIFFERENT_CORE);
//查看启动的线程

        悲观锁 乐观锁trylock
        轻量级锁、重量级锁

        自旋锁（轻量级锁）、阻塞锁（中断锁）重量级锁

        信号量 while循环判断

        bitmap 映射
        悲观锁lock.lock
        乐观锁b=lock.trylock 自己实现锁
        锁标记 线程安全 多线程只标记一个

        compareAndSwap（i，0,1）  cas

        公平锁（一通哄抢） 非公平锁（排队）

        锁底层队列实现 aqs

        ******clh（rl）  mcs 两种锁

        ***实现一个mcslock

        递归 递推 看有没有返回值

        多线程递推RecursiveActionTest
        多线程递归RecursiveTaskTest

        只要一t.fork就变两个线程，分两个线程
        t.join等待这个线程执行完

        有返回值的线程
        promusefuture

public class CallableAndFuture {
    public static void main(String[] args) {
        Callable<Integer> callable = new Callable<Integer>() {
            public Integer call() throws Exception {
                Thread.sleep(2000);
                return new Random().nextInt(100);
            }
        };
        FutureTask<Integer> future = new FutureTask<Integer>(callable);
        //需要封装 传到结果集队列里
        //用线程重启
        new Thread(future).start();
        try {
            System.out.println(future.get());//从队列里拿东西，没有就死在这 future
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

class Task implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("子线程在进行计算");
        Thread.sleep(3000);
        int sum = 0;
        for (int i = 0; i < 100; i++)
            sum += i;
        return sum;
    }
}

012对tty的操作
        1正确2错误
        System.in// 0
        System.out// 1
        System.err//2号文件描述符

        内核开发调试语句/proc

        io
        file.mkdir（）
        file.mkdirs()可以建文件夹
        file.createTempFile（）
        deleteOnExit（） 临时文件

        java不能读硬件，但C可以
        java只能读文件，FileInputStream

        写入磁盘的方式 两种 流送（串行）和映射（并行） 都序列化
        nio
        bio 一个字节一个字节往里写
        字节流 byte[]b="".getBytes()
        new String(b,"utf-8");


        object-->byte数组里-->JVM-->内存缓冲区-->硬盘寄存器
        底层sync
        flush 写入硬盘   \n自动代表一次flush 只认最后一个\n

        可擦写 ram
        不可擦写 rom
        可写 ram   ↓
        可重写，可一次写

        文件尾指针 EOF

        字符流（底层永远是字节流，把字节流生成为字符流）

        文件输入形式写tty
        InputStreamReader（System.in） 字符流 或者写文件
        BUfferReader
        PrintStream（System.out） 或者写文件    //设备流，可以换设备 写文件，写网络
        感觉在写文件，实际在写内存

        System.setIn(文件)，从文件中输入---
        System.setOut（文件），从文EOF件中输出，再System.out的时候就在文件中打印了


