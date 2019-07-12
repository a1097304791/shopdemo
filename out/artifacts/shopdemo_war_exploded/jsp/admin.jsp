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
    <!--直接在输入框中进行修改, 点击更改即可实现更改-->
    <tr>
        <form method="post">
            <td><%= aution.getId()%></td>
            <td><input type="text" name="name" value="<%= aution.getName()%>"></td>
            <td><input type="text" name="category" value="<%= aution.getCategory().getName()%>"></td>
            <td><input type="text" name="price" value="<%= aution.getPrice()%>"></td>
            <td><input type="text" name="description" value="<%= aution.getDescription()%>"></td>
            <input name="id" value='<%= aution.getId() %>' type="hidden">
            <td><a href="DeletAutionServlet?id=<%=aution.getId()%>">删除</a></td>
            <td><a href="UpdateAutionServlet?id=<%=aution.getId()%>&name=<%=aution.getName()%>&description=<%=aution.getDescription()%>
                                            &price=<%=aution.getPrice()%>&category=<%=aution.getCategory().getName()%>">更改</a></td>
        </form>
    </tr>
    <%
        }
    %>


    <tr>
        <form method="post">
            <td><input type="" name=""></td>
            <td><input type="text" name="name"></td>
            <td><input type="text" name="category"></td>
            <td><input type="text" name="price"></td>
            <td><input type="text" name="description"></td>
            <td><a href="AddAutionServlet>">添加商品</a></td>
        </form>
    </tr>

</table>


</body>
</html>
