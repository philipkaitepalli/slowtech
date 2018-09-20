<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="s" %> 
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>billingById</title>
 <s:url  var="uri_jqlib" value="/staticfiles/js/jquery-3.3.1.min.js"/>
<script src="${uri_jqlib}"></script>
 <script type="text/javascript" src="<c:url value="/staticfiles/js/myjs.js"/>"></script>
 <script type="text/javascript" src="<c:url value="/staticfiles/css/mystyle.css"/>"></script>
</head>

<body  >
<div class="topnav">
  <a class="active" href="/HDProducts">Home</a>
  <a href="/HDProducts/plist">ProductsList</a>
  <a href="/HDProducts/productsForm">ProductRegistration</a>
    <a href="/HDProducts/getById">Billing</a>
  <a href="#contact">Contact</a>
  <a href="#about">About</a>
</div>

 <h1></h1> <p id=error></p>
 
       
   
      <input type="text" id="pId" />
       <input type="text" id="fd" />
        <input type="text" id="sd" />
        <input type="text" id="nop" />
         <button onclick='submit();'>Submit</button>
   
<center>

<table id="table" border="1">
<tr>
<th>son</th><th>pId</th><th>pSD</th><th>pName</th><th>pUnitType</th><th>fd</th><th>sd</th><th>nop</th><th>totle</th>
    </tr>
    
    </table>
    
    
    
    
    
    
   <div id=staff></div>

</center>
</body>
</html>