$(function(){
	
	$('#userList').datagrid({
		url:ctx+"/user/getUserByPage",
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
			{field:'deptName',title:'部门',width:80,formatter:formatDeptName}
		]]
	});
	
});



//格式化部门名称
function formatDeptName(val,row,index){
	return row.dept.deptName;
}

  