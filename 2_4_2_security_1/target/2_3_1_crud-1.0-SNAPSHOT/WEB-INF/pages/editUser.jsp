<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
        <name>Edit</name>
</head>
<body>
<form action="/edit" method="POST">
<table>
<tr>

    <td><input type="hidden" name="id" value="${userApp.id}"></td>
</tr>
    <tr>

    </tr>
     <tr>
         <td><label for="name">name</label></td>
         <td><input type="text" name="name" id="name" value="${userApp.name}"></td>
         <td width="100px"></td>
         <td>
             <c:forEach items="${listRoles}" var="role1">
                 <input type="text" name="name1" id="name1" value="${role1.authority}"><br>
             </c:forEach>
         </td>
         <td>
<%--             <label>Author--%>
                 <select id="roleCurrent" name="roleCurrent">
                     <c:forEach items="${userApp.roles}" var="role2">
                         <option value="${role2.authority}" selected->"${role2.authority}"</option>
                     </c:forEach>
                 </select>
<%--             </label>--%>
         </td>
     </tr>
      <tr>
          <td><label for="lastname">lastname</label></td>
          <td><input type="text" name="lastname" id="lastname" value="${userApp.lastname}"></td>
      </tr>
       <tr>
           <td><label for="password">password</label></td>
           <td><input type="text" name="password" id="password" value="${userApp.password}"></td>
       </tr>
        <tr>
            <td><label for="old">old</label></td>
            <td><input type="text" name="old" id="old" value="${userApp.old}"></td>
        </tr>
        <tr>
            <td><label for="mail">mail</label></td>
            <td><input type="text" name="mail" id="mail" value="${userApp.mail}"></td>
        </tr>



        <%--    <label for="roleCurrent">role</label>--%>
        <%--    <input type="text" name="roleCurrent" id="roleCurrent" value="${userApp.roles}">--%>



        <tr>

            <input type="submit" value="Edit user">
        </tr>

</table>

</form>
</body>
</html>