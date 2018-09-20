<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="s" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
  
 <s:url  var="uri_jqlib" value="/staticfiles/js/jquery-3.3.1.min.js"/> 
<script src="${uri_jqlib}"></script>
 <script type="text/javascript" src="<s:url value="/staticfiles/js/search.js"/>"></script>
  </head>
  
<body>

    Enter text: <input type="text" onKeyUp='doSearch();'/>
   <div id=rlt></div>

</body>
</html>