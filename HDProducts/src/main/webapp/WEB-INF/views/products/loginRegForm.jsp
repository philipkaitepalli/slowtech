


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
<style>
.err {
	color: #ff0000;
	font-style: italic;
	font-weight: bold;
}
</style>
</head>

<s:url var="url_img" value="/staticfiles/img/" />
<body background="${url_img}">

<table border="1" width="100%" align="center">
  <tr>
    <td height=30px>
   <!--  header -->
   <jsp:include page="header.jsp"/>
    </td>
    
  </tr>
<tr>
    <td height=20px>
   <!--  menu -->
 <center><h4>Login Registration form</h4></center>
   
    </td>
    
  </tr>
  <tr>
    <td height=270px>
 


<center>


<c:if test="${err!=null}">
<p class="err">${err}</p>
</c:if>
<table>
<form:form action="/HDProducts/user/userRegForm" method="post" modelAttribute="user" commandName="user">
       
        <tr>
        <td>FirstName :</td>
        <td><form:input path="FirstName" />
         <form:errors path="FirstName" cssClass="err" />
        </td>
        </tr>
        <tr>
        <td>LastName :</td>
        <td><form:input path="LastName" />
        <form:errors path="LastName" cssClass="err" />
        </td>
        </tr>
        <tr>
        <td>phoneNumber :</td>
        <td><form:input path="phoneNumber" />
        <form:errors path="phoneNumber" cssClass="err" />
        </td>
        </tr>
        <tr>
        <td>Address :</td>
        <td><form:input path="Address" />
        <form:errors path="Address" cssClass="err" />
        </td>
        </tr>
        <tr>
        <td>email :</td>
        <td><form:input path="email" />
        <form:errors path="email" cssClass="err" />
        </td>
        </tr>
         <tr>
        <td>LoginName :</td>
        <td><form:input path="LoginName" />
        <form:errors path="LoginName" cssClass="err" />
        </td>
        </tr>
        <tr>
         <td>password :</td>
        <td><form:password path="password" />
        <form:errors path="password" cssClass="err" />
        </td>
        
        </tr>
        <tr>
       <td colspan="2" align="center"><input type="submit" value="Login"/>      
       </td>
       </tr>
  </form:form>
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