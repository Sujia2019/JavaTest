package DesignPattern.FactoryPattern.method;

import DesignPattern.FactoryPattern.Message;

public interface IMessageFactory {
//    public IMyMessage createMessage(int code);

    public IMyMessage handler(Message msg);
}
