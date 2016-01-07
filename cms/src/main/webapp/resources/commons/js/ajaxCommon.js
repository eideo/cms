function ajaxAsync(type,url,data,dateType,success,error){
	$.ajax({
		type:type,
		async:true,
		url:url,
		data:data,
		dataType:dateType,
		success:success,
		error:error
	});
}

function ajaxNotAsync(type,url,data,dateType,success,error){
	$.ajax({
		type:type,
		async:false,
		url:url,
		data:data,
		dataType:dateType,
		success:success,
		error:error
	});
}