<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:if test="${empty user.name}">
        <name>Add</name>
    </c:if>
    <c:if test="${!empty user.name}">
        <name>Edit</name>
    </c:if>
</head>
<body>
<c:if test="${empty user.name}">
    <c:url value="/add" var="var"/>
</c:if>
<c:if test="${!empty user.name}">
    <c:url value="/edit" var="var"/>
</c:if>
<form action="${var}" method="POST">
    <c:if test="${!empty user.name}">
        <input type="hidden" name="id" value="${user.id}">
    </c:if>
    <label for="name">name</label>
    <input type="text" name="name" id="name">
    <label for="lastname">lastname</label>
    <input type="text" name="lastname" id="lastname">
    <label for="password">password</label>
    <input type="text" name="password" id="password">
    <label for="old">old</label>
    <input type="text" name="old" id="old">
    <label for="mail">mail</label>
    <input type="text" name="mail" id="mail">
    <label for="roleCurrent">roleCurrent</label>
    <input type="text" name="roleCurrent" id="roleCurrent">
    <c:if test="${empty user.name}">
        <input type="submit" value="Add new user">
    </c:if>
    <c:if test="${!empty user.name}">
        <input type="submit" value="Edit user">
    </c:if>
</form>
</body>
</html>