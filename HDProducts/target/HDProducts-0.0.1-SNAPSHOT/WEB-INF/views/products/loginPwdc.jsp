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
    </td>
    
  </tr>
<tr>
    <td height=20px>
   <!--  menu -->
  
   
    </td>
    
  </tr>
  <tr>
    <td height=270px>
   <!--  page content -->
   <table>
   <form:form action="/HDProducts/user/newPWD" method="post" modelAttribute="user" >
       
        <tr>
        <td>Enter New password :</td>
        <td><form:password path="password" /></td>
       </tr>
       <tr>
        <td>conform password :</td>
        <td><form:password path="password" /></td>
       </tr>
        <tr> <td colspan="2" align="center"><input type="submit" value="submit"/></td>
     </tr>
        </form:form>
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