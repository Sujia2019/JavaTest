package sj;

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

        File config = new File("");

        try{
            String path = config.getCanonicalPath()+"/web/resourses/mysql.properties";
//            System.out.println(path+"/web/resourses");
            Properties properties = new Properties();

            FileInputStream fis = new FileInputStream(path);
            properties.load(fis);

            driver = properties.getProperty("DRIVER");
            url = properties.getProperty("URL");
            userName = properties.getProperty("USERNAME");
            password = properties.getProperty("PASSWORD");
        }catch (IOException e ){
            e.printStackTrace();
        }

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