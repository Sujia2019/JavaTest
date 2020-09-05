package DesignPattern.BridgePattern.example;

/**
 *  类的功能层次结构
 *  添加功能
 */
public class CountDisplay extends Display{
    public CountDisplay(DisplayImpl impl){
        super(impl);
    }
    public void multiDisplay(int times){
        open();
        for(int i = 0; i < times; i++ ){
            print();
        }
        close();
    }
}
