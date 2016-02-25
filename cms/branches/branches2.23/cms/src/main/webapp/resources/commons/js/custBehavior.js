// 用户行为-热词搜索
function getHotwordMap() {
	// alert("into getHotwordMap");
	$.ajax({
		url : path + "/customerBehavior/getHotword",
		type : "GET",
		dataType : "json",
		success : function(data) {
			return data;
		},
		error : function() {
			return "error";
		}
	});
}

// 用户行为-关注/收藏
function custBehavior(actionType, infoType, infoId, infoValid) {
	// alert("into custBehavior");
	var status = 0;
	var url = "";
	var infoName = "";
	if (actionType == 3) {
		url = path + "/customerBehavior/attention";
		if (infoValid == 0) {
			url = path + "/customerBehavior/cancel";
		}
	} else if (actionType == 4) {
		url = path + "/customerBehavior/collection";
		if (infoValid == 0) {
			url = path + "/customerBehavior/cancel";
		}
	}
	var id = "info_" + infoId;
	// alert(!$.isEmptyObject($("#" + id)));
	if(!$.isEmptyObject($("#" + id))) {
		infoName = $("#" + id).text();
		// infoName = infoName.replace(/<\/?[^>]*>/g, '');
	}
	// alert("infoName=" + infoName);
	if(infoId.indexOf("-") > -1) {
		infoId = infoId.substr(infoId.indexOf("-") + 1);
	}
	
	$.ajax({
		url : url,
		async : false, //ajax返回值赋值给变量，必须定义为同步
		data : {
			'actionType' : actionType,
			'infoType' : infoType,
			'infoId' : infoId,
			'infoName' : infoName,
			'infoValid' : infoValid
		},
		type : "POST",
		dataType : "json",
		success : function(data) {
			status = data.status;
		},
		error : function() {
			status = -2;
		}
	});
	
	return status;
}

//用户行为-点击
function custBehaviorClick(actionType, infoType, infoId, infoValid) {
	// alert("into custBehaviorClick");
	var url = "";
	var infoName = "";
	if (actionType == 2) {
		url = path + "/customerBehavior/detailPage";
		if (infoType == '1') {
			url = path + "/customerBehavior/relNetwork";
		}
	}
	var id = "info_" + infoId;
	// alert(!$.isEmptyObject($("#" + id)));
	if(!$.isEmptyObject($("#" + id))) {
		infoName = $("#" + id).text();
		// infoName = infoName.replace(/<\/?[^>]*>/g, '');
	}
	// alert("infoName=" + infoName);
	if(infoId.indexOf("-") > -1) {
		infoId = infoId.substr(infoId.indexOf("-") + 1);
	}

	$.ajax({
		url : url,
		data : {
			'actionType' : actionType,
			'infoType' : infoType,
			'infoId' : infoId,
			'infoName' : infoName,
			'infoValid' : infoValid
		},
		type : "POST",
		dataType : "json",
		success : function(data) {
			
		},
		error : function() {
			
		}
	});
}

//用户行为-分享
function custBehaviorShare(actionType, infoType, infoId, shareTarget) {
	// alert("into custBehaviorShare");
	var url = "";
	var infoName = "";
	if (actionType == 5) {
		url = path + "/customerBehavior/share";
	}
	var id = "info_" + infoId;
	// alert(!$.isEmptyObject($("#" + id)));
	if(!$.isEmptyObject($("#" + id))) {
		infoName = $("#" + id).text();
		// infoName = infoName.replace(/<\/?[^>]*>/g, '');
	}
	// alert("infoName=" + infoName);
	
	if(infoId.indexOf("-") > -1) {
		infoId = infoId.substr(infoId.indexOf("-") + 1);
	}

	$.ajax({
		url : url,
		data : {
			'actionType' : actionType,
			'infoType' : infoType,
			'infoId' : infoId,
			'infoName' : infoName,
			'shareTarget' : shareTarget
		},
		type : "POST",
		dataType : "json",
		success : function(data) {
			
		},
		error : function() {
			
		}
	});
}

//用户行为-点击搜索条件
function topClick(actionType, clickType, clickContent) {
	// alert("into topClick");
	$.ajax({
		url : path + "/customerBehavior/topClick",
		data : {
			'actionType' : actionType,
			'clickType' : clickType,
			'clickContent' : clickContent
		},
		type : "POST",
		dataType : "json",
		success : function(data) {
			
		},
		error : function() {
			
		}
	});
}