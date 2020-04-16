package DesignPattern.FactoryPattern.simple;

import DesignPattern.FactoryPattern.Message;

public abstract class MessageHandler {

    public abstract Message handle(Message msg);

}
