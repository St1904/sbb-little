<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>Добавление нового поезда.</h2>
    <form method="post" id="addTrain">
        <input type="text" name="name" required/>
        <table border="1">
            <tr>
                <td>id</td>
                <td>Тип вагона</td>
                <td>Вместительность</td>
                <td>Стоимость одного места</td>

                <td>Количество вагонов</td>
            </tr>
            <c:forEach var="carriage" items="${carriages}">
                <tr>
                    <td><c:out value="${carriage.id}"/></td>
                    <td><c:out value="${carriage.type}"/></td>
                    <td><c:out value="${carriage.capacity}"/></td>
                    <td><c:out value="${carriage.priceForCarriage}"/></td>

                    <td><input type="number" value="0" name="carriageNumber" form="addTrain"/></td>
                </tr>

            </c:forEach>
        </table>
        <input type="submit"/>
    </form>
</body>
</html>
