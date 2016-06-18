<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>Тут как бы все станции в одной таблице</h3> <br/>
    <table border="1">
        <tr>
            <td>id</td>
            <td>Название станции</td>
            <td>Вокзал/доп.инфо</td>
        </tr>
        <c:forEach var="station" items="${stations}">
            <tr>
                <td><c:out value="${station.id}"/></td>
                <td><c:out value="${station.name}"/></td>
                <td><c:out value="${station.suffix}"/></td>
            </tr>
        </c:forEach>
    </table>




</body>
</html>
