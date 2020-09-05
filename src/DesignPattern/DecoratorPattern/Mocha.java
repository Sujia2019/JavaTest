package DesignPattern.DecoratorPattern;

public class Mocha extends Material{
    //要装饰的对象
    private Drink drink;
    public Mocha(Drink drink){
        this.drink=drink;
    }
    @Override
    public String getDescription() {
        return "摩卡，" +  drink.getDescription() ;
    }
    @Override
    public int getCost() {
        //把本身的价格加上摩卡的价格，得到最后结果
        return 10 + drink.getCost();
    }
}
