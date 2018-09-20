<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
.error {
	color: #ff0000;
	font-style: italic;
	font-weight: bold;
}
.success{
	color:green ;
	font-style: italic;
	font-weight: bold;
}
</style>
</head>
<body>
<center>
<h2>Login form</h2>
<c:if test="${param.act eq 'nul'}">
<p class="error">Invalid LoginName and password...</p>
</c:if>
<c:if test="${param.act eq 'lo'}">
<p class="success">Logout successfully</p>
</c:if>
<c:if test="${param.act eq 'reg'}">
<p class="success">Registered successfully please login...</p>
</c:if>
<table>
<form:form action="/HDProducts/user/userLogin" method="post" modelAttribute="user" >
       
        <tr>
        <td>LoginName :</td>
        <td><form:input path="LoginName" /></td>
        </tr>
        <tr>
         <td>password :</td>
        <td><form:password path="password" /></td>
         </tr>
         <tr>
       <td colspan="2" align="center"><input type="submit" value="Login"/>
       
       </td>
       </tr>
       <tr><td></td><td><a href="loginRegForm">New User Registration</a></td></tr>
        </form:form>
        
</table>
</center>
</body>
</html>