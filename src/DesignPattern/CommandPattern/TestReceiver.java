package DesignPattern.CommandPattern;

public class TestReceiver extends Receiver {
    @Override
    public void action() {
        System.out.println("TestReceiver执行请求!");
    }
}
