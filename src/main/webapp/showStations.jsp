<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>Тут как бы все станции в одной таблице</h3> <br/>
    <table>
        <c:forEach var="station" items="${stationList}">
            <tr>
                <td>${station}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
