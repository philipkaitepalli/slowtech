<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery.min.js"></script>
 <script src="//code.jquery.com/jquery-1.12.4.js"></script>
  <script src="//code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript" src="<s:url value="/staticfiles/js/search.js"/>"></script>
 <%-- <script type="text/javascript" src="<s:url value="/staticfiles/js/trail.js"/>"></script> --%>
</head>
<body>
<!-- 
<input size=18  type="text"  id="fp" placeholder="Enter first property"> 
         <input size=18 type="text" id="sp" placeholder="Enter second property" >
         <input size=11 type="text" id="fd" placeholder=" first dimention"/>
         <input size=11 type="text" id="sd" placeholder="second dimention" />
         <input size=11 type="text" id="nop"  placeholder="No.of pices"/>
         <input size=5 type="text" id="percent"  placeholder="Enter %"/> 
         <button onclick="submit();">Submit</button>
         
  ----------------------------------------------------------------------------------------       
         
          -->
       <!--   
        <table id="table" border=1>
            <tr> <th> Name </th> <th> Email </th> <th> Edit </th> <th> Delete </th> </tr>
         
        </table>
             
     
    <script type="text/javascript">
    data = "";
    submit = function(){
          
            $.ajax({
                url:'saveOrUpdate',
                type:'POST',
                data:{user_id:$("#user_id").val(),user_name:$('#name').val(),email:$('#email').val()},
                success: function(response){
                        alert(response.message);
                        load();    
                }              
            });        
    }
     
    delete_ = function(id){     
         $.ajax({
            url:'delete',
            type:'POST',
            data:{user_id:id},
            success: function(response){
                    alert(response.message);
                    load();
            }              
        });
}
     
 
    edit = function (index){
        $("#user_id").val(data[index].user_id);
        $("#name").val(data[index].user_name);
        $("#email").val(data[index].email);
         
    }
     
     
    load = function(){ 
        $.ajax({
            url:'list',
            type:'POST',
            success: function(response){
                    data = response.data;
                    $('.tr').remove();
                    for(i=0; i<response.data.length; i++){                  
                        $("#table").append("<tr class='tr'> <td> "+response.data[i].user_name+" </td> <td> "+response.data[i].email+" </td> <td> <a href='#' onclick= edit("+i+");> Edit </a>  </td> </td> <td> <a href='#' onclick='delete_("+response.data[i].user_id+");'> Delete </a>  </td> </tr>");
                    }          
            }              
        });
         
    }
         
    </script>
      -->
</body>  
  
</html>