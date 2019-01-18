/**
 * 初始化页面的工具栏
 */
function initToolbar(idSelecter) {
	var menuId = getQueryVariable('menuId');
	$.ajax({
		type : 'post',
		url : '/sysMenu/menuItems',
		async : false,
		headers : getLoginToken(),
		data : {
			id : menuId
		},
		success: function(data) {
			if(data.code=="0000"){
				var container = $("<div class=\"layui-btn-container\"></div>");
				$.each(data.data, function(index, item) {
					container.append($("<button class=\"layui-btn layui-btn-sm\" lay-event=\""+item.url+"\">"+item.name+"</button>"))
				});
				$(idSelecter).html(container[0].outerHTML);
			}
		}
	})
}

function getQueryVariable(variable) {
	var query = window.location.search.substring(1);
	var vars = query.split("&");
	for (var i=0;i<vars.length;i++) {
		var pair = vars[i].split("=");
		if(pair[0] == variable){return pair[1];}
	}
    return(false);
}

/**
 *	获取登录信息的token数据 
 */
function getLoginToken() {
	var header = {
		"myToken" : getCookie("token")
	};
	return header
}

function setLoginToken(request){
	var token = request.getResponseHeader("myToken");
	setCookie("token", token, 1);
}
