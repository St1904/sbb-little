<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Carriages</title>
</head>
<body>
    <h2>Типы вагонов</h2>
    <table border="1">
        <tr>
            <td>id</td>
            <td>Тип вагона</td>
            <td>Вместительность</td>
            <td>Стоимость одного места</td>
        </tr>
        <c:forEach var="carriage" items="${carriages}">
            <tr>
                <td><c:out value="${carriage.id}"/></td>
                <td><c:out value="${carriage.type}"/></td>
                <td><c:out value="${carriage.capacity}"/></td>
                <td><c:out value="${carriage.priceForCarriage}"/></td>
            </tr>
        </c:forEach>
    </table>
    <a href="/sbb/admin/addCarriage"><button>Добавить новый тип вагона</button></a> <br/>
    <a href="/sbb/admin"><button>На главную</button></a>
</body>
</html>
