# Mybatis
## 什么是Mybatis？
* Mybatis是一个半ORM（对象关系映射）框架，它内部封装了JDBC，开发时只需要关注SQL语句本身，不需要花费精力去处理加载驱动、创建连接、创建statement等繁杂的过程。程序员直接编写原生态sql，可以严格控制sql执行性能，灵活度高。

* MyBatis 可以使用 XML 或注解来配置和映射原生信息，将 POJO映射成数据库中的记录，避免了几乎所有的 JDBC 代码和手动设置参数以及获取结果集。

* 通过xml 文件或注解的方式将要执行的各种 statement 配置起来，并通过java对象和 statement中sql的动态参数进行映射生成最终执行的sql语句，最后由mybatis框架执行sql并将结果映射为java对象并返回。（从执行sql到返回result的过程）。

##Mybatis的优点
1. 解耦：解除sql与程序代码的耦合，便于统一管理；提供XML标签，支持编写动态SQL语句，并可重用。

2. 与JDBC相比，减少了50%以上的代码量，消除了JDBC大量冗余的代码，不需要手动开关连接；

3. 很好的与各种数据库兼容（因为MyBatis使用JDBC来连接数据库，所以只要JDBC支持的数据库MyBatis都支持）。

4. 能够与Spring很好的集成；SqlSessionTemplate(线程安全)

5. 提供映射标签，支持对象与数据库的ORM字段关系映射；提供对象关系映射标签，支持对象关系组件维护。

## 为什么说 Mybatis 是半自动 ORM 映射工具？它与全自动的区别在哪里？
Hibernate 属于全自动 ORM 映射工具，使用 Hibernate 查询关联对象或者关联集合对象时，可以根据对象关系模型直接获取，所以它是全自动的。
而 Mybatis 在查询关联对象或关联集合对象时，需要手动编写 sql 来完成，所以，称之为半自动 ORM 映射工具。

## 简述 Mybatis 的 Xml 映射文件和 Mybatis 内部数据结构之间的映射关系？
Mybatis 将所有 Xml 配置信息都封装到 All-In-One 重量级对象 Configuration 内部。
在 Xml 映射文件中，<parameterMap>标签会被解析为 ParameterMap 对象，
其每个子元素会被解析为 ParameterMapping 对象。<resultMap>标签会被解析为 ResultMap 对象，
其每个子元素会被解析为 ResultMapping 对象。
每一个<select>、<insert>、<update>、<delete>标签均会被解析为 MappedStatement 对象，
标签内的 sql 会被解析为 BoundSql 对象.

## Mybatis 是否可以映射 Enum 枚举类
Mybatis 可以映射枚举类，不单可以映射枚举类，Mybatis 可以映射任何对象到表的一列上。
映射方式为自定义一个 TypeHandler，实现 TypeHandler 的 setParameter()和 getResult()接口方法。
TypeHandler 有两个作用，一 是完成从 javaType 至 jdbcType 的转换，
二 是完成 jdbcType 至 javaType 的转换，体现为 setParameter()和 getResult()两个方法，
分别代表设置 sql 问号占位符参数和获取列查询结果。

## Mybatis 中如何指定使用哪一种 Executor 执行器
在 Mybatis 配置文件中，可以指定默认的 ExecutorType 执行器类型，
也可以手动给 DefaultSqlSessionFactory 的创建 SqlSession 的方法传递 ExecutorType 类型参数。

## Mybatis 都有哪些 Executor 执行器？它们之间的区别是什么？
Mybatis 有三种基本的 Executor 执行器，SimpleExecutor、ReuseExecutor、BatchExecutor。

* **SimpleExecutor** : 每执行一次 update 或 select，就开启一个 Statement 对象，用完立刻关闭 Statement 对象。

* **ReuseExecutor** : 执行 update 或 select，以 sql 作为 key 查找 Statement 对象，存在就使用，不存在就创建，用完后，不关闭 Statement 对象，而是放置于 Map<String, Statement>内，供下一次使用。简言之，就是重复使用 Statement 对象。

* **BatchExecutor** : 执行 update（没有 select，JDBC 批处理不支持 select），将所有 sql 都添加到批处理中（addBatch()），等待统一执行（executeBatch()），它缓存了多个 Statement 对象，每个 Statement 对象都是 addBatch()完毕后，等待逐一执行 executeBatch()批处理。与 JDBC 批处理相同。

* 作用范围：Executor 的这些特点，都严格限制在 SqlSession 生命周期范围内。

## Mybatis 中如何执行批处理？
使用 BatchExecutor 完成批处理。

## Mybatis 的 Xml 映射文件中，不同的 Xml 映射文件，id 是否可以重复？
不同的 Xml 映射文件，如果配置了 namespace，那么 id 可以重复；
如果没有配置 namespace，那么 id 不能重复；毕竟 namespace 不是必须的，只是最佳实践而已。

## Mybatis 是否支持延迟加载？如果支持，它的实现原理是什么？
Mybatis 仅支持 association 关联对象和 collection 关联集合对象的延迟加载，
association 指的就是一对一，collection 指的就是一对多查询。
在 Mybatis 配置文件中，可以配置是否启用延迟加载 lazyLoadingEnabled=true|false。

它的原理是，使用CGLIB 创建目标对象的代理对象，当调用目标方法时，进入拦截器方法，
比如调用 a.getB().getName()，拦截器 invoke()方法发现 a.getB()是 null 值，
那么就会单独发送事先保存好的查询关联 B 对象的 sql，把 B 查询上来，然后调用 a.setB(b)，
于是 a 的对象 b 属性就有值了，接着完成 a.getB().getName()方法的调用。这就是延迟加载的基本原理。

## Mybatis 能执行一对一、一对多的关联查询吗？都有哪些实现方式，以及它们之间的区别。
Mybatis 不仅可以执行一对一、一对多的关联查询，还可以执行多对一，多对多的关联查询，
多对一查询，其实就是一对一查询，只需要把 selectOne()修改为 selectList()即可；
多对多查询，其实就是一对多查询，只需要把 selectOne()修改为 selectList()即可。

关联对象查询，有两种实现方式，一种是单独发送一个 sql 去查询关联对象，赋给主对象，然后返回主对象。
另一种是使用嵌套查询，嵌套查询的含义为使用 join 查询，一部分列是 A 对象的属性值，
另外一部分列是关联对象 B 的属性值，好处是只发一个 sql 查询，就可以把主对象和其关联对象查出来。

## Mybatis 动态 sql 是做什么的？都有哪些动态 sql？能简述一下动态 sql 的执行原理不？
Mybatis 动态 sql 可以让我们在 Xml 映射文件内，以标签的形式编写动态 sql，
完成逻辑判断和动态拼接 sql 的功能，Mybatis 提供了 9 种动态 sql 标签 
trim|where|set|foreach|if|choose|when|otherwise|bind。

其执行原理为，使用 OGNL 从 sql 参数对象中计算表达式的值，根据表达式的值动态拼接 sql，
以此来完成动态 sql 的功能。

## 最佳实践中，通常一个 Xml 映射文件，都会写一个 Dao 接口与之对应，请问，这个 Dao 接口的工作原理是什么？Dao 接口里的方法，参数不同时，方法能重载吗？
* Dao 接口，就是人们常说的 Mapper接口，接口的全限名，就是映射文件中的 namespace 的值，
接口的方法名，就是映射文件中MappedStatement的 id 值，接口方法内的参数，就是传递给 sql 的参数。
Mapper接口是没有实现类的，当调用接口方法时，接口全限名+方法名拼接字符串作为 key 值，
可唯一定位一个MappedStatement，
举例：com.mybatis3.mappers.StudentDao.findStudentById，
可以唯一找到 namespace 为com.mybatis3.mappers.StudentDao下面id = findStudentById的MappedStatement。
在 Mybatis 中，每一个<select>、<insert>、<update>、<delete>标签，都会被解析为一个MappedStatement对象。

* Dao 接口里的方法，是不能重载的，因为是全限名+方法名的保存和寻找策略。

* Dao 接口的工作原理是 JDK 动态代理，Mybatis 运行时会使用 JDK 动态代理为 Dao 接口生成代理 proxy 对象，
代理对象 proxy 会拦截接口方法，转而执行MappedStatement所代表的 sql，然后将 sql 执行结果返回。

## 缓存
* sqlsession mybatis一级缓存
* mybatis全局缓存：mybatis二级缓存(redis，encache)