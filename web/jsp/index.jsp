<%@ page import="entity.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="entity.Aution" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<%
    User user = (User) session.getAttribute("user");
    ArrayList<Aution> autions = (ArrayList<Aution>) request.getAttribute("autions");
%>

<html>
    shopdemo欢迎您!,

<%
    if(user==null) out.print("请<a href=\"jsp/login.jsp\">登录</a>\n");
    else{
        if(user.getAdm())
            out.print("欢迎您, 管理员! "+user.getName()+"  <a href=\"LogoutServlet\">退出登录</a>");
        else
            out.print("欢迎您! "+user.getName()+"  <a href=\"LogoutServlet\">退出登录</a>");
    }
%>

<br>
<br>
<table>
    <tr>
        <td><a href="PersonalServlet">个人中心</a></td>
    </tr>

    <tr>
        <td><a href="IndexServlet">全部商品</a></td>
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
        <td> id </td>
        <td>name</td>
        <td>Category</td>
        <td>price</td>
        <td>description</td>
    </tr>
    <%
        for (Aution aution:autions)
        {
    %>
    <tr>
        <form action="CartOptionServlet?option=addCart" method="post">
            <td><%= aution.getId()%></td>
            <td><%=aution.getName() %></td>
            <td><%= aution.getCategory().getName()%></td>
            <td><%=aution.getPrice() %></td>
            <td><%= aution.getDescription()%></td>
            <input name="name" value='<%= aution.getName() %>' type="hidden">
            <input name="price" value='<%= aution.getPrice() %>' type="hidden">
            <td><input type="submit" value="加入购物车"></td>
        </form>
    </tr>
    <%
        }
    %>
</table>

</body>
</html>
