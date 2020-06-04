package DesignPattern.FactoryPattern.abstractFactory;

public class MaleYellowHuman extends AbstractYellowHuman{
    @Override
    public void getGender() {
        System.out.println("MALE YELLOW HUMAN");
    }
}
