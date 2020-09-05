package DesignPattern.BridgePattern.example;

/**
 * 真正的“实现”
 * 它不是直接地显示字符串，而是继承类，作为子类来使用方法显示
 */
public class StringDisplayImpl extends DisplayImpl{
    private String testStr;   // 要显示的字符串
    private int width;        // 以字节单位计算出的字符串的宽度
    public StringDisplayImpl(String string){ // 构造函数接收显示的字符串
        this.testStr=string;  // 保存在字段中
        this.width=string.getBytes().length; //把字符串的宽度也保存在字段中，以供使用
    }
    @Override
    public void rawOpen() {
        printLine();
    }

    @Override
    public void rawPrint() {
        System.out.println("|"+testStr+"|"); // 前后加上"|"并显示
    }

    @Override
    public void rawClose() {
        printLine();
    }

    private void printLine(){
        System.out.print("+");
        for(int i = 0; i < width; i++){
            System.out.print("-");
        }
        System.out.println("+");
    }
}
