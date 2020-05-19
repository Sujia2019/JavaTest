package DesignPattern.FacadePattern;

public class Test {
    public static void main(String[] args) {
        ConfigManager manager = new ConfigManager();

        manager.getConfigDao().insertData();
        manager.getConfigModel().createModel();
    }
}
