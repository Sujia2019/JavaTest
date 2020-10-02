package DesignPattern.FacadePattern;

public class ConfigStuModel implements ConfigModel {
    @Override
    public void createModel() {
        System.out.println("com.sj.model:create--->");
    }

    @Override
    public void operation() {
        System.out.println("com.sj.model:operation--->");
    }
}
