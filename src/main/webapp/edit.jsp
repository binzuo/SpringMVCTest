<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/12/10
  Time: 11:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="common/inc.jsp"%>
<html>
<head>
    <title>edit page</title>
</head>
<body>
<form action="${ctx}/book/modify" method="post">
    <input type="hidden" name="id" value="${sessionScope.book.id}">
    <input type="text" name="bookTitle" placeholder="BOOKTITLE" value="${sessionScope.book.bookTitle}"><br>
    <input type="text" name="author" placeholder="AUTHOR" value="${sessionScope.book.author}"><br>
    <input type="text" name="publishing" placeholder="PUBLISHING" value="${sessionScope.book.publishing}"><br>
    <input type="submit" value="SAVE">
</form>


</body>
</html>
