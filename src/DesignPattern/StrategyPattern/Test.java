package DesignPattern.StrategyPattern;

public class Test {
    public static void main(String[] args) {
//        System.out.println();

        Traveler traveler = new Traveler();
        //设置出行方式
        traveler.setStrategy(new Car());
        //出行
        traveler.travelStyle();

    }
}
