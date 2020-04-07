package Homework.dbConnection;

import java.sql.Connection;

public interface ConnectionPool {

    /**
     * 初始化
     */
    void init();

    /**
     * 获取一个连接
     *
     * @return
     */
    Connection getConnection();

    /**
     * 释放一个连接
     *
     * @param connection
     */
    void releaseConnection(Connection connection);


    /**
     * 摧毁连接
     */
    void destroy();



}
