<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Назначение поезда</title>
</head>
<body>
    <h2>Назначить поезд на маршрут:</h2>
    <form method="post">
        Выберите поезд: <select name="sTrain">
            <c:forEach var="train" items="${trains}">
                <option value="${train.id}"><c:out value="${train}"/></option>
            </c:forEach>
        </select> <br/>
        Выберите маршрут: <select name="sRoute">
            <c:forEach var="route" items="${routes}">
                <option value="${route.id}"><c:out value="${route}"/></option>
            </c:forEach>
        </select> <br/>
        Дата: <input type="date" name="date" required/> <br/>
        Время: <input type="time" name="time" required/> <br/>
        Коэффициент цены: <input type="number" value="1" step="0.5" name="price" required/>

        <input type="submit"/>
    </form>
</body>
</html>
