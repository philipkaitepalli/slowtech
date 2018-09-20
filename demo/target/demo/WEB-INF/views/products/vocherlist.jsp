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
<h1>vocher list</h1>

<table border="1">
<tr><td>pbId</td>
        <th>billId</th>
        <th>custId</th>
        <th>carpId</th>
      
       <th>billDate</th>
      
       <th>pName</th>
       <th>pStandurd
       Dimension</th>
       <th>pUnitType</th>
       <th>pUnitPrice</th>
       <th>fd</th>
       <th>sd</th>
       <th>nop</th>
       <th>ptotal</th>
       <th>Delete</th>
       
       
 </tr>
 <c:forEach var="pdt" items="${li}">
 <tr><td>${pdt.pbId}</td>
       <td>${pdt.billId}</td>
       <td>${pdt.custId}</td>
        <td>${pdt.carpId}</td>
       <td>${pdt.billDate}</td>   
       <td>${pdt.pName}</td>
       <td>${pdt.pStandurdDimension}</td>
       <td>${pdt.pUnitType}</td>
       <td>${pdt.pUnitPrice}</td>
       <td>${pdt.fd}</td>
       <td>${pdt.sd}</td>
       <td>${pdt.nop}</td>
       <td>${pdt.ptotal}</td>
       <td>Delete</td>
       
       
 </tr>
 </c:forEach>
 </table>
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