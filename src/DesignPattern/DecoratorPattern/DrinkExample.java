package DesignPattern.DecoratorPattern;

public class DrinkExample extends Drink {
    public DrinkExample(){
        description="DrinkExample";
    }
    @Override
    public int getCost() {
        return 5;
    }
}
