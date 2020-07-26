<%@ page import="web.model.Role" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <name>Edit</name>
</head>
<body>
<%! Role roleSelect; %>
<form action="/edit" method="POST">
    <table>
        <tr>
            <td>

                <table>
                    <tr>
                        <td><input type="hidden" name="id" value="${userApp.id}"></td>
<%--                        <td><input type="hidden" name="idRole" id="idRole" value="${selRole}"></td>--%>
                    </tr>
                    <tr>
                        <td><label for="name">name</label></td>
                        <td><input type="text" name="name" id="name" value="${userApp.name}"></td>
                        <td width="100px"></td>
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
                    <tr></tr>

                    <tr>
                       <td><input type="submit"  value="Edit user"></td>        <!-- formaction="/edit/${listRoles}" -->
                    </tr>

                </table>
            </td>


            <td>

                <table>
                    <tr>
<%--                        <td width="50px"></td>--%>
                        <td>
                            <c:forEach items="${listRoles}" var="role2">
                                <input type="checkbox" class="CheckBoxRole" id="${role2.id}" >  <!--onchange="changeRole()" -->
                                <input type="text" class="TextFieldRole" value="${role2.authority}"><br>
                            </c:forEach>


                            <script>
                                var arrRoleUser = new Array();
                                initRole();

                                function initRole() {
                                    checks = document.getElementsByClassName("CheckBoxRole");
                                    textfields = document.getElementsByClassName("TextFieldRole");
                                    <c:forEach items="${userApp.roles}" var="role1">
                                    for (let i = 0; i < textfields.length - 1; i++) {
                                        if (textfields[i].getAttribute("value") === "${role1.authority}") {
                                            checks[i].setAttribute("checked", true);
                                        }
                                    }
                                    </c:forEach>
                                }



                                function changeRole() {
                                    <%--arrRoleUser.clear();--%>
                                    <%--arrRoleUser.push(${userApp.id});--%>
                                    <%--checks = document.getElementsByClassName("CheckBoxRole");--%>
                                    <%--textfields = document.getElementsByClassName("TextFieldRole");--%>
                                    <%--<c:forEach items="${listRoles}" var="role3">--%>
                                    <%--for (let i = 0; i < textfields.length - 1; i++) {--%>
                                    <%--    if (textfields[i].getAttribute("value") === "${role3.authority}"--%>
                                    <%--      && (checks[i].getAttribute("checked") === true)) {--%>
                                    <%--        arrRoleUser.push(${role3.id});--%>
                                    <%--        ${listRoles.add()}--%>
                                    <%--    }--%>
                                    <%--}--%>
                                    <%--</c:forEach>--%>
                                }
                            </script>

                        </td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>

</form>

</body>
</html>