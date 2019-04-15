(function ($) {
	/**
	 * 层级结构
	 */
	var org = ['one', 'two', 'three'];
	
	/**
	 * 初始化formSelectV4对象
	 */
	var formSelects = layui.formSelects;
	
	/**
	 * 函数工具类
	 */
	var method = {
		
		/**
		 * 下拉数据初始化数据
		 * @param {Object} index
		 * @param {Object} param
		 * @param {Object} orgSelectArray
		 */
		_initOnSelect: function(index, param, orgSelectArray){
			// 当前的下拉对象
			var selectObj = orgSelectArray[index];
			
			// 绑定选中事件
			formSelects.on(selectObj.id, function(id, vals, val, isAdd, isDisabled){
				method._initChangeEvent(index+1, orgSelectArray);
			}, true);
		
			if(index > 0 && !selectObj.value){
				return ;
			}
			
			$.ajax({
				type: 'get',
				url: '/customer/initTree',
				headers: getLoginToken(),
				data: param,
				success: function(result){
			    	$.each(result.data, function(index, item) {
			    		item.value = item.name;
			    		if(item.name == selectObj.value){
			    			item.selected = 'selected';
			    		}
			    	});	
			    	formSelects.data(selectObj.id, "local",{
					    arr: result.data,
					    clearInput: true,
					}, true);
				}
			})
		},
		
		/**
		 * 下拉菜单选中触发事件
		 * @param {Object} index
		 * @param {Object} orgSelectArray
		 */
		_initChangeEvent: function(index, orgSelectArray) {
			if(index < org.length){
				// 请求下一级菜单的数据
				var data = {};
				for(var i = 0; i < index; i++){
					data[org[i]] = formSelects.value(orgSelectArray[i].id, 'valStr')
				}
				
				formSelects.data(org[index], "server",{
				    type: 'get',
				    header: getLoginToken(),
				    url: '/customer/initTree',
				    data: data,
				    keyName: 'name',
				    keyVal: 'name',
				    clearInput: true,
				}, true);
				
				// 清除已选择的数据
				for(var i = index + 1; i < org.length; i++){
					formSelects.data(org[i], "local",{
					    arr : [],
					}, true);
				}
			}
		}
	}
	
	$.fn.orgSelect = {
		/**
		 * 初始化地址树
		 * @param {Object} obj
		 * @param {Object} options
		 */
		init: function(orgSelectArray) {
			var data = {};
			for(var i =0; i<orgSelectArray.length; i++){
				if(i > 0) {
					data[org[i-1]] = orgSelectArray[i-1].value;
				}
				// 初始化下拉数据
				method._initOnSelect(i, data, orgSelectArray);
			}
		}
	}
})(jQuery);