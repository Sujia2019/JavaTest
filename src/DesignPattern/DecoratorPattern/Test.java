package DesignPattern.DecoratorPattern;

public class Test {
    public static void main(String[] args) {
        Material m = new Mocha();
        m.setCount(10);
        System.out.println(m.getCost());
    }
}
