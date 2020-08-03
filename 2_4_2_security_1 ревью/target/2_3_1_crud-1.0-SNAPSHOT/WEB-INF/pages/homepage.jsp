<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 28.07.2020
  Time: 19:51
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>Привет ${userApp.name} ${userApp.lastname}!</p>
<p>Пароль ${userApp.password}</p>
<p>Возраст ${userApp.old}</p>
<p>E-mail: ${userApp.name}</p>
<br>
<br>
<br>
<a href="<c:url value="/logout" />">Logout</a>
</body>
</html>
