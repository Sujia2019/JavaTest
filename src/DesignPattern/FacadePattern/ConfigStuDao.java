package DesignPattern.FacadePattern;

public class ConfigStuDao implements ConfigDao {
    @Override
    public void insertData() {
        System.out.println("dao:insert--->");
    }

    @Override
    public void updateData() {
        System.out.println("dao:update--->");
    }
}
