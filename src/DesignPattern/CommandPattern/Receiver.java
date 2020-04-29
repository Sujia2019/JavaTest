package DesignPattern.CommandPattern;

//这是你要封装的子类，发送到别的地方使用，解耦
public abstract class Receiver {

//    public void action(){
//        System.out.println("执行请求！");
//    }
    abstract void action();
}
