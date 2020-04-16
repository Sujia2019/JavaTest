package DesignPattern.FactoryPattern.method;

import DesignPattern.FactoryPattern.CODE;

public class MyLoginMessage extends IMyAbstractMessage {
    @Override
    public void sendMessage() {
        System.out.println("LOGIN------"+getMessageParam().get(CODE.LOGIN));
    }
}
