package servlet;

import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PersonalServlet", urlPatterns = "/PersonalServlet")
public class PerSonalServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String forwardPath = "";
        User user = (User) request.getSession().getAttribute("user");
        //先判断是否已登录, 未登录则跳转至登录界面
        if(user==null){
            forwardPath = "jsp/login.jsp";
        }else{
            forwardPath = "jsp/personal.jsp";
        }

        request.getRequestDispatcher(forwardPath).forward(request, response);
    }
}
