/**
 * 
 */

submit = function(){
	
	var obj={cfn:$("#cfn").val(),cln:$("#cln").val(),cafn:$('#cafn').val(),caln:$('#caln').val()};
	   
    $.ajax({
        url:'getIds',
        type:'GET',
        data:obj,
    });
}