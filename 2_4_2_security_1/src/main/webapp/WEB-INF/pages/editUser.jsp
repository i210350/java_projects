<%@ page import="web.model.Role" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
        <name>Edit</name>
</head>
<body>
<%!  Role roleSelect; %>
<form action="/edit" method="POST">

<table>
<tr>

    <td>
        <input type="hidden" name="id" value="${userApp.id}">
    <td><input type="hidden" name="idRole" id="idRole" value="${selRole}"></td>
    </td>
</tr>
    <tr>

    </tr>
     <tr>
         <td><label for="name">name</label></td>
         <td><input type="text" name="name" id="name" value="${userApp.name}"></td>
         <td width="100px"></td>
<%--         <td>--%>
<%--             <c:forEach items="${userApp.roles}" var="role1">--%>
<%--                 <input type="text" name="name1" id="name1" value="${role1.authority}">--%>
<%--             </c:forEach>--%>
<%--             <input type="button" value="-->"><br>--%>
<%--         </td>--%>
<%--         <td width="50px"></td>--%>
<%--         <td>--%>
<%--&lt;%&ndash;             <form id="formRole" action="/edit/add_role" method="GET">&ndash;%&gt;--%>
<%--                     <c:forEach items="${listRoles}" var="role2" >--%>
<%--&lt;%&ndash;                         <input  type="button" formmethod="get" formaction="/edit/add_role?idRole=${role2.id} & id=${userApp.id}" value="<--" onClick="esample();">&ndash;%&gt;--%>
<%--                         <button id="btAdd" class="float-left submit-button" ><--</button>--%>
<%--                         <input type="text" value="${role2.authority}" ><br>--%>
<%--                     </c:forEach>--%>
<%--                         <script>--%>
<%--                             // function esample() {--%>
<%--                                &lt;%&ndash;document.getElementById("idRole").value = ${role2.id};&ndash;%&gt;--%>
<%--                                 document.getElementById("btAdd").onclick = function () {--%>
<%--                                     location.href = "/edit/add_role?idRole=${role2.id} & id=${userApp.id}";}--%>
<%--                             // }--%>
<%--                         </script>--%>

<%--&lt;%&ndash;             </form>&ndash;%&gt;--%>
<%--&lt;%&ndash;             ?id=${userApp.id}&idRole=${role2.id}"&ndash;%&gt;--%>
<%--         </td>--%>
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

<form action="/edit" method="GET">
<table>
    <tr>
        <td>
            <c:forEach items="${userApp.roles}" var="role1">
                <input type="text" name="name1" id="name1" value="${role1.authority}">
            </c:forEach>
            <input type="button" value="-->"><br>
        </td>
        <td width="50px"></td>
        <td>
            <%--             <form id="formRole" action="/edit/add_role" method="GET">--%>
            <c:forEach items="${listRoles}" var="role2"  >
<%--                <input  type="button" formmethod="get" formaction="/edit/add_role?idRole=${role2.id} & id=${userApp.id}" value="<--" onClick="esample();">--%>
<%--                <button id="btAdd" class="float-left submit-button" ><--</button>--%>
                <script>

                    arrID = new Array(2);
                    arrID[0] = ${role2.id};
                    arrID[1] = ${userApp.id};
                </script>
                <a href="/edit/add_role/${arrID}"><--</a>
                <input type="text" value="${role2.authority}" ><br>
            </c:forEach>
            <script>

<%--                function esample() {--%>
<%--                    document.getElementById("idRole").value = document.getElementById("").value;--%>
<%--                };--%>
<%--                &lt;%&ndash;document.getElementById("idRole").value = ${role2.id};&ndash;%&gt;--%>
<%--                document.getElementById("btAdd").onclick = function () {--%>
<%--                    location.href = "/edit/add_role?idRole=${role2.id} & id=${userApp.id}";}--%>
<%--                // }--%>
//             </script>

            <%--             </form>--%>
            <%--             ?id=${userApp.id}&idRole=${role2.id}"--%>
        </td>
    </tr>
</table>
</form>

</body>
</html>