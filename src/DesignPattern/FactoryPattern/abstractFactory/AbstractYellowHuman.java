package DesignPattern.FactoryPattern.abstractFactory;

public abstract class AbstractYellowHuman implements Human{
    @Override
    public void getColor() {
        System.out.println("YELLOW");
    }

    @Override
    public void talk() {
        System.out.println("YELLOW TALKING");
    }
}
