package Homework.dbConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ConnectionPoolImpl implements ConnectionPool{


    private LinkedBlockingQueue<Connection> idleConnectPool;

    private LinkedBlockingQueue<Connection> busyConnectPool;

    private AtomicInteger activeSize = new AtomicInteger(0);

    private final int maxSize;

    public ConnectionPoolImpl(int maxSize){
        this.maxSize = maxSize;
        init();
    }

    public ConnectionPoolImpl(){
        this.maxSize = 2000;
        init();

    }


    @Override
    public void init() {
        idleConnectPool = new LinkedBlockingQueue<>();
        busyConnectPool = new LinkedBlockingQueue<>();
        for(int i=0;i<10;i++){
            Connection connection = DBUtil.getConnection();
            idleConnectPool.offer(connection);
        }
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (true){
//                    try {
//                        Thread.sleep(50000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    check();
//                }
//            }
//        });
    }

    @Override
    public Connection getConnection() {
        //取出一个连接
        Connection connection = idleConnectPool.poll();
        if(connection!=null){
            //如果有连接，放入busy池中
            busyConnectPool.offer(connection);
            System.out.println("获取到连接");
            return connection;
        }
        //synchronized效率较低
        //idle池中没有连接
        //如果idle池中连接未满maxSize，就新建一个连接
        if(activeSize.get()<maxSize){
            //通过 activeSize.incremeAndGet() <= maxSize 这个判断
            //通过 if(activeSize.get() < maxSize) 存在的线程安全问题
            if(activeSize.incrementAndGet() <= maxSize){
                connection = DBUtil.getConnection();
                busyConnectPool.offer(connection);
                return connection;
            }
        }

        try{
            System.out.println("排队等待连接");
            connection = idleConnectPool.poll(10000, TimeUnit.MILLISECONDS);
            // 阻塞获取连接，如果10秒内有其他连接释放，
            if(connection == null){
                System.out.println("等待超时");
                throw new RuntimeException("等待连接超时");
            }
            System.out.println("等待到了一个连接");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public void releaseConnection(Connection connection) {
        if (connection!=null){
            busyConnectPool.remove(connection);
            idleConnectPool.offer(connection);
        }
    }

    @Override
    public void destroy() {
        busyConnectPool = null;
        idleConnectPool = null;
    }


    /**
     * 定时对连接进行健康检查
     * 注意，只能对idle连接池中的连接进行健康检查
     * 不可以对busyConnectPool连接池中的连接进行健康检查，因为它正在被客户端使用
     */
    public void check(){
        for(int i=0;i<idleConnectPool.size();i++){
            Connection connection = idleConnectPool.poll();
            try{
                boolean valid = connection.isValid(2000);
                if(!valid){
                    //如果连接不可用，则创建一个新连接
                    connection = DBUtil.getConnection();
                }
                //放进一个可用的连接
                idleConnectPool.offer(connection);
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }


}
