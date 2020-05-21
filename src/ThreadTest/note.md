/**
 * This class provides thread-local variables(变量).  These variables differ from
 * their normal counterparts in that each thread that accesses one (via(通过) its
 * {@code get} or {@code set} method) has its own, independently initialized(初始化)
 * copy of the variable.  {@code ThreadLocal} instances(实例) are typically private
 * static fields in classes that wish to associate state with a thread (e.g.,
 * a user ID or Transaction ID).

  * <p>For example, the class below generates unique identifiers local to each
  * thread.下面的类生成每个线程本地的唯一标识符。
  * thread-local instances are subject to garbage collection (unless other
  * references to these copies exist).
  * 除非存在对这些副本的其他引用，否则线程本地实例将受到垃圾收集的影响。

 */
 
 **线程**是操作系统能够进行运算调度的最小单位

 ###学习名词：

 ####弱引用和强引用 (new对象强引用，点儿属性弱引用)
 ```Entry---->就是kv类似map的内部类---->内部类有啥作用```
 * **ThreadLocalMap**
 ```
    ThreadLocal实现主要涉及Thread，ThreadLocal，ThreadLocalMap这三个类。

    ThreadLocal特性
    ThreadLocal和Synchronized都是为了解决多线程中相同变量的访问冲突问题，不同的点是

    1,Synchronized是通过线程等待，牺牲时间来解决访问冲突
    2,ThreadLocal是通过每个线程单独一份存储空间，牺牲空间来解决冲突，并且相比于Synchronized，ThreadLocal具有线程隔离的效果，只有在线程内才能获取到对应的值，线程外则不能访问到想要的值。
    3,正因为ThreadLocal的线程隔离特性，使他的应用场景相对来说更为特殊一些。在android中Looper、ActivityThread以及AMS中都用到了ThreadLocal。当某些数据是以线程为作用域并且不同线程具有不同的数据副本的时候，就可以考虑采用ThreadLocal。

作者：ingxin
链接：https://www.jianshu.com/p/3c5d7f09dfbd
来源：简书
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 ```
 * **java.util.concurrent.atomic.*** 原子性，原子操作
 * **countdownlatch** 锁，同步等待  这里面的线程执行完之后才会执行下面的线程，通常countdownlatch(1)
 * **yeild**-----使线程暂停并允许其他线程执行
 * **死锁**-------互相都加了锁，互相调用，结果谁都进行不下去
    * //t.setDaemon   线程保护  像保镖一样，同时死
    * //t.join  线程同步   放try catch里
    * //t.setPriority(10);  排优先级，10是最低   但不是说设优先级最高就先跑
 * **synchronized**---------加令牌
    1. **类锁**(synchronized(静态对象))：类的所有对象都要竞争锁。
    2. **方法锁**(在方法前加synchronized)： 同一对象同一方法需要竞争锁。
    3. **对象锁**(synchronized(对象))：同一对象代码块竞争锁。
    * **JVM**
    
    * 在JVM中，根据锁的优化分为三种锁，偏向锁、轻量级锁、重量级锁，线程竞争越激烈，使用的锁等级越高，锁的转换过程不可逆，无法降级。
        1. 偏向锁
        ```
            乐观锁。
                对象头有一个标志 MarkWord 负责记录哪个线程获得了锁，如果已经记录了线程A，线程A可以直接进入，但是线程B进入时，会检测线程A是否活动。
            不活动：把标志MarkWord指向自己B。然后进入同步代码块。
            活动：等待线程A执行到安全点，挂起线程A。执行线程B。最后膨胀为轻量级锁。
        ```
        2. 轻量级锁
        ```
            乐观锁。
                升级轻量级锁后，线程A获得锁时，会在线程A的栈帧中创建“lock record”来记录(复制)对象头的MarkWord,并将对象头的MarkWord 更新为指向“lock record”的指针。如果更新失败了就会自旋有限次数，仍然失败就会膨胀为重量级锁。
        ```
        3.重量级锁
        ```
         悲观锁。
            如果线程A获取了对象的锁，其它线程会自旋有限次数，失败后线程B被阻塞挂起。线程A释放锁后唤醒所有阻塞的线程，一起竞争对象锁。阻塞线程之间不会排队等待，没有”先到先得“的原则。
        ```

 * **CLH和MCS**
    * 都是自旋：CLH(询问前一个有没有释放锁，释放了就结束自旋) MCS(询问自己这个位置有没有锁，别人给了你令牌你才可以用哦，本地自旋)
    * AQS：AbstractQuenedSynchronizer抽象的队列式同步器。
        是除了java自带的synchronized关键字之外的锁机制。
        AQS的全称为（AbstractQueuedSynchronizer）
    * AQS 定义了两种资源共享方式：
        1. Exclusive：独占，只有一个线程能执行，如ReentrantLock
        2. Share：共享，多个线程可以同时执行，如Semaphore、CountDownLatch、ReadWriteLock，CyclicBarrier
        3. 实现了AQS的锁有：自旋锁、互斥锁、读锁写锁、条件产量、信号量、栅栏都是AQS的衍生物

  * **CAS（比较并交换）**
    * 是CPU指令级的操作，只有一步**原子操作**，所以非常快,不可再分的操作。
  CAS算法，用CPU指令来实现无锁自增

  HashMap的优化   数组-链表-红黑树
  栅栏闭锁

  ####公平锁  谁等的时间长，谁先获得锁，
  ReentrantLock
  1. tryLock如果获得就执行没有就不执行（当一个任务获得锁的时候，必须等他执行完，其他线程获得了锁才能执行，再此期间没有获得锁的线程将不能执行）
  2. 资源同步（一个线程执行完，另一个线程再执行。一个接一个）
  3. 设置获得锁的时间（当再规定的时间内没有获得锁则放弃任务）
  4. 锁中断（当请求超过规定时间时可以中断锁，并抛异常）


  自旋锁 ，自旋锁的其他种类，阻塞锁，可重入锁 ，读写锁 ，
  互斥锁 ，悲观锁 ，乐观锁 ，公平锁 ，偏向锁， 对象锁，
  线程锁，锁粗化， 锁消除，轻量级锁，重量级锁， 信号量，
  独享锁，共享锁，分段锁

  悲观锁：(调度且清缓存) 中断(信号量SemaphoreV) poxis
  
  乐观锁：是无锁编程，常常采用的是CAS算法，典型的例子就是原子类，
  通过CAS自旋实现原子操作的更新。CPU原子操作
  Scheduler将调整公平树任务优先级(不清缓存)

  多线程递推RecursiveActionTest
  多线程递归RecursiveTaskTest

  Affinity.setAffinity(7);//第7个cpu
  可以设置在第几个cpu启动
  AffinityLock readerLock = al.acquireLock(DIFFERENT_SOCKET, DIFFERENT_CORE);
  //查看启动的线程
