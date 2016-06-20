<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Маршруты</title>
</head>
<body>
<h3>Добавление маршрута</h3> <br/>
<form id="routeForm" method="post">
    Название маршрута: <input name="name" type="text" form="routeForm" required/> <br/>
    Цена за минуту: <input name="price" type="number" step="0.01" required/>
    <table border="1">
        <tr>
            <td>id</td>
            <td>Название станции</td>
            <td>Вокзал/доп.инфо</td>

            <td>Время прибытия (мин.)</td>
            <td>Время стоянки (мин.)</td>
        </tr>
        <c:forEach var="station" items="${stations}">
            <tr>
                <td><c:out value="${station.id}"/></td>
                <td><c:out value="${station.name}"/></td>
                <td><c:out value="${station.suffix}"/></td>

                <td><input type="number" name="arrival" form="routeForm"/></td>
                <td><input type="number" name="stay" form="routeForm"/></td>
            </tr>
        </c:forEach>
    </table>
    <input type="submit"/>
</form>
<br/>
<a href="/sbb/admin/addStation"><button>Добавить новую станцию</button></a>
<a href="/sbb/admin"><button>На главную</button></a>
</body>
</html>
