## MySql
文件系统(DB,k v)---关系对象层---集合操作api(filter,map,reduce,sort...)---sql解释器---SQL---MS---MySQL---Client


### MySql的事务特性、事务隔离、事务传播
### ACID原则
#### 事物的原子性(Atomicity)
    是指一个事务要么全部执行，要么不执行，也就是说一个事务不可能只执行了一啊不能就停止了

#### 事务的一致性(Consistency)
    是指事务的运行并不改变数据库中数据的一致性
    例如，完整性约束了a+b=10，一个事务改变了a，那么b也应该随之改变
    
#### 独立性(Isolation)
    事务的独立性也有称作隔离性，是指两个以上的事务不会出现交错执行的状态，
    因为这样可能会导致数据不一致
    
#### 持久性(Durability)
    事务的持久性是指事务执行成功以后，该事务对数据库所作的更改便是持久的保存在数据库之中
    不会无缘无故的回滚。
    
### 4种事务隔离级别
* 脏读:读到了其他事务中处理的内容 **READ-UNCOMMITTED** 读取未提交
* 不可重复读 **READ-COMMITTED**  读取提交
* 幻读     **REPEATABLE-READ**  可重复读
* 串行化 **SERIALIZABLE**  所有的事务依次逐个执行

###MySQL 优化 --- elasticsearch保证时效性
1. 缓存： 最终结果缓存, 中间结果缓存, sql解释语句结果缓存
2. 索引构建(读快写慢)：树形数据结构 表---B+树
    * 聚集索引
    * 非聚集索引
    
    
### 面试篇
#### 什么是MySQL 
MySQL 是一种关系型数据库，在Java企业级开发中非常常用，因为 MySQL 是开源免费的，并且方便扩展。
阿里巴巴数据库系统也大量用到了 MySQL，因此它的稳定性是有保障的。
MySQL是开放源代码的，因此任何人都可以在 GPL(General Public License) 的许可下下载并根据个性化的需要对其进行修改。
MySQL的默认端口号是**3306**。

#### 存储引擎
* show engines;
* MySQL 当前默认的存储引擎是InnoDB,并且在5.7版本所有的存储引擎中只有 InnoDB 支持事务。
* **MyISAM和InnoDB区别**
    * MyISAM是MySQL的默认数据库引擎（5.5版之前）。虽然性能极佳，而且提供了大量的特性，包括全文索引、压缩、空间函数等，但MyISAM不支持事务和行级锁，而且最大的缺陷就是崩溃后无法安全恢复。不过，5.5版本之后，MySQL引入了InnoDB（事务性数据库引擎），MySQL 5.5版本后默认的存储引擎为InnoDB。
    * 大多数时候我们使用的都是 InnoDB 存储引擎，但是在某些情况下使用 MyISAM 也是合适的比如读密集的情况下。（如果你不介意 MyISAM 崩溃恢复问题的话）。
    * 两者的对比： 

            是否支持行级锁 : MyISAM 只有表级锁(table-level locking)，而InnoDB 支持行级锁(row-level locking)和表级锁,默认为行级锁。
            是否支持事务和崩溃后的安全恢复： MyISAM 强调的是性能，每次查询具有原子性,其执行速度比InnoDB类型更快，但是不提供事务支持。
                                         InnoDB 提供事务支持事务，外部键等高级数据库功能。 具有事务(commit)、回滚(rollback)和崩溃修复能力(crash recovery capabilities)的事务安全(transaction-safe (ACID compliant))型表。
            是否支持外键： MyISAM不支持，而InnoDB支持。
            是否支持MVCC ：仅 InnoDB 支持。应对高并发事务, MVCC比单纯的加锁更高效;(MVCC 多版本并发控制)
                          MVCC只在 READ COMMITTED 和 REPEATABLE READ 两个隔离级别下工作;MVCC可以使用乐观(optimistic)锁和悲观(pessimistic)锁来实现;各数据库中MVCC实现并不统一。
                          
#### 大表优化
* 限定数据的范围
* 读/写分离
* 横切/纵切(水平分区|竖直分区)