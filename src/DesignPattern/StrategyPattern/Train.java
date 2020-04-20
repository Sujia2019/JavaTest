package DesignPattern.StrategyPattern;

public class Train implements TravelStrategy {
    @Override
    public void travelWay() {
        System.out.println("by train");
    }
}
