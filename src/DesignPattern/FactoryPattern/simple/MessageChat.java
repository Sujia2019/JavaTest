package DesignPattern.FactoryPattern.simple;

import DesignPattern.FactoryPattern.Message;

public class MessageChat extends MessageHandler {

    @Override
    public Message handle(Message msg) {
        msg.setCode(666);
        msg.setMsg("聊天");
        return msg;
    }
}
