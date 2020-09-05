package DesignPattern.BuilderPattern;

import static DesignPattern.BuilderPattern.utils.Sender.Type.*;

import DesignPattern.BuilderPattern.model.Message;
import DesignPattern.BuilderPattern.model.User;
import DesignPattern.BuilderPattern.utils.Sender;

/**
 * 负责消息发送的客户端调用
 */
public class Client {
    private Sender sender ;
    private User user;
    private Message message;

    private void login(User user){
        this.user = user;
    }
    Client(){
        sender = Sender.getInstance();
    }
    private void choose(User user){
        message = new Message();
        message.setTo(user);
        message.setType(SINGLE);
    }


    private void send(String msg){
        message.setFrom(user);
        message.setSend(msg);
        message = sender.send(message);
        System.out.println(message.toString());
    }

    public static void main(String[] args) {
        /*
         * 首先打开客户端
         */
        Client client = new Client();
        /*
         * 用户登陆
         */
        User user  = new User("源氏");
        client.login(user);
        /*
         * 选择了一个好友进行私聊
         */
        User friend = new User("半藏");
        client.choose(friend);
        /*
         * 他打了一行字
         */
        String msg = "你好！/ha!今天天气不错，你来看看~[view]";
        /*
         * 他点击发送，界面上输出了发的消息
         */
        client.send(msg);

    }
}
