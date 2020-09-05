package DesignPattern.BridgePattern.example;

/**
 * 功能抽象，负责显示一些东西
 * 该类位于“类的功能层次结构”的最上层
 */
public class Display {
    private DisplayImpl impl;
    public Display(DisplayImpl impl){
        this.impl = impl;
    }
    public void open(){
        impl.rawOpen();
    }
    public void print(){
        impl.rawPrint();
    }
    public void close(){
        impl.rawClose();
    }

    public final void display(){
        open(); // 显示前的处理
        print(); // 显示处理
        close(); // 显示后的处理
    }
}
