package note 运算符重载

        单目
        ++--a++意思是a.++()
        双目
        +a+b a.+(b)+(a,b)
        地址

        cout<<"aaa"<<1;
        iostream 输入输出流，重载i，o
        template<

class T>

class ostream {
    ostream operator<<(T &t)//调用硬件操作的api（t）
            return this;
}

    istream ostream !!!看程序例子opt

        三目运算符不能重载，问号冒号

        重载new运算符 new可以调用malloc
        void*operator new(size_t sz){
        cout<<"new"<<sz<<"/t"<<"sizeof(test)";
        void*p=malloc(sz);
        return p;
        }


        应用程序接口 API 函数也是接口
        1）内存 c----操作系统 堆 栈 数据端 代码端
        2）java JVM java JIT 编译原理just in time，半编译器，自启一个虚拟机，进行语句翻译，解释执行
        gc 垃圾回收，自己释放 内存管理格式结构是为了gc更好释放 java没有数据端
        java有自己的存储结构。内存结构！！！！
        jvm中的堆有一个永久代（不回收）存 static，方法区，ip，字符串常量池 四个区，不释放的metaspace元数据区 又申请 堆内存用于 压缩和 解压缩
        元数据用于描述数据。
        硬盘 不擦除，可复写。误删文件，元数据丢了，数据没丢！文件恢复，重新写一个元数据指向硬盘里那个位置。
        并行回收 垃圾回收器（嗑瓜子扫垃圾）回收方式：标记清除法（快），复制算法，标记压缩（整理）法（慢）
        标记方式： 引用计数器，根扫描
        java申请一大块内存， 头 指针 空闲链表
        生命周期 分代垃圾回收 分格算法
        （parnew G1）



        多线程
        并发多任务 一会儿跳这一会儿跳那
        并行多任务 多核 两个同时执行，对一个CPU来讲是只执行一个 smp多核调度理论

        UEFI
        内核线程
        分段模式符
        syscall
        内核只有内核线程 进程
        用户线程 thread local 进程和线程的区别是内存是否共享，内核不存在进程的概念，内核中是线程

        sh
        bash 什么玩意？

        runnable,run()

class Mytask implements Runnable {
    public void run() {
        System.out.println("ok");
    }
}

public class Test {
    public static void main(String args[]) {
        Mytask m = new Mytask();
        Thread t = new Thread(m);    //   <-----m 相当于目标target
        t.start;
        //t.setDaemon   线程保护  像保镖一样，同时死
        //t.join  线程同步   放try catch里
        //t.setPriority(10);  排优先级，10是最低   不是说设优先级最高就先跑
        System.out.println("ok");
    }
}

楼梯算法




