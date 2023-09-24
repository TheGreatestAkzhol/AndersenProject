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
    <% User user = new User("Akzhol","Serikbek",(byte)23);%>
    <p><%=  System.out.println("This is JavaCode") %></p>
    <p><%=  System.out.println(user.toString()) %></p>

    <%= new java.util.Date()%>
</head>
<body>

</body>
</html>
