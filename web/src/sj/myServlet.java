package sj;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet
public class myServlet extends HttpServlet {
    UserService service = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String pwd = req.getParameter("pwd");
        boolean b = service.regist(userName,pwd);
        resp.setCharacterEncoding("UTF-8");
        if(b){
            resp.getOutputStream().println(userName);
//            req.getRequestDispatcher().
        }else{
            resp.getOutputStream().println("Error");
        }
    }
}
