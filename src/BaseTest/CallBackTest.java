package BaseTest;

/**
 * @author ：sujia
 * @date ：Created in 2020/12/15 6:01 下午
 * @description：回调
 * @modified By：
 * @version:
 */
public class CallBackTest {
    public static void main(String[] args) {
        Client c = new Client();
        Server s = new Server();
        c.sendCallBack(s, "我是客户端");
    }
}

interface ICallBack {
    public void printCallBack(String msg);
}

class CallBack implements ICallBack {
    @Override
    public void printCallBack(String msg) {
        System.out.println("触发回调,回调信息:" + msg);
    }
}

class Client {
    Client() {

    }

    void sendCallBack(final Server server, final String msg) {
        new Thread(() -> server.getClientMsg(new CallBack(), msg)).start();
    }
}

class Server {
    Server() {
        init();
    }

    public void init() {
        System.out.println("服务器启动");
    }

    void getClientMsg(CallBack callback, String msg) {
        System.out.println("服务器收到的客户端信息为: " + msg);
        callback.printCallBack("服务器触发success");

    }
}