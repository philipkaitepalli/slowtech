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
  <%-- <script type="text/javascript" src="<s:url value="/staticfiles/js/IdPicker.js"/>"></script> --%>

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
 ${err}
<center>
 <form action="/HDProducts/pbpc/getIds">
<table>
 <tr><td>
 Customer first name:</td><td><input size=18 type="text" name="cfn" id="cfn" ></td></tr> 
 <tr><td>Customer last name</td><td><input size=18 type="text" name="cln" id="cln" ></td></tr>

 <tr><td>Carpenter first name</td><td><input size=18 type="text" name="cafn" id="cafn"></td></tr>
 <tr><td>Carpenter last name</td><td><input size=18 type="text" name="caln" id="caln"></td></tr>
  
 <tr><td></td><td><input type="submit" value="Submit"/></td></tr>
</table>
  </form> 
  
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