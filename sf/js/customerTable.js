(function ($) {
	var method = {
		
	};
	
	$.fn.customerTable = {
		/**
		 * 初始化地址树
		 * @param {Object} obj
		 * @param {Object} options
		 */
		init: function(table, tableId, toolbarId) {
			//第一个实例
			table.render({
				elem: '#'+tableId
		    	,toolbar: '#'+toolbarId
		    	,height: 'full-220'
		    	,url: '/customer/authority' //数据接口
		    	,headers: getLoginToken()
		    	,page: true //开启分页
		    	,request: {
		    		pageName: 'pageNum' //页码的参数名称，默认：page
				    ,limitName: 'pageSize' //每页数据量的参数名，默认：limit
			    }
		    	,cols: [[ //表头
		    		{field: 'id', title: 'ID', type:'checkbox'}
		    		,{field: 'code', title: '用户编码', width:100, align:'center'}
		      		,{field: 'name', title: '用户名称', width:100, align:'center'}
		      		,{field: 'address', title: '地址', width: 200, align:'center'}
		      		,{field: 'one', title: '分公司', width:120, align:'center'}
		      		,{field: 'two', title: '热力站', width:120, align:'center'} 
		      		,{field: 'three', title: '区域', width: 120, align:'center'}
		      		,{field: 'addressPrefix', title: '大楼', width: 120, align:'center'}
		      		,{field: 'idNumber', title: '身份证号', width:200, align:'center'}
		      		
		    	]]
			    ,parseData: function(res){
			    	return {
			    		"code":res.code, 
			    		"msg":res.msg,
						"count": res.data.total, //解析数据长度
						"data": res.data.list //解析数据列表
			    	}
			    }
			});
		},
		
	}
})(jQuery);