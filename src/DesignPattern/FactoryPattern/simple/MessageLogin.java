package DesignPattern.FactoryPattern.simple;

import DesignPattern.FactoryPattern.Message;

public class MessageLogin extends MessageHandler {

    @Override
    public Message handle(Message msg) {
        msg.setCode(666);
        msg.setMsg("登录");
        return msg;
    }
}
