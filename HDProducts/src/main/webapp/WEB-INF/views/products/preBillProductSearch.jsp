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
   <script type="text/javascript" src="<s:url value="/staticfiles/js/date.js"/>"></script>
   <script type="text/javascript" src="<s:url value="/staticfiles/js/preBillProductSearch.js"/>"></script>
   <script type="text/javascript" src="<s:url value="/staticfiles/js/productSearch.js"/>"></script>
  
</head>
<body  onload="load();">

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
    <%--  <jsp:include page="menu.jsp"/> --%>
  <a href="/HDProducts/dc/dc">Home</a> 
    </td>   
  </tr>
  <tr>
    <td height=270px>    
 <center>
  
 <table border="3">

 <tr><th>Select first property</th><th>Select second property</th><th>Enter first dimention</th><th>Enter second dimention</th><th>Enter No.of pices</th><th>Enter %</th></tr>
    
    <tr>         
    <td><input size=10  type="text"  id="fp" placeholder="Enter first property"> </td>
        <td>  <input size=30 type="text" id="sp" placeholder="Enter second property" ></td>
        <td>  <input size=7 type="text" id="fd" placeholder=" first dimention"/></td>
        <td>  <input size=7 type="text" id="sd" placeholder="second dimention" /></td>
        <td>  <input size=7 type="text" id="nop"  placeholder="No.of pices"/></td>
       <td>   <input size=5 type="text" id="percent"  placeholder="Enter %"/> </td></tr>
       <tr> <td colspan="5"><center><h6 id="err"></h6></center></td><td><button onclick="submitx();">Submit</button>
       </td></tr>
         </table>

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
<table><tr><td>Date:</td><td id=printDate></td></tr>
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
            <tfoot>
   <tr><td colspan="2"><table><tr><td>Bank</td><td>SBI</td></tr><tr><td>A/C No</td><td>62269856102</td></tr><tr><td>IFSC</td><td>SBIN0003562</td></tr></table></td><td><table><tr><td>paid Amount=</td><td id="pmt"></td></tr><tr><td>Due=</td><td id="due"></td></tr></table></td><td colspan="4" valign="bottom">Authorized signature</td><td><table><tr><td>G.Total:</td></tr><tr><td id="gtl"></td></tr></table></td></tr>
   
   </tfoot>
</table>
</div>
pay amount:<input size=5 type="text" placeholder=" Enter amt" id="pamt"><input type="button" value="smt" onclick="amt();">
<br>
<input type="button" value="Print Bill" onclick="printPage('block1');"></input>
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