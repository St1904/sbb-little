<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Success</title>
</head>
<body>
    <h2><c:out value="${message}"/></h2>
    <a href="${backUrl}">Вернуться назад и добавить что-нибудь еще</a> <br/>
    <a href="/sbb/admin">На главную</a>
</body>
</html>
