<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<head> 
<s:url var="url_css" value="/staticfiles/css/productsMenus.css"/>
<link href="${url_css}" rel="stylesheet" type="text/css"/>
</head>
<body> 
<s:url var="url_logout" value="/user/logout"/>


<c:if test="${sessionScope.userId==null }">
<center><font size="2" color="red">User is not yet logged in :Guest menu...</font></center>
<ul>
  <li>
      <a href="/HDProducts/dc/dc">Home</a> 
  </li>
  <li> 
      <a href="#">Contacts</a> 
   </li>  
    <li>
       <a href="/HDProducts/dc/dc">Registrations   </a> 
      <ul>
      <li><a href="#">Carpenters</a></li>
      <li><a href="#">Custoers</a></li>
      <li><a href="#">Products</a></li>
      <li><a href="#">Registrations</a></li>
     </ul>
    </li>  
   <li>  <a href="/HDProducts/dc/dc">Lists</a> 
   <ul>
      <li><a href="#">Carpenters </a></li>
      <li><a href="#">Custoers </a></li>
      <li><a href="#">Products </a></li>
      <li><a href="#">Lists</a></li>
  </ul>
    </li> 
   <li>  <a href="/HDProducts/dc/dc">Billings</a> 
   <ul>
      <li><a href="#">Billings</a></li>
      <li><a href="#">CustomerBilling</a></li>
      <li><a href="#">ID</a></li>
      
      
     
  </ul>
    </li> 
   
  <li>  
      <a href="${url_logout}">Logout</a> 
   </li> 
    
  </ul>
  
</c:if>
<c:if test="${sessionScope.userId!=null && sessionScope.userRoll==1}">
   <center>  <font size="2" color="green">Admin menu...!</font></center>
<ul>
  <li>
      <a href="/HDProducts/dc/dc">Home</a> 
  </li>
  <li> 
      <a href="#">Contacts</a> 
   </li>  
    <li>
       <a href="/HDProducts/dc/dc">Registrations   </a> 
      <ul>
      <li><a href="/HDProducts/carpenter/carpenterForm">Carpenters</a></li>
      <li><a href="/HDProducts/customer/customerForm">Customers</a></li>
      <li><a href="/HDProducts/dc/productsForm">Products</a></li>
      <li><a href="#">Registrations</a></li>
     </ul>
    </li>  
   <li>  <a href="/HDProducts/dc/dc">Lists</a> 
   <ul>
       <li><a href="/HDProducts/carpenter/carpenterList">Carpenters </a></li>
       <li><a href="/HDProducts/customer/customerList">Customers </a></li>
       <li><a href="/HDProducts/dc/plist">Products </a></li>
       <li><a href="/HDProducts/pbpc/vocherlist">Voucher</a></li>
       <li><a href="/HDProducts/pbpc/dwbl">DateWiseBills</a></li>
       <li><a href="/HDProducts/user/loginRegList">LoginRegList</a></li>
       </ul>
    </li> 
   <li>  <a href="/HDProducts/dc/dc">Billings</a> 
   <ul>
      <li><a href="/HDProducts/pbpc/preBillPicker">Billings</a></li>
      <li><a href="/HDProducts/billsList/samp">CustomerBilling</a></li>
      <li><a href="/HDProducts/dc/dc">ID</a></li>
     
   </ul>
   </li> 
   
  <li>  
      <a href="${url_logout}">Logout</a> 
   </li> 
      </ul>
</c:if>

<c:if test="${sessionScope.userId!=null && sessionScope.userRoll==2}">
<center><font size="2" color="yellow">User menu...!</font></center>
<ul>
  <li>
      <a href="/HDProducts/dc/dc">Home</a> 
  </li>
  <li> 
      <a href="#">Contacts</a> 
   </li>  
    <li>
       <a href="/HDProducts/dc/dc">Registrations   </a> 
      <ul>
      <li><a href="#">Carpenters</a></li>
      <li><a href="#">Custoers</a></li>
      <li><a href="#">Products</a></li>
      <li><a href="#">Registrations</a></li>
     </ul>
    </li>  
   <li>  <a href="/HDProducts/dc/dc">Lists</a> 
   <ul>
      <li><a href="#">Carpenters </a></li>
      <li><a href="#">Custoers </a></li>
      <li><a href="#">Products </a></li>
      <li><a href="#">Lists</a></li>
  </ul>
    </li> 
   <li>  <a href="/HDProducts/dc/dc">Billings</a> 
   <ul>
       <li><a href="/HDProducts/pbpc/preBillPicker">Billings</a></li>
       <li><a href="/HDProducts/billsList/samp">CustomerBilling</a></li>
       <li><a href="/HDProducts/dc/dc">ID</a></li>
  </ul>
    </li> 
   
  <li>  
      <a href="${url_logout}">Logout</a> 
   </li> 
    
  </ul>
</c:if>

 
  </body>