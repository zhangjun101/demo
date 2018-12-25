$(function(){
	initListTab();
});


function initListTab(){
	$('#listTab').datagrid({    
	    url:ctx+'/user/querryUIPage', 
	    fitColumns:true,
	    fit:true,
	    striped:true,
	    nowrap:true,
	    idField:"userId",
	    rownumbers:false,
	    pagination:true,
	    pageList:[1,5,10,20],
	    toolbar:tbar,
	    queryParams:{userstatus:"N"},
//		rowStyler : function(index, row) {
//			var status = row.status;
//			if (status == 'N')
//				return 'background-color:#ADADAD;';
//		},
	    columns:[[    
	  	    {field:'userId',title:'id',width:100,hidden:true},    
	        {field:'userName',title:'用户',width:100},    
	        {field:'password',title:'密码',width:100},    
	        {field:'dept_id',title:'部门id',width:100}, 
	        {field:'deptName',title:'部门',width:100},
	        {field:'deptCode',title:'部门编号',width:100}, 
	        {field:'userstatus',title:'状态',width:100,formatter:statusFormatter},    
	    ]]    
	}); 
}


//statusFormatter
function statusFormatter(value,row,index){
	if(value=='N'){ return '<span style="color:green;">正常</span>'}
	if(value=='S'){ return '<span style="color:block;">禁用</span>'}
	if(value=='D'){ return '<span style="color:gray;">删除</span>'}
}

//工具栏
var tbar = ['-',{text : '服务申请',id:'AFMAS10001',iconCls : 'icon-man',handler : function() {applyService("");}},
			'-',{text : '服务保障',id:'AFMAS10003',iconCls : 'icon-man',handler : function() {applyService("Y");}},
			'-',{text : '用户添加',id:'AFMAS10003',iconCls : 'icon-man',handler : function() { applyService("Y");}},
			'-',{text : '用户修改',id:'AFMAS10003',iconCls : 'icon-man',handler : function() { applyService("Y");}},
			'-',{text : '用户删除',id:'AFMAS10003',iconCls : 'icon-man',handler : function() { applyService("Y");}},
];



//查询
function searchForm(){
	var fields = $('#queryForm').serializeArray(); //自动序列化表单元素为JSON对象数据格式如下
	var params = {};
	console.log(fields);
	$.each(fields, function(i, field) {//设置查询参数
		params[field.name] = field.value;
	});
	$('#listTab').datagrid('load', params);

//	$('#queryForm').form('submit',{
//		url:ctx+"/user/querryUIPage",
//		onSubmit:function(param){
//			   return $(this).form('enableValidation').form('validate');
//		},
//		success:function(data){
//			$.messager.alert('Info', data, 'info');
//		}
//	});
}



function clearForm(){
	$('#queryForm').form('clear');
	$('#userstatus').combobox('setValue', "N");
}



