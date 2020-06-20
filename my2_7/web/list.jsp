<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 17.06.2020
  Time: 22:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List" %>
<%@ page import="app.entities.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
</head>

<body>
<div>
    <h1>Super app!</h1>
</div>

<div>
    <div>
        <div>
            <h2>Users</h2>
        </div>
        <%
            List<User> names = (List<User>) request.getAttribute("user");

            if (names != null && !names.isEmpty()) {
                out.println("<ui>");
                for (User s : names) {
                    out.println("<li>" + s.getName() + "  " + s.getAge() + "</li>");
                }
                out.println("</ui>");
            } else out.println("<p>There are no users yet!</p>");
        %>
    </div>
</div>

<div>
    <button onclick="location.href='/'">Back to main</button>
</div>
</body>
</html>
