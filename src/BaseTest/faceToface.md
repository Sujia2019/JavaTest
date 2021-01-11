## 问题总结：

#### Collection和Collections有什么区别
* collection是一个接口,有很多集合实现类继承了这个接口
* collections提供了很多实现好的方法，给集合排序，和线程安全的集合如SynchronizedList，set,map,sortMap等


#### 装饰器模式的应用
#### mybatis执行过程
#### 你了解哪些回调模型
#### 如何在外部获取一个类的私有属性 - 反射
#### 如何打印文件中的信息- 输入输出流 设计模式


tomcat配置JVM参数
#### http状态码 -这大哥从400问到405 又问了503
* 403-Forbidden
* 405-Method Not Allowed

http basic
#### put和patch的区别
* patch 局部更新，后端仅更新接收到的字段。
* put 也是更新资源，但要求前端提供的一定是一个完整的资源对象，
#### 前端跨域请求怎么实现
* nginx代理跨域
* websocket
* 跨域资源共享（CORS）
* node.js中间键代理跨域

#### 讲一讲如何保证线程安全
* 从线程安全问题产生的角度想解决方案
#### 线程池 有哪些
* Executors.newCachedThreadPool()
* Executors.newScheduledThreadPool(int corePoolSize)
* Executors.newSingleThreadExecutor()
* Executors.newFixedThreadPool(int threadNumber);

HashMap ConcurrentHashMap
copyOnWriteArrayList，
#### 悲观锁 乐观锁
* 悲观锁，具有强烈的独占和排他特性，直接对该数据上锁，开销大 java中sync和reetrantlock都属于悲观锁
* 乐观锁，实际上不是上锁，通过版本号或者cas算法实现
非公平锁和公平锁 哪个效率高
Synconized
sql：agroup和group哪个放前面哪个放后
左连接和内连接的区别
事物的ACID原则
幻读
StringBuilder和StringBuffer
StringBuffer如何保证线程安全的
集合的比较如何做
CAS的ABA情况
ThreadLocal
Spring事物传播特性
BeanFactory 和 factorybean啥啥啥的我也不清楚
Bean生命周期
几种创建bean的方式
ioc和aop

