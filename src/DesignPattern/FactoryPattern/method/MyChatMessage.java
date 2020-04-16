package DesignPattern.FactoryPattern.method;

import DesignPattern.FactoryPattern.CODE;

public class MyChatMessage extends IMyAbstractMessage{
    @Override
    public void sendMessage() {
        System.out.println("CHAT------"+getMessageParam().get(CODE.CHAT));
    }
}
