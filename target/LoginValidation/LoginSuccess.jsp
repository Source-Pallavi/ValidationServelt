<%--
  Created by IntelliJ IDEA.
  User: cpsharma
  Date: 16-May-20
  Time: 8:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html"; charset="US-ASCII">
    <title>Login Success Page</title>
</head>
<body>
<h3>Hi <%= request.getAttribute("user")%>, Login successful.</h3>
<a href="login.html">Login Page</a>
</body>
</html>
