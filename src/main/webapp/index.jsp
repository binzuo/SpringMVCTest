<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/12/3 0003
  Time: 20:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>index page</title>
  </head>
  <body>
  <h1>index page</h1>
  <hr>
  <a href="signup.jsp">sign up</a>
  ${sessionScope.congratulation}
  <form action="/user/login" method="post">
    <input type="text" name="email" placeholder="邮箱" value="18310996173xiaozuo@gmail.com"><br>
    <input type="password" name="password" placeholder="PASSWORD" value="123"><br>
    <input type="submit" value="login">
  </form>
  ${sessionScope.warning}



  </body>
</html>
