package note C||S
        建立链接 启动server进程，进行链接监听
        收发数据 获取链接
        断开链接 断开链接

        ServerSocket s=new ServerSocket(8888);

        ifconfig 查本机网卡 ip
        ip地址分类

        127.0.0.1即表示自己
        ping127.0.0.1

        icmp协议 网络控制协议 seq发送 ttl 生命周期64 windows一般是128
        64bytes from127.0.0.1:icmp_seq=1ttl=64time=0.035ms

        hostname 主机名
        配主机名
        su-root
        more/etc/hostname

        vim/etc/hosts ip地址和主机名，一对多
        把电脑的hostname改成 www.taobao.com 上网就自己连自己了，打不开网页

        拆包/粘包 tcp协议

        例子Socket dma ， 8259
        时钟 一个包1518个字节-ip头mac头tcp头 差不多1460个字节的内容饱和 自己打包还是用1300字节比较好
        控速 缓冲区变大变小

        滑动窗口

        netstate

        ip欺骗 syn洪水 负载均衡

        http

        request
        response
        tcp三次握手

        request报文 push
        ack
        fin
        返回response报文

        nc-lk 9999
        telnet 网页

        请求报文 post get head|delete put option trace connection

        GET 有头无体
        POST/xxxxxxxx(CRLF)有头有体
        Accept:(CRLF)
        x(CRLF)
        x(CRLF)
        xx(CRLF)
        x(CRLF)
        (CRLF)
        内容


        response：
        200
        301（不在我这） 302（在过我这，转移了） 304（有缓存）
        401 402 403 404
        500

        http://www.w3school.com

<b>加粗<u>下划线
        colspan="2"合并单元格

<div style="float:left">aaa</div>层级样式表
<style>
    p{      //#xx id选择 .xx class选择
            color:
            }
</style>

<p>xxx</p>


        function plus（a,b）     鸭子类型

        匿名函数
        var plus=function（a,b）{
        return a+b;
        }
        var sub=function(a,b){
        return a-b
        }
        function obj(f,a,b){
        return f(a,b)
        }
        c=obj(sub,1,4)
        console.log(c)

        闭包

        面向对象 不能藏私有
        this._

        prototype

        继承 封装 多态