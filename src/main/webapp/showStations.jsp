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
<%--    <c:forEach var="sss" items="${testString}">
        ${sss} <br/>
    </c:forEach>--%>
<%--    <table border="1">
        <c:forEach var="str" items="${requestScope['testString']}">
            <tr>
                <td>${str}</td>
            </tr>
        </c:forEach>
    </table>--%>

    <%
        List<Station> stations = (List<Station>) request.getAttribute("stations");
        for (Station station : stations) {
            out.println(station);
        }

    %>
</body>
</html>
