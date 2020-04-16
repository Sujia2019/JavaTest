package DesignPattern.FactoryPattern;

import DesignPattern.FactoryPattern.method.IMyMessage;
import DesignPattern.FactoryPattern.method.MyMessageFactory;
import DesignPattern.FactoryPattern.simple.MessageFactory;
import DesignPattern.FactoryPattern.simple.MessageHandler;

public class Test {
    public static void main(String[] args) {
        Message msg = new Message();
        msg.setCode(1);
        msg.setMsg("LOGIN");
//        //Simple
//        MessageHandler handler = MessageFactory.handleMessage(msg.getCode());
//        msg = handler.handle(msg);
//        System.out.println(msg);

        MyMessageFactory factory = new MyMessageFactory();
//        IMyMessage myMessage = factory.createMessage(4);
//        myMessage.sendMessage();
        IMyMessage myMessage = factory.handler(msg);
        myMessage.sendMessage();

    }
}
