package servlet;

import daoImpl.UserDaoImpl;
import entity.User;
import utils.BaseDao;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/LoginServlet")
public class LoginServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //登录状态显示在登录框的最上面
        String LoginStatus = "";
        String fowardPath = "/jsp/login.jsp";
        UserDaoImpl dao = new UserDaoImpl();

        boolean isExist = true;
        if(!dao.isExist(username)){
            LoginStatus = "User Not Found";
            isExist = false;
            fowardPath = "jsp/login.jsp";
        }
        //先判断该用户名是否存在, 再判断密码是否匹配
        if(isExist){
            User user = dao.findUserByUsername(username);
            if (!user.getPassword().equals(password)){
                LoginStatus = "Invalid Password";
                fowardPath = "jsp/login.jsp";
            }else {
                request.getSession().setAttribute("user", user);
                LoginStatus = "Login Successfully";
                if(user.getAdm()) fowardPath = "AdminServlet";
                else fowardPath = "IndexServlet";
            }
        }
        request.setAttribute("LoginStatus", LoginStatus);
        request.getRequestDispatcher(fowardPath).forward(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request, response);
    }
}
