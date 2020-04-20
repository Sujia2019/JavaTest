package DesignPattern.StrategyPattern;

public class Air implements TravelStrategy {
    @Override
    public void travelWay() {
        System.out.println("by air");
    }
}
