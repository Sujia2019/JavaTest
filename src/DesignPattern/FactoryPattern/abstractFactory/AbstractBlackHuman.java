package DesignPattern.FactoryPattern.abstractFactory;

public abstract class AbstractBlackHuman implements Human {
    @Override
    public void getColor() {
        System.out.println("BLACK");
    }

    @Override
    public void talk() {
        System.out.println("BLACK TALKING");
    }
}
