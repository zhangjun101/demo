<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/common/jsp/common.jsp"%>
<title>登陆吧</title>

<script type="text/javascript" src="${ctx}/system/jsp/login/login.js"></script>
<style type="text/css">
</style>
</head>
<body>
    <div id="win" class="easyui-window" title="快点登陆吧！" style="width:400px;height:250px"   
        data-options="iconCls:'icon-man',modal:false,center:true,resizable:false,draggable:false,
        closed:false,closable:false,maximizable:false,minimizable:false,collapsible:false">  
        
		<div class="easyui-layout" data-options="fit:true">
		
			<div data-options="region:'center'" style="padding:10px;border-left: none;border-right: none;border-top:none;">

		        <form id="loginForm" class="easyui-form" method="post">   
				    <div>   
				        <label for="name">Name:</label>   
				        <input class="easyui-validatebox" type="text" value="admin" name="userName" data-options="required:true"/>   
				    </div>   
				    <div>   
				        <label for="email">&emsp; Key:</label>   
				        <input class="easyui-validatebox" type="text" value="123456" name="password" data-options="required:true"/>   
				    </div>   
			    </form>  
			    
			</div>
			
			<div data-options="region:'south',border:false" style="text-align:right;padding:10px;">
				<a class="easyui-linkbutton" data-options="iconCls:'icon-ok'" href="javascript:void(0)" onclick="javascript:loginForm();" style="width:80px">登陆</a>
				<a class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" href="javascript:void(0)" onclick="javascript:resetForm();" style="width:80px">重置</a>
			</div>
		</div>
	</div>  
</body>
</html>