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
<s:url var="url_css" value="/staticfiles/css/mystyle.css"/>
<link href="${url_css}" rel="stylesheet" type="text/css"/>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery.min.js"></script>
  <script src="//code.jquery.com/jquery-1.12.4.js"></script> 
  <script src="//code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
   <s:url var="urlt_css" value="/staticfiles/css/table.css"/>
   <link href="${urlt_css}" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="<s:url value="/staticfiles/js/printfile.js"/>"></script>
  
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
DynamiVoucher


  ${err}
  <center>
   <div id="block1">
<table id="table" border="3">
<tr><td colspan="2"> 
<table width="100%"><tr><td>
bill_Id:</td><td>${bId}
</td></tr>
<tr><td>cust_Id:</td><td>${cul}/${cal}</td></tr>
<tr><td>F.Name:</td><td>${cufn}</td></tr>
<tr><td>L.Name:</td><td>${culn}</td></tr>
</table>
</td>
<td colspan="5"><table  width="100%"><tr><td><center><h2>SRI LAKSHMI PLY WOOD & GLASSES</h2><h3>Vysya Bazar,CHALLAPALLI-521126</h3>Krishna Dist.,Cell:9397961999<br>Pro.<b><i>K.Gnana Pratap</i></b></center><b>GSTIN:37BRUPK2970H1Z7 </b> State:AP.,Code:37</td></tr></table> </td><td colspan="1">
<table><tr><td>Date:</td><td></td></tr>
</table> </td></tr>
     <tr>  <th >sln</th>
            <th>pSD</th>
            <th>Product_Name</th>
            <th>pUnitType</th>       
            <th>fd</th>
            <th>sd</th>
            <th>nop</th>
            <th>product_total</th>
            </tr>
	
			<c:forEach var="voucher" items="${billList}">
                            <tr>
                      <td>i</td>      
                    <td>${voucher.pStandurdDimension}</td>
                   <td>${voucher.pName}</td>
                   <td>${voucher.pUnitType}</td>
                   <td>${voucher.fd}</td>
                   <td>${voucher.sd}</td>
                   <td>${voucher.nop}</td>
                   <td>${voucher.ptotal}</td>
                 </tr>
            </c:forEach>
            
            <tfoot>
   <tr><td colspan="2"></td><td><table><tr><td>paid Amount=</td><td></td></tr><tr><td>Due=</td><td></td></tr></table></td><td colspan="4" align="right">Grand Total=</td><td> ${gtotal }</td></tr>
  
   </tfoot>
</table>
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