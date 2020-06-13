package DesignPattern.DecoratorPattern;

public class Sugar extends Material{
    private Drink drink;
    public Sugar(Drink drink){
        this.drink = drink;
    }
    @Override
    public String getDescription() {
        return "糖，" +  drink.getDescription() ;
    }
    @Override
    public int getCost() {
        //把茶的价格加上糖的价格，得到最后结果
        return 1 + drink.getCost();
    }
}
