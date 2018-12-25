<!-- 引入jstl相关标签 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="m"   uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path;
%>
<html>
<head>
<!-- 引入 全局变量 -->
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!-- 引入easyui样式表 -->
<link rel="stylesheet" type="text/css" href="${ctx}/plug/easyui-1.5.5.2/themes/default/easyui.css">   
<link rel="stylesheet" type="text/css" href="${ctx}/plug/easyui-1.5.5.2/themes/icon.css">
<link rel="stylesheet" type="text/css" href="${ctx}/plug/easyui-1.5.5.2/demo/demo.css">

<script type="text/javascript" src="${ctx}/plug/jquery/jquery-2.1.1.min.js"></script>     
<script type="text/javascript" src="${ctx}/plug/easyui-1.5.5.2/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${ctx}/plug/easyui-1.5.5.2/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${ctx}/common/js/common.js"></script>

<title></title>
<script type="text/javascript">
	var ctx = "${ctx}";
</script>
</head>
<body>
</body>
</html>