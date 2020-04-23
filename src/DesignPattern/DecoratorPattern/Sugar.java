package DesignPattern.DecoratorPattern;

public class Sugar extends Material{
    String name="sugar";
    int cost = 1;  //
    int count = 0;//10g

    @Override
    public int getCost() {
        return super.getCost();
    }

    @Override
    public void setCount(int count) {
        super.setCount(count);
    }
}
