<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<head>
<s:url var="url_css" value="/staticfiles/css/mystyle.css"/>
<link href="${url_css}" rel="stylesheet" type="text/css"/>
</head>

<div>
<ul>
<li>
  | <a href="#">Home</a> 
  </li>
  <li>
  | <a href="/HDProducts/dc/productsForm">Registrations</a> 
  <ul>
     <li>
     <a href="#">Home</a> 
     </li>
     <li>
     <a href="#">Home</a> 
     </li>
     <li>
     <a href="#">Home</a> 
     </li>
  </ul>
  </li>
  <li>
  | <a href="/HDProducts/dc/plist">Lists</a> 
  </li>
  <li>
  | <a href="/HDProducts/dc/dcb">Billings</a> 
  </li>
  <li>
  | <a href="#">Contacts</a>
  </li>
  <li>
  | <a href="#">About</a> 
 </li>
 </ul>
 
 </div>