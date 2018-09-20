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
.error {
	color: #ff0000;
	font-size:15px;
	font-style: italic;
	
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
   <!--  page content -->

    <div align="center">
     <font size="5" color="#6f2506">Products Registration form</font><br>
           <font size="2" color="#620f51">New/Edit Products</font>
 
 <form:form action="saveProducts" method="post" modelAttribute="products" commandName="products" >
        
        <table>
       <tr><form:hidden path="pId" /></tr>
            <tr>
                <td>pCode:</td>
                <td><form:input path="pCode" />
                   </td><td> <form:errors path="pCode" cssClass="error" />
                
                </td>
            </tr>
             <tr>
                <td>pStandurdDimension:</td>
                <td><form:input path="pStandurdDimension" />
                    </td><td><form:errors path="pStandurdDimension" cssClass="error" />
                </td>
            </tr>
            <tr>
                <td>pName:</td>
                <td><form:input path="pName" />
               </td><td> <form:errors path="pName" cssClass="error" /></td>
            </tr>
            <tr>
                <td>pCompany Name:</td>
                <td><form:input path="pCompanyName" />
                    </td><td><form:errors path="pCompanyName" cssClass="error" />
                </td>
            </tr>
         <tr>
                <td bgcolor='green'>Product PriceList Unit Type:</td>
                <td bgcolor='green'><form:input path="pUnitType" />
                    </td><td><form:errors path="pUnitType" cssClass="error" />
                </td>
            </tr>
            <tr>
                <td bgcolor='green'>Product PriceList Unit Price:</td>
                <td bgcolor='green'><form:input path="pUnitPrice" />
                    </td><td><form:errors path="pUnitPrice" cssClass="error" />
                </td>
            </tr>
            <tr>
                <td bgcolor='red'>Product Sales Unit Type:</td>
                <td bgcolor='red'><form:input path="pSaleUnitType" />
                    </td><td><form:errors path="pSaleUnitType" cssClass="error" />
                </td>
            </tr>
            <tr>
                <td bgcolor='red'>Product Sales Unit Price:</td>
                <td bgcolor='red'><form:input path="psaleUnitPrice" />
                    </td><td><form:errors path="psaleUnitPrice" cssClass="error" />
                </td>
            </tr>
                        
                
            <tr>
                <td>pStackUnit:</td>
                <td><form:input path="pStackUnit" />
                   </td><td> <form:errors path="pStackUnit" cssClass="error" />
                </td>
            </tr>
            <tr>
                <td>pStackQuantity:</td>
                <td><form:input path="pStackQuantity" />
                   </td><td> <form:errors path="pStackQuantity" cssClass="error" />
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