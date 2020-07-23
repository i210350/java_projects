<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<%--    <c:if test="${empty user.name}">--%>
        <name>Add</name>
<%--    </c:if>--%>
<%--    <c:if test="${!empty user.name}">--%>
<%--        <name>Edit</name>--%>
<%--    </c:if>--%>
</head>
<body>
<%--<c:if test="${empty user.name}">--%>
<%--    <c:url value="/add" var="var"/>--%>
<%--</c:if>--%>
<%--<c:if test="${!empty user.name}">--%>
<%--    <c:url value="/edit" var="var"/>--%>
<%--</c:if>--%>
<form action="/add" method="POST">
<%--    <c:if test="${!empty user.name}">--%>
<%--        <input type="hidden" name="id" value="${user.id}">--%>
<%--    </c:if>--%>
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
    <label for="roleCurrent">role</label>
    <input type="text" name="roleCurrent" id="roleCurrent" value="${userApp.getAuthority}">
<%--    <c:if test="${empty user.name}">--%>
        <input type="submit" value="Add new user">
<%--    </c:if>--%>
<%--    <c:if test="${!empty user.name}">--%>
<%--        <input type="submit" value="Edit user">--%>
<%--    </c:if>--%>
</form>
</body>
</html>