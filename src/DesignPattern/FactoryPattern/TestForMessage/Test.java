package DesignPattern.FactoryPattern.TestForMessage;

import DesignPattern.FactoryPattern.CODE;
import DesignPattern.FactoryPattern.Message;

public class Test {
    public static void main(String[] args) {
        MessageHandler handler = new MessageHandler();
        Message m = new Message();
        m.setCode(555);
        m.setMsg("sujia");


        handler.domain(m);
    }
}
