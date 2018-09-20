<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %> 
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>slowT</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
 <script type="text/javascript" src="<s:url value="/staticfiles/js/jquery-3.3.1.min.js"/>"></script>
 <script>
 
 function states(x,y){
		    	   $.ajax({
	               url:'changeStatus',
	               type:'POST',
	               data:{a:x,b:y},          
	           });
	       }
	      
 </script>
 <%-- <script>
  function roll(x,y){ 
	    	 	     	 $.ajax({
	             url:'changeRoll',
	             type:'POST',
	             data:{a:x,b:y},       
	         });
	       } 
 </script> --%>
</head>

<s:url var="url_img" value="/staticfiles/img/" />
<body background="${url_img}">

<table border="1" width="98%" align="center">
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
   <!--  page content -->
   <center>
   <h4>Users list</h4>
  <p> ${err}</p>
  
   <table border="1" >
   <tr>
 <th>userId</th> 
   <th>FirstName</th>
   <th>LastName</th>
   <th>CellNumber</th>
   <th>Address</th>
  <!--  <th>email</th> -->
   <th>LoginName</th>
    <th>password</th>
     <th>roll</th> 
          <th>Status</th>
       <!-- <th>Action</th> -->
       </tr>
     
    <c:forEach var="user" items="${ul}">
                            <tr>
                    <td>${user.userId}</td> 
                             <td>${user.firstName}</td>
                     <td>${user.lastName}</td>
                        <td>${user.phoneNumber}</td>
                       <td>${user.address}</td>
                      <%--  <td>${user.email}</td> --%>
                         <td>${user.loginName}</td> 
                         <td>${user.password}</td>
                       <td>
                       ${user.roll}
                      <%--  
                       <select id="${user.userId}" onchange="roll( ${user.userId},$(this).val())">
                                 <option value="1">Admin</option>
                                 <option value="2">User</option> </select>
                                  <script>
                                   $('#${user.userId}').val(${user.roll})
                                 </script> --%>
                             
                       </td>
                              
                            <td><select id="${user.userId}" onchange="states( ${user.userId},$(this).val())">
                                 <option value="1">Active</option>
                                 <option value="2">Blocked</option>
                                 </select>
                                  <script>
                                   $('#${user.userId}').val(${user.loginStatus})
                                 </script>
                                ${user.loginStatus}
                            </td>   
                  </tr>
                  </c:forEach>
                  
                  </table>
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