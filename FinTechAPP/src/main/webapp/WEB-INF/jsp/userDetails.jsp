<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/bootstrap/bootstrap.css">
    <link rel="stylesheet" href="../css/fontawesome/css/all.css">
    <link rel="stylesheet" href="../css/main.css">
    <script src="../js/bootstrap.bundle.js"></script>
    <script src="../js/table2excel.js"></script>
    <title>Dashboard</title>
</head>
<body>

    <!-- Header -->
    <c:import url="components/incl/header.jsp"/>
    
      <!-- Container -->
    <div class="container my-4">

        <!-- Card: User Details Card -->
        <div class="card user-details shadow">
            <!-- Card Header -->
            <div class="card-header">
                <i class="fas fa-credit-card me-2" aria-hidden="true"></i> User Details
            </div>
            <!-- End Of Card Header -->
            
            <!-- Card Body -->
            <div class="card-body">
               
                    <table class="table text-center table-striped" id="example-table">
                    <tr>
                        <th>First Name</th>
                        <th>Last Name</th>
                         <th>Address</th>
                        <th>Contact</th>
                        <th>Age</th>
                    </tr>
                    
                      <tr>
                          <td>${user.first_name}</td>
                         <td>${user.last_name}</td>
                         <td>${user.address}</td>
                       <td>${user.contact}</td>
                        <td>${user.age}</td>
                      </tr>
                    
                    </table>