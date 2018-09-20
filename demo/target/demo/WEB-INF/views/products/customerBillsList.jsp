<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %> 
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>preBillPicker</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
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
<script>
function printPage(id)
{
   var html="<html>";
   html+= document.getElementById(id).innerHTML;

   html+="</html>";

   var printWin = window.open('','','left=0,top=0,width=500,height=800,toolbar=0,scrollbars=0,status  =0');
   printWin.document.write(html);
   printWin.document.close();
   printWin.focus();
   printWin.print();
   printWin.close();
}
</script>
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
</c:if>
 <form action="/HDProducts/billsList/custBills">
<table>
 
 <tr><td>Customer first name:</td><td><input size=18 type="text" name="cfn" id="cfn" ></td><td>Customer last name</td><td><input size=18 type="text" name="cln" id="cln" ></td><td><input type="submit" value="submmit"/></td></tr> 
  </table></form> 
  
  <div id='block1'>
  <table border="1"> <tr><td colspan="2"><table>
<tr><td>cust_Id:</td><td>${cust.customerId}</td></tr>
<tr><td>F.Name:</td><td>${cust.custFirstName}</td></tr>
<tr><td>L.Name:</td><td>${cust.custLastName}</td></tr>
</table>
</td>
<td colspan="7"><table  width="100%"><tr><td><center><h1>Prathap shop</h1><h3> Challapalli krishna 521131</h3>phone:9876987634,3636366363</center></td></tr></table> </td></tr>
  
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
            <input type="button" value="Print Bill" onclick="printPage('block1');"></input>
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