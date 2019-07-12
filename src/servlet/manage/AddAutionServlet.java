package servlet.manage;

import daoImpl.AutionDaoImpl;
import entity.Aution;
import entity.Category;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddAutionServlet", urlPatterns = "/AddAutionServlet")
public class AddAutionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        AutionDaoImpl autionDao = new AutionDaoImpl();
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        Double price = Double.valueOf(request.getParameter("price"));
        Category category = new Category("request.getParameter(\"category\")");

        autionDao.addAution(new Aution(id, name, description, price, category));
    }
}
