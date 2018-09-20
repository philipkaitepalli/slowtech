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

  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script type="text/javascript" src="<s:url value="/staticfiles/js/dayWiseBill.js"/>"></script>
  <script type="text/javascript" src="<s:url value="/staticfiles/js/printfile.js"/>"></script>
  <script type="text/javascript" src="<s:url value="/staticfiles/js/date.js"/>"></script>
   
</head>

<s:url var="url_img" value="/staticfiles/img/" />
<body  onload="loadDate();">

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
<center>
<font size="5" color="#6f2506">Date wise bills List</font><br>
 <p>${err}</p>

 Date: <input type="text" id="datepicker"  onchange="dateBillfind()">

      
     <div id="block1">
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
       <td> <a href="dynaBills?pId=${dwb.billId}">${dwb.billId}</a></td>
       <td> ${dwb.customerId}</td>
       <td> ${dwb.carpId}</td>
       <td> ${dwb.billTotal}</td>
       <td> ${dwb.paidAmount}</td>
 </tr>

</c:forEach>
</table>
</div>
<input type="button" value="Print..." onclick="printPage('block1');"></input>
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