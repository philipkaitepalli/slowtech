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
<style>
.error {
	color: #ff0000;
	font-size:10px;
	font-style: italic;
	font-weight: bold;
}
</style>
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
    <h3>Customer Registration form</h3>
        <h1>New/Edit Customer</h1>
        
 <form:form action="saveCustomer" method="post" modelAttribute="customer" commandName="customer">
        
        <table>
   <tr>  <td><form:hidden path="customerId" /></td></tr>
            <tr>
                <td>Carpenter Id:</td>
                <td><form:input path="carpId" /></td><td>
                    <form:errors path="carpId" cssClass="error" />
                
                </td>
            </tr>
            <tr>
                <td>Customer custPhoneNo:</td>
                <td><form:input path="custPhoneNo" /></td><td>
                <form:errors path="custPhoneNo" cssClass="error" /></td>
            </tr>
            <tr>
                <td>Customer FirstName:</td>
                <td><form:input path="custFirstName" /></td><td>
                    <form:errors path="custFirstName" cssClass="error" />
                </td>
            </tr>
            
            <tr>
                <td>Customer LastName:</td>
                <td><form:input path="custLastName" /></td><td>
                    <form:errors path="custLastName" cssClass="error" />
                </td>
            </tr>
            
            <tr>
                <td>Customer Address:</td>
                <td><form:input path="custAddress" /></td><td>
                    <form:errors path="custAddress" cssClass="error" />
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