package DesignPattern.StrategyPattern;

public class Car implements TravelStrategy{
    @Override
    public void travelWay() {
        System.out.println("by car");
    }
}
