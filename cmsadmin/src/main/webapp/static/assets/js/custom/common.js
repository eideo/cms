function getHostPath() {
	// 获取当前网址，如：http://localhost:8088/cmsadmin/login.jsp
	var curWwwPath = document.location.href;
	 // 获取主机地址之后的目录，如：/cmsadmin/login.jsp
	var pathName = document.location.pathname;
	var index = curWwwPath.indexOf(pathName);
	var hostPath = curWwwPath.substring(0, index);
	return hostPath;
}

function getContextPath() {
	 // 获取主机地址之后的目录，如：/cmsadmin/login.jsp
	var pathName = document.location.pathname;
	var index = pathName.substr(1).indexOf("/");
	 // 获取带"/"的项目名，如：/cmsadmin
	var projectName = pathName.substr(0, index + 1);
	return projectName;
}
