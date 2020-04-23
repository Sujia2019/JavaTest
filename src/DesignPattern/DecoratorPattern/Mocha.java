package DesignPattern.DecoratorPattern;

public class Mocha extends Material{
    String name="mocha";
    int cost = 10;//单价
    int count = 0;

    @Override
    public int getCost() {
        return super.getCost();
    }

    @Override
    public void setCount(int count) {
        this.count = count;
    }
}
