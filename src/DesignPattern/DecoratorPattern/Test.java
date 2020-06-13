package DesignPattern.DecoratorPattern;

public class Test {
    public static void main(String[] args) {
        //创建一个饮料
        Drink example = new DrinkExample();
        System.out.println("example的原价为："+example.getCost());
        //给example加调料
        example = new Mocha(example);
        example = new Sugar(example);
        System.out.println("加了Mocha和Sugar调料后："+example.getCost());
    }
}
