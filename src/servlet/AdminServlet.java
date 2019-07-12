package servlet;

import daoImpl.AutionDaoImpl;
import entity.Aution;
import entity.Cart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "AdminServlet", urlPatterns = "/AdminServlet")
public class AdminServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        AutionDaoImpl autionDao = new AutionDaoImpl();
        ArrayList<Aution> autions = autionDao.findAllAution(); //获取全部商品
        ArrayList<Cart> carts = new ArrayList<>();             //初始化生成临时购物车

        if(request.getSession().getAttribute("carts") == null)
            request.getSession().setAttribute("carts", carts); //用户登录后在Session中生成用户专属购物车替换该临时购物车

        request.setAttribute("autions", autions);
        request.getRequestDispatcher("jsp/admin.jsp").forward(request, response);
    }
}
