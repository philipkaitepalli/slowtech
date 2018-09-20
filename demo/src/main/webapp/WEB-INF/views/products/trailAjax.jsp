<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>

<html>
     <head>
     <title>trailAjax</title>
            <script type="text/javascript" src="<c:url value="/resources/js/myjs.js"/>"></script>    
     </head>  
      
      
     <s:url var="url_bg" value="/resources/img/pic2.jpg" />
<body background="${url_bg}">   
   text:<input type="text" onKeyUp="doSurch();" id="surch"/>
   
     <div id="results">
     results displays hear  
     
     </div>
</body>
</html>