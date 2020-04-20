package DesignPattern.FactoryPattern.TestForMessage;

import DesignPattern.FactoryPattern.Message;

public class OtherInvoker extends MessageInvoker {

    @Override
    void init(Message msg) {
        this.factory = new OtherFactory();
    }
}
