package servlet;

import entity.Aution;
import entity.Cart;
import entity.Category;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "CartOptionServlet", urlPatterns = "/CartOptionServlet")
public class CartOptionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String forwardPath = "";

        ArrayList<Cart> carts = (ArrayList<Cart>) request.getSession().getAttribute("carts");
        if(carts==null)
            carts = new ArrayList<Cart>();

        String name = request.getParameter("name");
        String option = request.getParameter("option"); //直接获取请求行参数
        double price = Double.parseDouble(request.getParameter("price"));

        if("addCart".equals(option)){
            //判断购物车有无该物品, 有则数量加一更新总价, 没有则添加该物品
            boolean isFind = false;
            for(Cart cart:carts){
                if(cart.getName().equals(name)){
                    cart.setCount(cart.getCount()+1);
                    cart.setTotalPrice(cart.getPrice()*cart.getCount());
                    isFind = true;
                    break;
                }
            }
            if(!isFind){
                carts.add(new Cart(name, price, price, 1));
            }
            forwardPath = "IndexServlet";
        }
        else if("removeCart".equals(option)){
            //删除该物品并更新对应Cart
            for(Cart cart:carts){
                if(cart.getName().equals(name)){
                    //数量为1直接删去, >1则更新
                    cart.setCount(cart.getCount()-1);
                    cart.setTotalPrice(cart.getCount()*cart.getPrice());
                    if(cart.getCount() < 1)
                        carts.remove(cart);
                }
            }
            forwardPath = "jsp/cart.jsp";
        }

        System.out.println("购物车内容: ");
        for(Cart cart: carts)
            System.out.println(cart.getName() + " ");

        request.getSession().setAttribute("carts", carts);
        request.getRequestDispatcher(forwardPath).forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
