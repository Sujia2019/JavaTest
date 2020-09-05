package DesignPattern.Proxy.robot;

import DesignPattern.Proxy.Say;

public class RobotStaticProxy implements Say{
    private Say say;
    public RobotStaticProxy(Say say){
        this.say = say;
    }

    @Override
    public void saySomething(String something) {
        before();
        say.saySomething("[ static proxy ] --- [ "+something+" ]");
        after();
    }

    private void before(){
        System.out.println("------>>>static proxy start--------");
    }
    private void after(){
        System.out.println("------>>>static proxy stop--------");
    }
}
