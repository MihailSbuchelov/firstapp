<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Miha_admin
  Date: 28.11.2021
  Time: 16:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Assortment</title>
</head>
<body>
<h2>
    Ассортимент:
</h2>
<h3>${products}</h3>
<c:url var="cartUrl" value="cart"></c:url>
<h2><a href=${cartUrl}>"Корзина"</a></h2>
<br>
<br>

<h2>Выберите ID:</h2>
<br>
<form action="add/">
    <select name="id">
        <c:forEach items="${listIdAssortment}" var="id">
            <option>${id}</option>
        </c:forEach>
    </select>
    <input type="submit" value="Добавить">
</form>
</body>
</html>
