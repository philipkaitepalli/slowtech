<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %> 
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>bill</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

</head>

<s:url var="url_img" value="/staticfiles/img/" />
<body background="${url_img}">

<table border="1" width="98%" align="center">
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
<h1>Day wise bills</h1>
<center>
 <table border="2">
 <tr>
 
 <th>date</th>
 <th>billId</th>
 <th>customerId</th>
 <th>carpId</th>
 <th>billTotal</th>
 <th>paidAmount</th>
 </tr>
<c:forEach var="dwb" items="${li}">
   <tr>
      
       <td> ${dwb.date}</td>
       <td> ${dwb.billId}</td>
       <td> ${dwb.customerId}</td>
       <td> ${dwb.carpId}</td>
       <td> ${dwb.billTotal}</td>
       <td> ${dwb.paidAmount}</td>
 </tr>

</c:forEach>
</table>
</center>
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