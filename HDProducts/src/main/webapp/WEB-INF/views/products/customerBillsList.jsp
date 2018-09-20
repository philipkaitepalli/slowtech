<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %> 
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>slowT</title>


<s:url var="url_css" value="/staticfiles/css/mystyle.css"/>
<link href="${url_css}" rel="stylesheet" type="text/css"/>
<s:url var="url_bs" value="/staticfiles/bootstrap-3.3.6-dist/css"/>
<link href="${url_bs}" rel="stylesheet" type="text/css"/>

             <!--  page related links -->
 <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery.min.js"></script>
 <script src="//code.jquery.com/jquery-1.12.4.js"></script>
  <script src="//code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script type="text/javascript" src="<s:url value="/staticfiles/js/preBillPicker.js"/>"></script>
  <script type="text/javascript" src="<s:url value="/staticfiles/js/printfile.js"/>"></script> 

</head>

<%-- <s:url var="url_img" value="/staticfiles/img/---.jpg" />
<body background="${url_img}"> --%>
<body>

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
   <c:if test="${sessionScope.userId!=null && sessionScope.userRoll==1}">
  <form action="/HDProducts/billsList/deltVoucher" >
   <input  type="submit" value="Delete"/>
     </form>
</c:if><center><p>${err}</p></center>

<c:if test="${x==0}">
  <form action="/HDProducts/billsList/nodeltVoucher" >
   <input  type="submit" value="no"/>
     </form>
</c:if>

 <form action="/HDProducts/billsList/custBills">
<table>
 
 <tr><td>Customer first name:</td><td><input size=18 type="text" name="cfn" id="cfn" ></td><td>Customer last name</td><td><input size=18 type="text" name="cln" id="cln" ></td><td><input type="submit" value="submmit"/></td></tr> 
  </table></form> 
  <center>
  <div id='block1'>
  <table border="1"> <tr><td colspan="2"><table>
<tr><td>cust_Id:</td><td>${cust.customerId}</td></tr>
<tr><td>F.Name:</td><td>${cust.custFirstName}</td></tr>
<tr><td>L.Name:</td><td>${cust.custLastName}</td></tr>
</table>
</td>
<td colspan="7"><table  width="100%"><tr><td><center><h2>SRI LAKSHMI PLY WOOD & GLASSES</h2><h3>Vysya Bazar,CHALLAPALLI-521126</h3>Krishna Dist.,Cell:9397961999<br>Pro.<b><i>K.Gnana Pratap</i></b></center><b>GSTIN:37BRUPK2970H1Z7 </b> State:AP.,Code:37</td></tr></table>  </td></tr>
  
  <tr><td>BillId</td><td>BilledDate</td><td>Psd</td><td>Product Name</td><td>Units</td><td>fd</td><td>sd</td><td>nop</td><td>pTotal</td></tr>
  <c:forEach var="prod" items="${v}" >
  
                   <tr>
                    
                      <td>${prod.billId}</td>
                      <td>${prod.billDate}</td>
                      <td>${prod.pStandurdDimension}</td>
                      <td>${prod.pName}</td>
                      <td>${prod.pUnitType}</td>
                      <td>${prod.fd}</td>
                      <td>${prod.sd}</td>
                      <td>${prod.nop}</td>
                      <td>${prod.ptotal}</td>
                  
                    </tr>
                    
            </c:forEach>
            <tr><td  align="right">paid amount=</td><td>${amount}</td><td align="right">Due=</td><td>${due}</td><td colspan='4' align="right">Grand Total=</td><td>${t}</td></tr>
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