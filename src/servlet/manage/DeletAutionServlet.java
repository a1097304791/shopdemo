package servlet.manage;

import daoImpl.AutionDaoImpl;
import entity.Aution;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "DeletAutionServlet", urlPatterns = "/DeletAutionServlet")
public class DeletAutionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        int id = Integer.parseInt(request.getParameter("id"));
        AutionDaoImpl autionDao = new AutionDaoImpl();
        autionDao.DeletAution(id);

        ArrayList<Aution> autions = autionDao.findAllAution(); //获取全部商品
        request.setAttribute("autions", autions);

        request.getRequestDispatcher("jsp/admin.jsp").forward(request, response);
    }
}
