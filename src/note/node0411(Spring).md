## Spring

ioc(核心)  aop

用于存放对象的容器(map)

底层:Map<对象的名字,对象的实例>

#### Spring Bean的scope
* singleton
* protoType
* request
* session

#### cookie session
* cookie 浏览器本地缓存 存小数据的k v
* session 是存储在服务器

#### Spring ioc配置注入
* 构造方法注入
* 静态工厂注入
* 包扫描的annotation注入 (@Service ...) BeanDefinitionMap存放各种bean外壳的map
```
    ！注意xml的声明规范
    @Service 对应MVC中的业务层
    @Component 通用注解 无法分层但想让spring管理的类
    @Controller 控制层
    @Repository 数据操作层
    其实 效果都是一样的
```
* JavaConfig  (@Configuration  @ComponentScan(basepackage ))

###**Spring启动流程** 
1. **prepareRefresh()** 环境准备 设置context中的配置数据源
2. ConfigurableListableBeanFactory beanFactory = obtainFreshBeanFactory()
    loadBeanDefinitions方法，该抽象方法在具体实现子类上用于处理不同场景下Bean定义的加载，如Xml配置，注解配置，Web环境等
3. prepareBeanFactory(beanFactory) 为第二步返回的beanFactory设置基础属性
4. postProcessBeanFactory(beanFactory) 后置处理，修改bean定义或者增加自定义的bean
5. invokeBeanFactoryPostProcessors(beanFactory) 实例化并初始化实现BeanFactoryPostProcessor接口的类并执行，若存在依赖的Bean也会被初始化和实例化
6. registerBeanPostProcessors(beanFactory) 注册，从Spring容器中找出BeanPostProcessor接口的Bean,并添加到BeanFacotry内部维护的List属性中
7. initMessageSource()初始化一些国际化相关的属性
8. initApplicationEventMulticaster() 初始化事件广播器对象
9. onRefresh()
10. registerListeners()找出系统中的ApplicationListener对象，注册到时间广播器中。如果有需要提前进行广播的时间，则执行广播
11. finishBeanFactoryInitialization(beanFactory)
12. finishRefresh()


###**SpringAOP**          

###**动态代理的两种实现**
1.jdk自带的proxy
2.cglib动态代理

###**SpringAOP**Aspect Oriented Programming with Spring
* Enabling @AspectJ Support
*aop流程
 1. 定义切面(是执行相应方法时，附带需要执行的方法集合)
 2. 定义切点(是执行附加方法的位置)
 3. 定义附加方法(附加方法可执行在原方法之前，原方法之后，或者直接代替原方法@Around)
* aop动态代理的选择
1. 如果目标对象(需要代理的对象，下同)实现了自己某个业务接口，默认情况下使用JDK自带动态代理
2. 如果目标对象实现了业务接口，开发者也可以强制使用cglib实现动态代理
3. 如果目标对象没有实现业务接口，必须采用cglib，此时Spring底层会进行判断从而选择cglib

(注 jdk1.6以上，jdk自带的动态代理效率远高于cglib)

####跟踪Spring源码，找到spring针对对象做动态代理的地方，形成文档
####使用aop改造redis缓存
####基于mybatis全局缓存，使用redis来进行sql查询的结果缓存

###**ORM框架**
spring jdbc
hibernate (自动化ORM框架)
mybatis(ibatis)(半自动化ORM框架)

###SPRING的事务传播特性:
* PROPAGATION_REQUIRED--支持当前事务，如果当前没有事务，就新建一个事务。这是最常见的选择。
* PROPAGATION_SUPPORTS--支持当前事务，如果当前没有事务，就以非事务方式执行。
* PROPAGATION_MANDATORY--支持当前事务，如果当前没有事务，就抛出异常。
* PROPAGATION_REQUIRES_NEW--新建事务，如果当前存在事务，把当前事务挂起。
* PROPAGATION_NOT_SUPPORTED--以非事务方式执行操作，如果当前存在事务，就把当前事务挂起。
* PROPAGATION_NEVER--以非事务方式执行，如果当前存在事务，则抛出异常。



