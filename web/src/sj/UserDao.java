package sj;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    private Connection connection = DBUtil.getConnection();
    private PreparedStatement ps ;
    private static int id = 50;
    private ResultSet rs ;

    public boolean insert(String userName,String pwd){
        try {
            ps = connection.prepareStatement("INSERT INTO test11.xxx values (?,?,?)");
            id++;
            ps.setString(1,id+"");
            ps.setString(2,userName);
            ps.setString(3,pwd);
            return ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public UserInfo searchUser(String name,String pwd){
        try {
            ps = connection.prepareStatement("SELECT * FROM test11.xxx WHERE username=? AND pwd = ?");
            ps.setString(1,name);
            ps.setString(2,pwd);
            ps.execute();
            rs = ps.getResultSet();
            if(rs!=null){
                String id = rs.getString("id");
                UserInfo userInfo = new UserInfo();
                userInfo.setUserId(id);
                userInfo.setUserName(name);
                userInfo.setUserPwd(pwd);
                return userInfo;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
