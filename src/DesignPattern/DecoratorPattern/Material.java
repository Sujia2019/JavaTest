package DesignPattern.DecoratorPattern;

public abstract class Material extends Drink {
    //所有调料必须重新实现描述方法
    public abstract String getDescription();
}
