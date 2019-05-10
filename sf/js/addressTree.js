(function ($) {
	var method = {
		/**
		 * 异步请求成功时的数据过滤器
		 * @param {Object} treeId 树
		 * @param {Object} parentNode 父节点
		 * @param {Object} responseData 返回数据
		 */
		ajaxDataFilter : function (treeId, parentNode, responseData){
			var nodes = responseData.data
			for(var i =0; i < nodes.length; i++) {
				nodes[i].isParent = true;
			}
			return nodes;
		},
		
		/**
		 * 异步加载前触发事件
		 * @param {Object} treeId
		 * @param {Object} treeNode
		 */
		zTreeBeforeAsync : function (treeId, treeNode){
			if(treeNode){
				if(!treeNode.type){
					return false;
				}
				var param = {}
				method.dg(treeNode, param);
				var treeObj = $.fn.zTree.getZTreeObj(treeId);
				treeObj.setting.async.otherParam = param
			}
			return true;
		},
		
		dg : function (treeNode, param){
			if(treeNode){
				param[treeNode.type] = treeNode.name;
				var parentNode = treeNode.getParentNode();
				method.dg(parentNode,param);
			}
			return null;
		}		
	};
	
	$.fn.addressTree = {
		/**
		 * 初始化地址树
		 * @param {Object} obj
		 * @param {Object} options
		 */
		init: function(obj, options) {
			var defaultSetting = {
				async: {
					enable: true,
					url: "/customer/initTree",
					headers : getLoginToken(),
					dataFilter: method.ajaxDataFilter
				},
				callback: {
					beforeAsync: method.zTreeBeforeAsync
				}
			};
			var setting = $.extend(true, defaultSetting, options);
			zTreeObj = $.fn.zTree.init(obj, setting);
		},
		
		dg: function(treeNode, param){
			return method.dg(treeNode, param);
		}
	}
})(jQuery);