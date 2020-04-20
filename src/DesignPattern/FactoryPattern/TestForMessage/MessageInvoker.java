package DesignPattern.FactoryPattern.TestForMessage;

import DesignPattern.FactoryPattern.Message;

public abstract class MessageInvoker {

    MessageFactory factory;

    Message message;

    abstract void init(Message msg);

    Object sendMessage(Message msg){
        init(msg);
        return factory.handle(msg.getMsg());
    }


}
