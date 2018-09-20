<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %> 
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>slowT</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<s:url var="url_css" value="/staticfiles/css/mystyle.css"/>
<link href="${url_css}" rel="stylesheet" type="text/css"/>
<s:url var="url_bs" value="/staticfiles/bootstrap-3.3.6-dist/css"/>
<link href="${url_bs}" rel="stylesheet" type="text/css"/>

<script type="text/javascript" src="<s:url value="/staticfiles/js/printfile.js"/>"></script>
</head>

<s:url var="url_img" value="/staticfiles/img/---.jpg" />
<body background="${url_img}">

<table border="1">
  <tr>
    <td height=30px>
   <!--  header -->
   <jsp:include page="header.jsp"/>
    </td>
    
  </tr>
<tr>
    <td height=20px>
   <!--  menu -->
  <jsp:include page="menu.jsp"/>
   
    </td>
    
  </tr>
  <tr>
    <td height=270px>
<div align="center"> 
 <font size="5" color="#6f2506">Customer List</font><br>

        <h3>
            <a href="customerForm">New Customer</a>
        </h3>
     </div>  
      
    <div align="center"  >
   <div id="block1">
        <table border="1">
            <th>customerId</th>
            <th>carpId</th>
            <th>custPhoneNo</th>
            <th>custFirstName</th>
            <th>custLastName</th>
            <th>custAddress</th>
           
            <th colspan="2">Action</th>
 
 
            <c:forEach var="customer" items="${listcustomer}">
            
                <tr>
                   <td>${customer.customerId}</td>
                    <td>${customer.carpId}</td>
                    <td>${customer.custPhoneNo}</td>
                    <td>${customer.custFirstName}</td>
                    <td>${customer.custLastName}</td>
                    <td>${customer.custAddress}</td>
                    
                    <td><a href="editCustomer?customerId=${customer.customerId}"> Edit... </a></td>
                    
                       <td> <a href="deleteCustomer?customerId=${customer.customerId}"> Delete</a></td>
 
                </tr>
            </c:forEach>
         
        </table>
        </div>
        <input type="button" value="Print..."onclick="printPage('block1');"></input>
        </div> 
</td>
  </tr>
  <tr>
    <td height=15px>
   <!--  footer-->
   <jsp:include page="footer.jsp"/>
    </td>
      </tr>
</table>

</body>
</html>