package DesignPattern.Proxy.imp;

import DesignPattern.Proxy.Say;

public class SayHello implements Say {
    @Override
    public void saySomething(String something) {
        System.out.println(this.getClass().getName()+": say ---> "+something);
    }
}
