package DesignPattern.FactoryPattern.abstractFactory;

public abstract class AbstractWhiteHuman implements Human{
    @Override
    public void getColor() {
        System.out.println("WHITE");
    }

    @Override
    public void talk() {
        System.out.println("WHITE TALKING");
    }
}
