package DesignPattern.FactoryPattern.abstractFactory;

public class FemaleYellowHuman extends AbstractYellowHuman {
    @Override
    public void getGender() {
        System.out.println("FEMALE YELLOW HUMAN");
    }
}
