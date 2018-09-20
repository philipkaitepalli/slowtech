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
 <div align="center">
    <h3>Carpenter Registration form</h3>
        <h1>New/Edit Carpenter</h1>
        
 <form:form action="saveCarpenter" method="post" modelAttribute="carpenter" commandName="carpenter">
        
        <table>
         <form:hidden path="carpId" />
            <tr>
                <td>Carpenter PhoneNo:</td>
                <td><form:input path="carpPhoneNo" /></td><td>
                    <form:errors path="carpPhoneNo" cssClass="error" />
                
                </td>
            </tr>
            <tr>
                <td>Carpenter FirstName:</td>
                <td><form:input path="carpFirstName" /></td><td>
                <form:errors path="carpFirstName" cssClass="error" /></td>
            </tr>
            <tr>
                <td>Carpenter LastName:</td>
                <td><form:input path="carpLastName" /></td><td>
                    <form:errors path="carpLastName" cssClass="error" />
                </td>
            </tr>
            
            <tr>
                <td>Carpenter Address:</td>
                <td><form:input path="carpAddress" /></td><td>
                    <form:errors path="carpAddress" cssClass="error" />
                </td>
            </tr>
            
            
            <tr>
           
                <td colspan="2" align="center"><input type="submit" value="Save"/></td>
            </tr>
        </table>
        </form:form>
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