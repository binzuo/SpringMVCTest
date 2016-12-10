<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/12/3 0003
  Time: 21:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/inc.jsp"%>
<html>
<head>
    <title>sign up page</title>
</head>
<body>
<form action="${ctx}user/create" method="post">
    <input type="text" name="email" placeholder="邮箱" value="xiaozuo@gamil.com" ><br>
    <input type="password" name="password" placeholder="PASSWORD" value="123" ><br>
    <input type="submit" value="sign up">
</form>
${requestScope.prompt}

</body>
</html>
