<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
        <name>Add</name>
</head>
<body>
<form action="/add" method="POST">
    <label for="name">name</label>
    <input type="text" name="name" id="name" value="${userApp.name}">
    <label for="lastname">lastname</label>
    <input type="text" name="lastname" id="lastname" value="${userApp.lastname}">
    <label for="password">password</label>
    <input type="text" name="password" id="password" value="${userApp.password}">
    <label for="old">old</label>
    <input type="text" name="old" id="old" value="${userApp.old}">
    <label for="mail">mail</label>
    <input type="text" name="mail" id="mail" value="${userApp.mail}">
<%--    <label for="roleCurrent">role</label>--%>
<%--    <input type="text" name="roleCurrent" id="roleCurrent" value="${userApp.getAuthority}">--%>
    <input type="submit" value="Add new user">
    <br>
    <br>
    <br>
    <br>
    <a href="<c:url value="/logout" />">Logout</a>

</form>
</body>
</html>