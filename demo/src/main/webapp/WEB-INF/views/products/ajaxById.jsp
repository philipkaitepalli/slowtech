<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="s" %> 
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head lang="en">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>billingById</title>

<s:url  var="uri_jqlib" value="/staticfiles/js/jquery-3.3.1.min.js"/> 
<script src="${uri_jqlib}"></script>
 <script type="text/javascript" src="<s:url value="/staticfiles/js/myjs.js"/>"></script>
 
</head>
<div >
  <a class="active" href="/HDProducts/dc/dc">Home</a>
  <a href="/HDProducts/dc/plist">ProductsList</a>
  <a href="/HDProducts/dc/productsForm">ProductRegistration</a>
    <a href="/HDProducts/dc/dcb">Billing</a>
  <a href="#contact">Contact</a>
  <a href="#about">About</a>
</div>



<body>
<h2>${error}</h2>
  
<div>
         <input type="text" id="pId" placeholder="Enter Product Id"/>
         <input type="text" id="fd" placeholder="Enter first dimention"/>
         <input type="text" id="sd" placeholder="Enter second dimention" />
         <input type="text" id="nop"  placeholder="Enter No.of pices"/>
         <button onclick="submit();">Submit</button>
   </div>     
   <br>  
   <center>       
<div id="block1">


<table id="table" border="1">
<tr><td colspan="9"><center><p>Prathap shop Challapalli krishna 521131 phone:9876987634,3636366363</p></center> </td></tr>
<tr><td colspan="4"> date:23/3/18<br>billNo:3232<br>customerId:2323</td><td colspan="5">phno:<br>village:gfhfdghfhfdghgfd </td>
</tr>
<tr>        <th>son</th>
            <th>pId</th> 
            
            <th>pSD</th>
            <th>pName</th>
            <th>pUnitType</th>
           
            <th>fd</th>
            <th>sd</th>
            <th>nop</th>
            
            <th>total</th>
                        </tr>
      

   <tfoot>
   <tr><td colspan="8">Grand Total</td><td><p id="gt"></p></td></tr>
   
   </tfoot>
</table>
<input type="text" onKeyUp='doSearch();'>

</div>
<br>
<input type="button" value="Print Block 2" onclick="printPage('block1');"></input>
</center>
</body>
</html>