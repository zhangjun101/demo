<%@ page language="java"  import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ page import="com.utils.propertiesUtil.ReadPropertiesUtil"%> --%>
<%-- <%  --%>
<!-- // 	String version = ReadPropertiesUtil.getProperty("SYS_VERSION"); -->
<%-- %> --%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/common/jsp/common.jsp"%>

<title>框架页</title>
<script type="text/javascript" src="${ctx}/system/jsp/main/main.js"></script>


<style type="text/css">
	.myMenu{height:30px;width:calc(100% - 20px);cursor: pointer;padding-left:20px;}
	.myMenu:HOVER{background-color:gray;}
	.menuFont{line-height:30px;}
</style>

</head>
<body class="easyui-layout" >
    <div data-options="region:'north',title:'',split:false" style="height:70px;">
    	logo
    </div>  
     
    <div align="center" data-options="region:'south',title:'',split:false" style="height:30px;">
<%--     	<font style="line-height:30px;">超级DEMO <%=version %> </font> --%>
    </div>  
    <div data-options="region:'east',iconCls:'icon-man',title:'当前在线用户',split:true,collapsed:true" style="width:200px;">
    
		<table id="userList"></table>
    
    	
    </div> 
      
    <div data-options="region:'west',iconCls:'icon-man',title:'菜单导航栏',split:true" style="width:200px;">
    	<div id="menuPanel" class="easyui-panel" title="导航菜单"   
	        data-options="iconCls:'icon-save',closable:false,collapsible:false,
	        minimizable:false,maximizable:false,fit:true,border:false">   
			    <div id="aa"  class="easyui-accordion" fit="true" border="false" style=""></div>  
		</div>  
    </div>   
    
    <div data-options="region:'center',title:''" style="">
    	<div id="tab-tools">
			<a href="javascript:void(0)" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-add'" onclick="addPanel()"></a>
			<a href="javascript:void(0)" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-remove'" onclick="removePanel()"></a>
		</div>
	  	<div class="easyui-tabs" id="tabs" data-options="fit:true,border:false,tools:'#tab-tools'" ></div>
    </div>   
</body>
</html>