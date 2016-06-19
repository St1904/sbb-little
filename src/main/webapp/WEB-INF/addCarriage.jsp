<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Вагончики</title>
</head>
<body>
    <h2>Добавление нового вагона</h2>
    <form method="post">
        Название: <input type="text" name="name" required/> <br/>
        Количество мест: <input type="number" name="capacity" required/> <br/>
        Стоимость одного места: <input type="number" step="0.01" name="price" required/> <br/>
        <button type="submit">Добавить</button>
    </form>
    <a href="/sbb/admin"><button>На главную</button></a>
</body>
</html>
