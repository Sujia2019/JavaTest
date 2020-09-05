package DesignPattern.BridgePattern.example;

/**
 * 位于“ 类的实现层次结构 ”的最上层
 */
public abstract class DisplayImpl {
    public abstract void rawOpen();
    public abstract void rawPrint();
    public abstract void rawClose();
}
