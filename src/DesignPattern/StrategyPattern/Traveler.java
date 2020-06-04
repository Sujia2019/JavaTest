package DesignPattern.StrategyPattern;

public class Traveler {
    TravelStrategy strategy ;

    public void setStrategy(TravelStrategy travelStrategy){
        this.strategy = travelStrategy;
    }

    public void travelStyle(){
        strategy.travelWay();
    }

}
