package ConnectionTest;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class HikariCPUtil {
    private static HikariConfig config;
    private static HikariDataSource dbSource;
    private static HikariCPUtil util = new HikariCPUtil();
//    HikariC

    private HikariCPUtil(){
        config = new HikariConfig();
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
        config.setJdbcUrl(url);
        config.setDriverClassName(driver);
        config.setUsername(userName);
        config.setPassword(password);
        config.setMaximumPoolSize(150);
        dbSource = new HikariDataSource(config);
    }

    static synchronized Connection getConnection()  {
        try {
            return dbSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void close(Connection c){
        try {
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
