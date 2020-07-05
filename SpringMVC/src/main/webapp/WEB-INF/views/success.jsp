<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
   <head><title><spring:message code="user.title"/></title></head>
<body>
  <a href="user?mylocale=en">English </a> | <a href="user?mylocale=de">German </a>
  <h3> <spring:message code="user.success"/></h3>
</body>
</html>
