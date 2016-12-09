<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/12/3 0003
  Time: 22:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="common/inc.jsp"%>
<html>
<head>
    <title>home page</title>
    <link rel="stylesheet" href="${ctx}/static/css/home.css">
</head>
<body>
<c:if test="${sessionScope.user eq null}">
    <c:redirect url="${ctx}/index.jsp"/>
</c:if>
${sessionScope.user}
<h1>南无地藏菩萨摩诃萨</h1>
<h1>南无本师释迦牟尼佛</h1>
<h1>南无观世音菩萨摩诃萨</h1>
<h1>南无阿弥陀佛</h1>
<h1>南无大势至菩萨摩诃萨</h1>
<h1>南无药师琉璃光如来</h1>
<h1>南无月光遍照菩萨</h1>
<h1>南无日光遍照菩萨</h1>
<h1>南无坚净信菩萨摩诃萨</h1>
<hr>
<form action="${ctx}book/add" method="post">
    <input type="text" name="bookTitle" placeholder="书名"><br>
    <input type="text" name="author" placeholder="作者"><br>
    <input type="text" name="publishing" placeholder="出版社"><br>
    <input type="submit" value="ADD">
</form>
<hr>
<h2>书单</h2>
<table border="1" cellspacing="0" cellpadding="10" >
    <tr>
        <th>序号</th>
        <th>书名</th>
        <th>作者</th>
        <th>出版社</th>
        <th colspan="2">操作</th>
    </tr>
    <c:forEach var="book" items="${sessionScope.books}" varStatus="vs">
        <tr>
            <td>${vs.count}</td>
            <td>${book.bookTitle}</td>
            <td>${book.author}</td>
            <td>${book.publishing}</td>
            <td><a href="${ctx}/book?action=search&id=${book.id}">修改</a></td>
            <td><a href="${ctx}/book?action=remove&id=${book.id}">删除</a></td>
        </tr>
    </c:forEach>

</table>


<hr>
<a href="${ctx}user/logout">log out</a>


</body>
</html>
