package sj;

public class UserService {

    UserDao dao = new UserDao();

    public boolean regist(String userName, String pwd){
        return dao.insert(userName,pwd);
    }

    public UserInfo login(String name,String pwd){
        UserInfo user = dao.searchUser(name,pwd);
        if(user!=null){
            return user;
        }
        return null;
    }
}
