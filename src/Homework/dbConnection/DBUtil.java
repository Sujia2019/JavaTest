package Homework.dbConnection;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {
    private static String driver ;
    private static String url;
    private static String userName;
    private static String password;
    private static DBUtil dbUtil = new DBUtil();

    private DBUtil(){
        File config = new File("src/Homework/dbConnection/mysql.properties");
        Properties properties = new Properties();
        try{
            FileInputStream fis = new FileInputStream(config);
            properties.load(fis);
        }catch (IOException e ){
            e.printStackTrace();
        }

        driver = properties.getProperty("DRIVER");
        url = properties.getProperty("URL");
        userName = properties.getProperty("USERNAME");
        password = properties.getProperty("PASSWORD");

    }

    public static Connection getConnection(){
        Connection connection = null;
        try{
            Class.forName(driver);
            connection = DriverManager.getConnection(url,userName,password);
        }catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        return connection;
    }



}
