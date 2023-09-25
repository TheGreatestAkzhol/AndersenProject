<%@ page import="com.example.akosoftcompany.model.User" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>
<%
    List<User> users = (List) session.getAttribute("users");
%>
<table class="table table-dark">
    <thead>
    <tr>
        <th scope="col">Id</th>
        <th scope="col">Name</th>
        <th scope="col">LastName</th>
        <th scope="col">Age</th>
        <th scope="col">Edit</th>
        <th scope="col">Delete</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${users}" var="user">
    <tr>
        <td><c:out value="${user.getId()}"/></td>
        <td><c:out value="${user.getName()}"/></td>
        <td><c:out value="${user.getLastName()}"/></td>
        <td><c:out value="${user.getAge()}"/></td>
        <td><a href="/ServletUpdateUser?id=${user.getId()}"><button type="button" class="btn btn-info">Edit</button></a>
        </td>
        <td><form method="POST" action="/ServletRemoveUser?id=${user.getId()}">
            <input type="submit" value="Delete!">
        </form>
        </td>
    </tr>
    </c:forEach>
    </tbody>
</table>
<br>
<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Add User</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="card text-white bg-dark mb-3" style="max-width: 18rem;">
                    <div class="card-header">New User</div>
                    <div class="card-body">
                        <form method="POST" action="/ServletAddUser">
                            <div class="form-group">
                                <label for="exampleInputEmail1">Name</label>
                                <input type="text" class="form-control" id="exampleInputEmail1" name="name" aria-describedby="emailHelp" placeholder="Enter name">
                            </div>
                            <div class="form-group">
                                <label for="exampleInputEmail2">LastName</label>
                                <input type="text" class="form-control" id="exampleInputEmail2" name="lastname" aria-describedby="emailHelp" placeholder="Enter lastname">
                            </div>
                            <div class="form-group">
                                <label for="exampleInputEmail3">Age</label>
                                <input type="text" class="form-control" id="exampleInputEmail3" name="age" aria-describedby="emailHelp" placeholder="Enter age">
                            </div>
                            <button type="submit" class="btn btn-info" value="add">Submit</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<button type="button" class="btn btn-info btn-lg btn-block" data-toggle="modal" data-target="#exampleModal">Add User</button>
<br>
<form method="post" action="/ServletCleanAll">
<button type="submit" class="btn btn-danger btn-lg btn-block">Clean All</button>
</form>
</body>
</html>