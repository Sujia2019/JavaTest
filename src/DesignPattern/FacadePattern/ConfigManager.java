package DesignPattern.FacadePattern;

public class ConfigManager {
    private ConfigDao configDao;
    private ConfigModel configModel;
    public ConfigManager(){
        init();
    }
    /**
     * 加载
     */
    public void init(){
        configDao = new ConfigStuDao();
        configModel = new ConfigStuModel();
    }

    public ConfigDao getConfigDao() {
        return configDao;
    }
    public ConfigModel getConfigModel() {
        return configModel;
    }

    public void setConfigDao(ConfigDao configDao) {
        this.configDao = configDao;
    }


    public void setConfigModel(ConfigModel configModel) {
        this.configModel = configModel;
    }
}
