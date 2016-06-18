<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>Тут как бы все станции в одной таблице</h3> <br/>
    <table border="1">
        <c:forEach var="station" items="${stations}">
            <tr>
                <td>${station.id}</td><td>${station.name}</td><td>${station.suffix}</td>
            </tr>
        </c:forEach>
    </table>


</body>
</html>
