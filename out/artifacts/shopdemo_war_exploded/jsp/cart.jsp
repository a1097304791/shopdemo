<%@ page import="entity.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="entity.Cart" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
shopdemo欢迎您!,

<%
    User user = (User) session.getAttribute("user");
    ArrayList<Cart> carts = (ArrayList<Cart>) session.getAttribute("carts");
    if(user==null){
        out.print("请<a href=\"login.jsp\">登录</a>\n" +
         "<br>当前为临时购物车<br>");
    }
    else{
        out.print("欢迎您! "+user.getName()+"<br>");
    }
%>

<br>
<br>
<table>
    <tr>
        <td><a href="/shopdemo_war_exploded/PersonalServlet">个人中心</a></td>
    </tr>

    <tr>
        <td><a href="/shopdemo_war_exploded/IndexServlet">全部商品</a></td>
    </tr>
    <tr>
        <td><a href="jsp/cart.jsp">我的购物车</a></td>
    </tr>

</table>

<br>
<br>
<html>
<head>
    <title>商品列表</title>
</head>
<body>
<table border="1">
    <tr>
        <td>商品名称</td>
        <td>商品单价</td>
        <td>商品数量</td>
        <td>商品总价</td>
    </tr>
    <%
        for (Cart cart:carts)
        {
    %>
    <tr>
        <form action="/shopdemo_war_exploded/CartOptionServlet?option=removeCart" method="post">
            <td><%= cart.getName()%></td>
            <td><%= cart.getPrice()%></td>
            <td><%= cart.getCount() %></td>
            <td><%= cart.getTotalPrice()%></td>
            <input name="name" value='<%= cart.getName() %>' type="hidden">
            <input name="price" value='<%= cart.getPrice() %>' type="hidden">
            <td><input type="submit" value="删除"></td>
        </form>
    </tr>
    <%
        }
    %>
</table>

</body>
</html>
