package DesignPattern.DecoratorPattern;

public class Material {
    String name="name";
    int cost;
    int count=0;

    public int getCost(){
        return cost*count;
    }

    public void setCount(int count){
        this.count = count;
    }



}
