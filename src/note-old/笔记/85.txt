package note 进程 线程 自用线程（共用同一个内核线程） 纤程（自管理 单线程） 协程（单线程，不共享资源）

        并行 并发

        linux底层文件系统 fd-set

        tcp三种常用连接方式
        selector 中断阻塞
        1长度有限
        2每回都要清空没有意义
        3慢 每次都要轮回 如果没什么事件就得空转

        poll
        没有解决空转

        epoll
        对于一个字节一个字节连续不停写入时，比较浪费，建议bio
        将打勾的ss和s标记写入另一个队列中只在那里循环

        同步----一根线程 加载页面 中间有东西 页面刷新白页 重新渲染

        异步----多启动了一根线程执行其他。

        被动系统--短板原理 在其中写主动系统 写入日志再批量入库

        reactor模型 纯被动

        java只支持selector

        纯客户端没必要nio

        一个机子在同一个网段下只有一个ip
        但是一个机子可以有很多个ip

        sc.register(selector,SelectionKey.OP_READ);
        // 将sk对应的Channel设置成准备接受其他请求
        sk.interestOps(SelectionKey.OP_ACCEPT);

        读和写都用注册
        serversocket都用interestOps

        netty---epoll  （卡1.5-2万 满跑）

        alpha内测 beta公测 rc发行 std不改bug了

        ChannelHandlerAdapter 不论是out还是in都继承这个！！


        Udp 可以一对多多对多，tcp是一对一 tcp协议
        Udp 无连接传输，没有握手 很快

        192.168.1.255 255是广播

        虚拟机 容器docker
        1）qema

        虚拟机 centos kvm

        Oracle VitualBox

        网卡

        P2P UDP打洞

        虚拟机 下centos的 配置好后配ip
        ping一下自己的宿主机
        ifconfig
        setup看防火墙

        hostonly