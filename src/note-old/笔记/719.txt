package note

class loader

java-Xmx1G-cp/opt/lib/xx.jar org.Test 启动

        启动loader bootstraploader java启动loarder 不能被干掉 c写的 不开源
        extloader 扩展loader 商业化运作

        ***/jdk1.8./jre/lib/ext 满脑子都是巴拉拉能量 乌漆抹黑

        双亲委派制

        URL 同一资源定位符

        协议标识符：//主机:端口/路径/.../资源
        http:
        ftp:
        file:///c:/
        端口号相当于对外发布的进程号 是个程序

        ipv4 ipv6
        0-255.0-255.0-255.0-255

        网络地址+主机地址=ip地址
        地址掩码

        192.168.1.1
        255.255.0.0&

        255相当于十六进制ff，相当于二进制11111111
        两个地址相与运算，有1得任何数，有0都是0，得到的结果是网络地址

        DNS dhcp

        模拟程序存储计算机

        1)写一个程序运行起来，
        2)通过这个程序生成一个java代码
        3)通过这个程序编译java类->class
4)通过classloader加载
        5)new对象执行

        java：Runtime方法


        僵尸进程


        启一个shell用shell启动另一个程序

        java启动一个 比如死循环的程序，然后把java关掉，那个程序还活着，但是归还了内存，但他的id号还在，标记内存位置的那句话还在，id号是有限的，如果启太多这样的程序id号到上限就启不了其他程序了，所以java就自己有方法当关了Java的时候会自己把id和那句话释放，如果想启动一个永远活着的程序，那就要写一个shell程序，用java启动一个.sh，再用.sh启动这程序就行了，java一死，.sh也死了，但那程序不死

        nohup xxxxx&借助.sh
        xxxxx是一个java程序，用这样的方式启动java程序

        自定义classloader extends classloader

class Myclassloader {
    public void loadclass() {
        try {
            findclass;
        } catch {
        }


    }

    protected void findclass()throw E

    {
        throw new E;


    }

    protected void defineclass() {

    }
}

class DIY extend myclassloader {


}
首次使用的特点
        1，执行main函数
        2，new 首次使用
        3，class.forname
        4，调用类的静态成员

static{
        a=20;
        b=20;
        }
public static int a=10;声明+定义
public static int b;只声明
        打印结果，a=10,b=20

        理解final 调用了final方法好像就不首次使用static了
static{}块儿 加了final 封闭符 不能改了
        {}成员块儿 区别

final 封闭符（常量）
        finally try catch finally
        finalize

        hook钩子 windows 消息模型 比如你按一个键，会把这个事件扔进消息队列中，然后在使用时从消息队列第一个开始拿，windows实际相当于两个程序，一个带界面程序，一个后台程序，后台程序不带界面，也可以拿消息队列的东西，这个后台程序就叫钩子，写一个木马就可以找到这块，比如你登录一个网址，他查到你进入一个网址，后面总是跟着两串字，就可以猜到用户名和密码，阿里就做了个插件，让你登录某个网址时，禁止钩子操作

        System.gc  （扔一个副gc线程出去了） 回收

        强引用 软引用 弱引用（优先释放） 虚引用（不是引用，是一种监控）

        正则表达式 模式匹配
        macher
        find
        reset

        tcp/ip


        osi=7

        协议头

        协议体

        f:mac t:mac 二层
        f:ip t:ip 三层
        f：port t:port 四层

        tcp 三次握手 哈哈哈哈哈哈哈 有响应的传递 有顺序 不丢包
        四次挥手 保证数据不丢失

