<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Miha_admin
  Date: 28.11.2021
  Time: 21:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <title>Корзина продуктов</title>
</head>
<h1>Корзина продуктов</h1>
<h3>
    ${cart}
</h3>
<c:url var="assortmentUrl" value="assortment"></c:url>
<h2><a href=${assortmentUrl}>"Ассортимент"</a></h2>
<br><br>

<h2>Выберите ID:</h2><br>
<form action="del/">
    <select name="id">
        <c:forEach items="${listId}" var="id">
            <option value="${id}">${id}</option>
            <c:set var="idSelected" value="${id}"/>
        </c:forEach>
    </select>
    <input type="submit" value="Удалить">
</form>
<br>
</body>
</html>