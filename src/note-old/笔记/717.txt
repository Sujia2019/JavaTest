package note 序列化 反序列化
        只要走IO肯定序列化

public class Person       **
        implements java.io.Serializable //这居然是个空借口！ 必须要这个接口 让这个类也变成S类
        {
private String name;
private transient int age;
//java语言的关键字，变量修饰符，如果用transient声明一个实例变量，当对象存储时，它的值不需要维持。换句话来说就是，用transient关键字标记的成员变量不参与序列化过程。
public Person(String name,int age)
        {
        this.name=name;
        this.age=age;
        }
public void setName(String name)
        {
        this.name=name;
        }
public String getName()
        {
        return this.name;
        }
public void setAge(int age)
        {
        this.age=age;
        }
public int getAge()
        {
        return this.age;
        }
        }

        此序列化不太好
        例：
        java写文件
        用C读 缺陷，java的序列化反序列化只能自己用
        四个可重写的方法readResolve()writeReplace()

        serialVersionUID 序列版本号，如果改了类会变号，造成反序列化时报错，可以默认写死一个序列号，这样更改类里的属性时， 只有其中这一个属性值是空

        哈希结构就是面向对象的底层 K,V entry

        结构csv：(数据文件)
        list.add(new Stu{
        int id;
        String name;
        HashMap scores;//m,c,e
        ArrayList hb;
        })

        id name scores hb
        1,xxx,100,20,80,"a,b,c"
        2,yyy,20,70,89,"b,c"
        这个东西生成a.csv文件可以用excel表格打开并且是表格形式诶！
        String.split(",")
        ****总结一下String实用方法

        Properties
        stu1.id=1;
        stu1.name=xxx;
        stu1.scores.m=90
        stu1.scores.c=80
        stu1.scores.e=70
        举例： 数据库的配置文件

        多国语言
        加下划线的相当于本地文件，idea会系统管理，给一个文件夹
        xxx_语言_国别.properties

        yaml：

        stu1：空格
        空格至少3个-id:1
        -name:"xxx"
        -scores=
        -m:98
        -c:98
        -e:98
        -hb:
        a
        b
        c

        xml:(配置、数据兼可)*****自学dom4j框架
<stus>
<stu id=1>
<name>xxx</name>
<scores>
<m>89</m>
<c>98</c>
<e>98</e>
</scores>
</stu>
</stus>

        json:(配置、数据兼可)（fastjson阿里）
        对象{}
        数组[]
        [{id:1,name:"xxx",scores:{m:90,c:90,e:90},hb:[a,b,c]}]

        nio不是面向对象的，是面向数组的
        Buffer 是一个数组
        ByteBuffer**
        allocate 普通数组申请
        allocateDirect（？）     直接内存 底层是C native  在直接内存中申请大小
        声明后的大小不可变了
        wrap 把数组变成ByteBudder格式 用的最多

        flip ： 相当于读的过程，limit到position的位置，p从0开始
        rewind： p归零，其他不动
        clear:l=capatity，p归零

        标记指针 mark 然后reset：可以把position跳到mark的位置

        Channel 文件 tcp 网络

        MappedByteBuffer------
        用户和内核之间减少拷贝时间，用户和内核的0拷贝

        内核对内核的零拷贝   ？？？
        C语言对应 sendfile（2个G内的数据）  sendfile64（传输大于2个G的数据）

        RandomAccessFile raf
        raf.seek(300)不能超过

        //初始化Pipe实例
        Pipe pipe=Pipe.open();

        // 获取写通道
        Pipe.SinkChannel skChannel=pipe.sink();

        Gather Scather模拟C语言的结构体 看例子代码！
        //获得读取数据通道
        Pipe.SourceChannel sourceChannel=pipe.source();

        反射*****
        只能反射类结构，反射不到类的值 类de值还是直接调用叭！
        还能得到构造方法里面传的参数类型 名字

        通过反射可以往private传数据！ 修改可见性s
        看照片 例子 很明白！

        xxx=vvv type
        配置单--->生成类---->解析文件，一行一行分析，
        m.invoke（x，vvv）

        // 得到Ref类c(元数据)
        Class c=Class.forName("org.reflaction.i_3.Ref");

//		Ref test1 = (Ref)c.newInstance();
        // 通过指定参数类型获取相应构造函数(对象)
        Constructor constructor=c.getConstructor(String.class);

        Constructor constructor1=c.getConstructor(String.class,Integer.class);
        // 通过构造函数实例化Ref类对象test
        Ref test=(Ref)constructor.newInstance("Test Instructor");

        Ref test2=(Ref)constructor.newInstance("Test Instructor",1);

//		Ref test =new org.reflaction.i_3.Ref("Test Instructor");

        // 通过指定的方法名称取得对应方法对象
        // *****************
        // 语法: 类名.getMethod("方法名称",形参类型列表)
        // *****************
        Method method=c.getMethod("sayHello",String.class);

        // 动态调用方法(非静态方法)
        // *****************
        // 语法: method.invoke(对象实例, 实参列表);
        // *****************
        method.invoke(test,"Test method");

//		test.sayHello("Test method");

        // 动态调用方法(静态方法)
        Method show=c.getMethod("show");
        String str=(String)show.invoke(test); // 静态方法调用方式1
        // String str = (String)show.invoke(null);//静态方法调用方式2
        System.out.println(str);


        动态代理 Proxy 看代码！！******
        public Object invoke(Object proxy,Method method,Object[]args)
        throws Exception{
        DogUtil du=new DogUtil();
        // 执行DogUtil对象中的method1。
        du.method1();
        // 以target作为主调来执行method方法
        Object result=method.invoke(target,args);
        // 执行DogUtil对象中的method2。
        du.method2();
        return result;
        }


        app面向切面编程

        class tea{
        public void xxxx{
        }
        }

        handler
        public void log{

        }
        依赖注入

        class Dao{
        ISave s;
        public void setS(ISave s){
        this.s=s;
        }
        public void save(User u){
        s.save(u);
        }
        }



