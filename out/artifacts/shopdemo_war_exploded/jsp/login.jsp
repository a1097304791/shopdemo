<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 4/22/2019
  Time: 2:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<head>
    <title>登陆界面</title>
</head>
<%
    String LoginStatus = (String) request.getAttribute("LoginStatus");
    if(LoginStatus != null)
        out.println("<font color='red'>"+LoginStatus+"</font><br>");
%>
<body>
    <form action="/shopdemo_war_exploded/LoginServlet" method="post">
        username: <input type="text" name="username" /> <br>
        password: <input type="text" name="password" /> <br>
        <input type="submit" value="Login">
    </form>
</body>
</html>
