package ConnectionTest;

import com.alibaba.druid.pool.DruidDataSource;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DruidUtil {

    private static DruidDataSource config;
    private static DruidUtil util = new DruidUtil();

    private DruidUtil(){
        config = new DruidDataSource();
        File c = new File("src/Homework/dbConnection/mysql.properties");
        Properties properties = new Properties();
        try{
            FileInputStream fis = new FileInputStream(c);
            properties.load(fis);
        }catch (IOException e ){
            e.printStackTrace();
        }
        String driver = properties.getProperty("DRIVER");
        String url = properties.getProperty("URL");
        String userName = properties.getProperty("USERNAME");
        String password = properties.getProperty("PASSWORD");
        config.setUrl(url);
        config.setDriverClassName(driver);
        config.setUsername(userName);
        config.setPassword(password);
        config.setMaxActive(150);
    }

    public static Connection getConnection() {
        try {
            return config.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
