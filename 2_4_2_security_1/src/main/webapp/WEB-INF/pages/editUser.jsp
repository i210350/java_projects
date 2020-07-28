<%@ page import="web.model.Role" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <name>Edit</name>

    <script type="text/javascript">
        function changeRole(idEl) {

            chb = document.getElementById("chb"+idEl);
            idR = document.getElementById("idR"+idEl);
            if (chb.checked) idR.setAttribute("value", chb.getAttribute("value"));
            else idR.setAttribute("value", "0");
        }
    </script>

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
                        <td><input type="submit"  value="Edit user"></td>
                    </tr>
                    <tr>
                        <br>
                        <br>
                        <br>
                        <a href="<c:url value="/logout" />">Logout</a>
                    </tr>

                </table>
            </td>


            <td>

                <table>
                    <tr>
                        <td>
                                <c:forEach items="${listRoles}" var="role2">
                                    <input type="checkbox" class="CheckBoxRole" id="chb${role2.id}" value="${role2.id}"
                                                                        onchange='changeRole(this.getAttribute("value"))'>
                                    <input type="text" class="TextFieldRole" id="tx${role2.id}" value="${role2.authority}" >
                                    <input type="hidden" class="idFieldRole" name="idRoles" id="idR${role2.id}" value=0 ><br>
                                </c:forEach>


                            <script>
                                textfields = document.getElementsByClassName("TextFieldRole");
                                checks = document.getElementsByClassName("CheckBoxRole");
                                idfields = document.getElementsByClassName("idFieldRole");

                                initRole();

                                function initRole() {
                                    <c:forEach items="${userApp.roles}" var="role1">
                                    for (let i = 0; i < textfields.length ; i++) {
                                        if (checks[i].getAttribute("value") === ${role1.id}+"") {
                                            checks[i].setAttribute("checked",true);
                                            idfields[i].setAttribute("value", checks[i].getAttribute("value"));
                                        }
                                    }
                                    </c:forEach>
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