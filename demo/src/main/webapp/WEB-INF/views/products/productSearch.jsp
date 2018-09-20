<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="s" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
  <title>Autocomplete </title>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery.min.js"></script>
  <script src="//code.jquery.com/jquery-1.12.4.js"></script> 
  <script src="//code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script type="text/javascript" src="<s:url value="/staticfiles/js/productSearch.js"/>"></script>
  <script type="text/javascript" src="<s:url value="/staticfiles/js/psAjax.js"/>"></script>
  <script type="text/javascript" src="<s:url value="/staticfiles/js/printfile.js"/>"></script>
</head>



<body>


<center>  
        <input size=18  type="text"  id="fp" placeholder="Enter first property"> 
         <input size=18 type="text" id="sp" placeholder="Enter second property" ><br>
         <input size=11 type="text" id="fd" placeholder=" first dimention"/>
         <input size=11 type="text" id="sd" placeholder="second dimention" />
         <input size=11 type="text" id="nop"  placeholder="No.of pices"/><br>
         <input size=5 type="text" id="percent"  placeholder="Enter %"/> 
         
         <button onclick="submit();">Submit</button>
  
 <div id="block1">
<table id="table" border="1">
<tr><td colspan="2"> 
date:<input type="text" id=date size=8/><br>
bill_Id:<br>
customer_Id:
customerName:</td>
<td colspan="5"><h1>Prathap shop</h1><h3>Challapalli krishna 521131</h3>phone:9876987634,3636366363 </td><td colspan="2">phno:
                                       <br>village:gfhfdghfhfdghgfd </td></tr>
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
   <tr><td colspan="2"></td><td colspan="6">Grand Total</td><td><p id="gtotal"></p></td></tr>
   <tr><td colspan="1">Discount</td>
       <td>....</td>
       <td colspan="3">paid Amount</td>
       <td>........</td>
       <td colspan="2">Due</td>
       <td><input type="text" id="Due"></td>
       </tr>
   </tfoot>
</table>
</div>

<br>
<input type="button" value="Print Block 2" onclick="printPage('block1');"></input>
</center>
</body>
</html>