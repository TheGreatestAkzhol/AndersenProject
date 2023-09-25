<%--
  Created by IntelliJ IDEA.
  User: Akobek
  Date: 9/25/2023
  Time: 8:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
  <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</head>
<body>
<div class="container">
  <div class="row justify-content-around" style="height: 100px"></div>
  <div class="row justify-content-around">
    <div class="col-4"></div>
    <div class="col-4">
      <div class="card text-white bg-dark mb-3" style="max-width: 18rem;">
        <div class="card-header">Edit User</div>
          <div class="card-body">

            <form method="POST" action="/andersen_project/ServletUpdateUser?id=${user.getId()}">
              <div class="form-group">
                <label for="exampleInputEmail1">Name</label>
                <input type="text" class="form-control" id="exampleInputEmail1" name="name" value="${user.getName()}" aria-describedby="emailHelp" placeholder="Enter name">
              </div>
              <div class="form-group">
                <label for="exampleInputEmail2">LastName</label>
                <input type="text" class="form-control" id="exampleInputEmail2" name="lastname" value="${user.getLastName()}" aria-describedby="emailHelp" placeholder="Enter lastname">
              </div>
              <div class="form-group">
                <label for="exampleInputEmail3">Age</label>
                <input type="text" class="form-control" id="exampleInputEmail3" name="age"  value="${user.getAge()}" aria-describedby="emailHelp" placeholder="Enter age">
              </div>
              <button type="submit" class="btn btn-info" value="add">Submit</button>
            </form>

          </div>
        </div>
    </div>
    <div class="col-4"></div>
  </div>
  <div class="row justify-content-around"></div>
</div>
</body>
</html>
