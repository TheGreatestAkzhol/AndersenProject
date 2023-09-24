<%@ page import="com.example.akosoftcompany.model.User" %><%--
  Created by IntelliJ IDEA.
  User: Akobek
  Date: 9/24/2023
  Time: 8:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p><%= "That is JavaCode" %></p>
<%= new java.util.Date()%>
<%
    User user = new User("Akzhol","Serikbek",(byte)23);
%>
<%= user%>
</body>
</html>
