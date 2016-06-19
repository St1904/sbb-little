<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>Добавление новой станции</h2>
    <form method="post">
        Название станции: <input type="text" name="stationName" required/> <br>
        Подстанция/вокзал: <input type="text" name="stationSuffix" required/> <br>
        <button type="submit">Добавить</button>
    </form>
    <a href="/sbb/admin"><button>На главную</button></a>
</body>
</html>
