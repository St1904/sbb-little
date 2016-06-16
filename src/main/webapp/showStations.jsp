<%@ page import="core.dao.model.Station" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>Тут как бы все станции в одной таблице</h3> <br/>
    <%--<table border="1">
        <c:forEach var="station" items="${stations}">
            <tr>
                <td>${station}</td>
            </tr>
        </c:forEach>
    </table>--%>


    <%--<c:out value="${testString}"/> it's working string--%>

    <c:forEach var="sss" items="${strings}">
        ${sss} <br/>
    </c:forEach>


<%--    <%
        List<Station> stations = (List<Station>) request.getAttribute("stations");
        for (Station station : stations) {
            out.println(station);
        }

    %>--%>
</body>
</html>
