/**
 * 登陆表单提交
 * */
function loginForm(){
	
	$('#loginForm').form('submit', {
		url:ctx+'/login/userLogin',
		onSubmit:function(){
			return $(this).form('enableValidation').form('validate');
		},  
	    success:function(data){  
	    	var resultJson=JSON.parse(data);
	    	if(resultJson!=null && typeof(resultJson)!='undentified'){
		    	window.location.href=ctx+"/login/loginToMain";
		    }
	    }    
	});  

}




	
/**
 * 重置
 * */	
function resetForm(){
	$('#loginForm').form('clear');
}
	

	
