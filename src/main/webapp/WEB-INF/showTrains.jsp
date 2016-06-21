<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Trains</title>
</head>
<body>
<h3>Поезда</h3> <br/>
<form id="trainForm" method="post">
    <table border="1">
        <tr>
            <td>id</td>
            <td>Название поезда</td>
            <td>Количество мест</td>
            <td>Смотреть вагончики</td>
        </tr>
        <c:forEach var="train" items="${trains}">
            <tr>
                <td><c:out value="${train.id}"/></td>
                <td><c:out value="${train.name}"/></td>
                <td><c:out value="${train.seats}"/></td>
                <td><input type="submit" value="show" form="trainForm"/></td>
            </tr>
        </c:forEach>
    </table>
</form>
<br/>
<a href="/sbb/admin/showCarriages"><button>Посмотреть доступные типы вагонов</button></a>
<a href="/sbb/admin/addTrain"><button>Добавить новый поезд</button></a>
</body>
</html>
