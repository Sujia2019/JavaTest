package DesignPattern.FactoryPattern.abstractFactory;

public class Test {

    public static void main(String[] args) {
        //女性生产线
        HumanFactory maleFactory = new MaleFactory();
        //男性生产线
        HumanFactory femaleFactory = new FemaleFactory();
        //造一个女黄人儿
        System.out.println("-----造一个女黄人儿-----");
        Human maleYellowHuman = maleFactory.createYellowHuman();
        maleYellowHuman.getColor();
        maleYellowHuman.getGender();
        maleYellowHuman.talk();
        //造一个男黑人儿
        System.out.println("-----造一个男黑人儿-----");
        Human femaleBlackHuman = femaleFactory.createBlackHuman();
        femaleBlackHuman.getColor();
        femaleBlackHuman.getGender();
        femaleBlackHuman.talk();

    }
}
