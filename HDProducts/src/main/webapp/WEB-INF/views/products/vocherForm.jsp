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
  <jsp:include page="menu.jsp"/>
   
    </td>
    
  </tr>
  <tr>
    <td height=270px>
   <!--  page content -->



 <div align="center">
    
        <h1>Edit Voucher</h1>
      
        <!--  modelAttribute="voucher" commandName="voucher" -->
        
 <form:form action="saveVoucher" method="post" modelAttribute="voucher" commandName="voucher">
        
       <table>
       
       <tr>
                <td>pbId:</td>
                <td><form:input path="pbId" />
               </td><td> <form:errors path="pbId" cssClass="error" /></td>
            </tr>
            <tr>
                <td>billId:</td>
                <td><form:input path="billId" />
               </td><td> <form:errors path="billId" cssClass="error" /></td>
            </tr>
           <tr>
                <td>custId:</td>
                <td><form:input path="custId" />
               </td><td> <form:errors path="custId" cssClass="error" /></td>
            </tr>
            <tr>
                <td>carpId:</td>
                <td><form:input path="carpId" />
               </td><td> <form:errors path="carpId" cssClass="error" /></td>
            </tr>
            
            <tr>
                <td>billDate:</td>
             <td><form:input path="billDate" />
               </td><td> <form:errors path="billDate" cssClass="error" /></td> 
            </tr>
            
            <tr>
                <td>pUnitPrice:</td>
                <td><form:input path="pUnitPrice" />
               </td><td> <form:errors path="pUnitPrice" cssClass="error" /></td>
            </tr>
            <tr>
                <td>pName:</td>
                <td><form:input path="pName" />
               </td><td> <form:errors path="pName" cssClass="error" /></td>
            </tr>
            
            
            <tr>
                <td>pStandurdDimension:</td>
                <td><form:input path="pStandurdDimension" />
                    </td><td><form:errors path="pStandurdDimension" cssClass="error" />
                </td>
            </tr>
            
            <tr>
                <td>pUnitType:</td>
                <td><form:input path="pUnitType" />
                    </td><td><form:errors path="pUnitType" cssClass="error" />
                </td>
            </tr>
            <tr>
                <td>fd:</td>
                <td><form:input path="fd" />
                    </td><td><form:errors path="fd" cssClass="error" />
                </td>
            </tr>
            <tr>
                <td>sd:</td>
                <td><form:input path="sd" />
                    </td><td><form:errors path="sd" cssClass="error" />
                </td>
            </tr>
            <tr>
                <td>nop:</td>
                <td><form:input path="nop" />
                   </td><td> <form:errors path="nop" cssClass="error" />
                </td>
            </tr>
            <tr>
                <td>ptotal:</td>
                <td><form:input path="ptotal" />
                   </td><td> <form:errors path="ptotal" cssClass="error" />
                </td>
            </tr>
            <tr>
           
                <td colspan="2" align="center"><input type="submit" value="Edit"/></td>
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