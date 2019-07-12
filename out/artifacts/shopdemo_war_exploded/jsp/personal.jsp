<%@ page import="entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人中心</title>
</head>
<body>
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
<br />
<%
    User user = (User) session.getAttribute("user");
%>
姓名：<%= user.getName()%><br>
年龄：<%= user.getAge()%><br>
性别：<%= user.getGender()%><br>
家庭住址：<%= user.getAddress()%><br>
联系方式：<%= user.getTel()%><br>
email:<%= user.getEmail()%><br>
最高学历:<%= user.getEducation()%><br>
毕业院校:<%= user.getSchool()%><br>
所学专业:<%= user.getMajor()%><br>
</body>
</html>
