package DesignPattern.FactoryPattern.TestForMessage;

import DesignPattern.FactoryPattern.Message;


public class LoginInvoker extends MessageInvoker {


    @Override
    void init(Message msg) {
        //应该加上对应的校验吧
        factory = new LoginFactory();

    }
}
