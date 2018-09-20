<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %> 
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page import="java.sql.ResultSet"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>bill</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<s:url var="url_css" value="/staticfiles/css/table.css"/>
<s:url var="url_css" value="/staticfiles/css/mystyle.css"/>
<link href="${url_css}" rel="stylesheet" type="text/css"/>
<s:url var="url_bs" value="/staticfiles/bootstrap-3.3.6-dist/css"/>
<link href="${url_bs}" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="<s:url value="/staticfiles/js/printfile.js"/>"></script>
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
      <!--  page content-->
<font size="5" color="#6f2506">Products List</font><br>

        <h3>
            <a href="productsForm">New Products</a>
        </h3>
        ${err}
      <form:form action="free_search" >
     Enter text for search:<input type="text" name="freeText"  placeholder="Enter Text for search"/>
     <button>find</button>
     </form:form> 
     <center>
   <div id="block1">
        <table border="1">
        <tr>
            <th>pId</th>
            <th>pCode</th>
            <th>*pSD</th>
            <th>pName</th>
            <th>Company</th>
            <th bgcolor='green'>*pUType</th>
            <th bgcolor='green'>*pUPrice </th>
            <th bgcolor='red'>*pSUType</th>
            <th bgcolor='red'>*pSUPrice </th>
            <th>pStackUnit</th>
            <th>*pSQ</th>
            <th colspan="2">Action</th></tr>
             <c:forEach var="products" items="${listproducts}">
        <tr>
                    <td>${products.pId}</td> 
                    <td>${products.pCode}</td>
                    <td>${products.pStandurdDimension}</td>
                    <td>${products.pName}</td>
                    <td>${products.pCompanyName}</td>
                     <td bgcolor='green'>
                    ${products.pUnitType}</td>
                    <td bgcolor='green'>
                    ${products.pUnitPrice}</td>
                    <td  bgcolor='red'>
                    ${products.pSaleUnitType}</td>
                    <td  bgcolor='red'>
                    ${products.psaleUnitPrice}</td>
                    <td>${products.pStackUnit}</td>
                    <td>${products.pStackQuantity}</td>
                    <td><a href="editProducts?pId=${products.pId}"> Edit... </a></td>
                     <td> <a href="deleteProducts?pId=${products.pId}"> Delete</a></td>
                 </tr>
            </c:forEach>
          </table>
          <p><i> *pSD= ProductsStandurdDimension;<br>  *pSQ= ProductsStackQuantity <br>
    *pSUType= ProductsSalesUnitType; <br> *pSUPrice= ProductsSalesUnitPrice <br>
  *pUType=pPrceListUnitType<br>     *pUPrice=pPrceListUnitPrice </i> </p>
    </div>
           <input type="button" value="Print..." onclick="printPage('block1');"></input>
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