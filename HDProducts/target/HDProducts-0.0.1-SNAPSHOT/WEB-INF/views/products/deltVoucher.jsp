<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %> 
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<s:url var="url_css" value="/staticfiles/css/mystyle.css"/>
<link href="${url_css}" rel="stylesheet" type="text/css"/>
<s:url var="url_bs" value="/staticfiles/bootstrap-3.3.6-dist/css"/>
<link href="${url_bs}" rel="stylesheet" type="text/css"/>


 <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery.min.js"></script>
  <script src="//code.jquery.com/jquery-1.12.4.js"></script>
  <script src="//code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script type="text/javascript" src="<s:url value="/staticfiles/js/deitVoucher.js"/>"></script>
 <script type="text/javascript" src="<s:url value="/staticfiles/js/printfile.js"/>"></script> 

<title>Insert title here</title>
</head>


<body>
<form action="/HDProducts/billsList/deltVoucher" align="right">
<input  type="submit" value="Delete"/>
</form>
  <form action="/HDProducts/billsList/custBills">
 <table>
 
 <tr><td>Customer first name:</td><td><input size=18 type="text" name="dcfn" id="dcfn" ></td><td>Customer last name</td><td><input size=18 type="text" name="dcln" id="dcln" ></td><td><input type="submit" value="submmit"/></td></tr> 
  </table></form> 
</body>
</html>