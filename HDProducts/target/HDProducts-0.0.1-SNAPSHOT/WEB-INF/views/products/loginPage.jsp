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

<table border="1" width="100%" align="center">
  <tr>
    <td height=30px>
   <!--  header -->
   <jsp:include page="header.jsp"/>
   <h2>Login form</h2>
   <tr>
    <c:if test="${param.act eq 'nul'}">
<p class="error">Invalid LoginName and password...</p>
</c:if>
<c:if test="${param.act eq 'lo'}">
<p class="success">Logout successfully</p>
</c:if>
<c:if test="${param.act eq 'reg'}">
<p class="success">Registered successfully please login...</p>
</c:if>
</tr>
    </td>
    
  </tr>
<tr>
    <td height=20px>
    <center>
      <table>
<form:form action="/HDProducts/user/userLogin" method="post" modelAttribute="user" >
       
        <tr>
        <td>LoginName :</td>
        <td><form:input path="LoginName" /></td>
       
         <td>password :</td>
        <td><form:password path="password" /></td>
         <td colspan="2" align="center"><input type="submit" value="Login"/></td>
     </tr>
        </form:form>
        
</table>
</center>
    </td>
    
  </tr>
  <tr>
    <td height=270px>
<center>
 <table>
<form:form action="/HDProducts/user/userLogin" method="post" modelAttribute="user" >
<tr><td><a href="loginRegForm">New User Registration</a></td></tr>
<tr><td></td></tr>
<tr>
     <td><a href="loginPWDChange">Forgot password?</a></td>
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