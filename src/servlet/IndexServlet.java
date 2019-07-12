package servlet;

import daoImpl.AutionDaoImpl;
import entity.Aution;
import entity.Cart;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "IndexServlet", urlPatterns = "/IndexServlet")
public class IndexServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        AutionDaoImpl autionDao = new AutionDaoImpl();
        ArrayList<Aution> autions = autionDao.findAllAution(); //获取全部商品
        ArrayList<Cart> carts = new ArrayList<>();             //初始化生成临时购物车

        if(request.getSession().getAttribute("carts") == null)
            request.getSession().setAttribute("carts", carts); //用户登录后在Session中生成用户专属购物车替换该临时购物车

        request.setAttribute("autions", autions);
        request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
    }
}
