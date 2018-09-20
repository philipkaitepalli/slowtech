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
<s:url var="url_css" value="/staticfiles/css/mystyle.css"/>
<link href="${url_css}" rel="stylesheet" type="text/css"/>
<s:url var="url_bs" value="/staticfiles/bootstrap-3.3.6-dist/css"/>
<link href="${url_bs}" rel="stylesheet" type="text/css"/>

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
<div> 
<h4>Carpenter List</h4> 
        <h6>
            <a href="carpenterForm">New Carpenter</a>
        </h6>
     </div>  
      
    <div align="center"  >
   
        <table border="1">
            <th>carpId</th>
            <th>carpPhoneNo</th>
            <th>carpFirstName</th>
            <th>carpLastName</th>
            <th>carpAddress</th>
           
            <th colspan="2">Action</th>
 
 
            <c:forEach var="carpenter" items="${listcarpenter}">
            
                <tr>
                    <td>${carpenter.carpId}</td>
                    <td>${carpenter.carpPhoneNo}</td>
                    <td>${carpenter.carpFirstName}</td>
                    <td>${carpenter.carpLastName}</td>
                    <td>${carpenter.carpAddress}</td>
                    
                    <td><a href="editCarpenter?carpId=${carpenter.carpId}"> Edit... </a></td>
                    
                       <td> <a href="deleteCarpenter?carpId=${carpenter.carpId}"> Delete</a></td>
 
                </tr>
            </c:forEach>
         
        </table>
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