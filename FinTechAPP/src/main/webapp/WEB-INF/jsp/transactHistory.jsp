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
    
    <title>Dashboard</title>
    
    
</head>
<body>

    <!-- Header -->
    <c:import url="components/incl/header.jsp"/>


<!-- Transaction History Export -->

<div class="container">

 <a href="/app/transact_history/export"><i class=btn-primary >Export/i></a>

</div>

    <!-- Container -->
    <div class="container my-8">
    
    

        <!-- Card: Transaction History Card -->
        <div class="card transaction-history shadow">
            <!-- Card Header -->
            <div class="card-header">
                <i class="fas fa-credit-card me-2" aria-hidden="true"></i> Transaction History
            </div>
            
           
            
            
            <!-- End Of Card Header -->

            <!-- Card Body -->
            <div class="card-body">
                <c:if test="${requestScope.transact_history != null}">
                    <table class="table table-striped" id="example-table" >
                    
                    <tr style = "text-align:center">
                        <th scope="col">Transaction ID</th>
                        <th scope="col">Transaction Type</th>
                        <th scope="col">Amount </th>
                       <th scope="col">Previous Balance </th> 
                       <th scope="col">Closing Balance </th>
                        <th scope="col">Source </th>
 						  <th scope="col">Reason Code</th>
                      <th scope="col">Created at</th>
                        
                    <c:forEach items="${requestScope.transact_history}" var="transactionHistory">
                    </tr>
                    <tr style = "text-align:center">
                    <td><c:out value="${transactionHistory.transaction_id}"/></td>
                    <td><c:out value="${transactionHistory.transaction_type}"/></td>
                    <td><c:out value="${transactionHistory.amount}"/></td>
                    <td><c:out value="${transactionHistory.previous_balance}"/></td>
                    <td><c:out value="${transactionHistory.closing_balance}"/></td>
                    <td><c:out value="${transactsionHistory.source}"/></td>
                   <td><c:out value="${transactionHistory.reason_code}"/></td>
                   <td><c:out value="${transactionHistory.created_at}"/></td>
                    </tr>
                    </c:forEach>
                    </table>
                    
                </c:if>
            </div>
            <!-- End Of Card Body -->
        </div>
        <!-- End Of Card: Transaction History Card -->
    </div>
    <!-- End Of Container -->



  <!-- Footer -->
   <c:import url="components/incl/footer.jsp"/>

