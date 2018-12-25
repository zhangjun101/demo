$(function(){
	//获取所有用户数据
//	$.post(ctx+"/login/getUser", 
//			{"func": "getNameAndTime"},
//			function(data){
//			     console.log(data); 
//			}, "json");
	
	$('#userList').datagrid({
		url: ctx+"/user/getUserByPage",
		method: 'get',
		title: '',
		iconCls: '',
		pagination:true,
		fit:true,
		fitColumns: true,
		singleSelect: true,
		pageList:[1,5,10],
		columns:[[
			{field:'userName',title:'用户名',width:80},
			{field:'deptId',title:'部门',width:80}
		]]
	
	});
	
	
});



  