//
//function listTreeByTreeName_showLayerOpen() {
//	layui.use('layer', function() { // 独立版的layer无需执行这一句
//		var $ = layui.jquery, layer = layui.layer; // 独立版的layer无需执行这一句
//
//		layer.open({
//			type : 1,
//			area : [ '60%', '400px' ],
//			title : '树种搜索结果',
//			// ,offset: type
//			// //具体配置参考：http://www.layui.com/doc/modules/layer.html#offset
//			// ,id: 'layerDemo'+type //防止重复弹出
//			anim : 1,
//
//			content : $("#points_table"),
//			btn : [ '关闭' ],
//
//			btnAlign : 'c' // 按钮居中
//			,
//			shade : 0,
//			yes : function() {
//				layer.closeAll();
//			}
//		});
//
//	});
//}

function showLayerOpen_treeage() {
 
	layui.use('layer', function() {
		var $ = layui.jquery, layer = layui.layer;
		layer.open({
			type : 1,
			area : "500px",
			title : '树龄搜索',
			// ,offset: type
			// //具体配置参考：http://www.layui.com/doc/modules/layer.html#offset
			// ,id: 'layerDemo'+type //防止重复弹出
			// id: 'findByage_div',
			anim : 1,
			offset : [ '100px', '249px' ],
			content : $("#findByage_div"),
			btn : [ '搜索' ],

			btnAlign : 'c' // 按钮居中
			,
			shade : 0,
			yes : function() {
				findByAge();
//				findByAge($("#select_orgintreeage").children('option:selected')
//						.val(), $("#select_destreeage").children(
//						'option:selected').val());

			}
		});

	});
}

function showLayerOpen_treeheight() {
 
	layui.use('layer', function() { // 独立版的layer无需执行这一句
		var $ = layui.jquery, layer = layui.layer; // 独立版的layer无需执行这一句

		layer.open({
			type : 1,
			area : "500px",
			title : '编码搜索',
			// ,offset: type
			// //具体配置参考：http://www.layui.com/doc/modules/layer.html#offset
		 
//			anim : 1,
			offset : [ '100px', '249px' ],
			content : $("#findBytreeheight_div"),
			btn : [ '搜索' ],

			btnAlign : 'c' // 按钮居中
			,
			shade : 0,
			yes : function() {
				findByTreeHeight();
			 
//				findByTreeHeight($("#select_orgintreeheight").children(
//						'option:selected').val(), $("#select_destreeheight")
//						.children('option:selected').val());
			 

			}
		});

	});
}


function showLayerOpen_contractor() {
 
	layui.use('layer', function() {
		var $ = layui.jquery, layer = layui.layer;
		layer.open({
			type : 1,
			area : "500px",
			title : '承包人搜索',
			// ,offset: type
			// //具体配置参考：http://www.layui.com/doc/modules/layer.html#offset
			// ,id: 'layerDemo'+type //防止重复弹出
			// id: 'findByage_div',
			anim : 1,
			offset : [ '100px', '249px' ],
			content : $("#findBycontractor_div"),
			btn : [ '搜索' ],

			btnAlign : 'c' // 按钮居中
			,
			shade : 0,
			yes : function() {
				findByContractor();
//				findByAge($("#select_orgintreeage").children('option:selected')
//						.val(), $("#select_destreeage").children(
//						'option:selected').val());

			}
		});

	});
}

function showLayerOpen_treespecies() {
	 
	layui.use('layer', function() {
		var $ = layui.jquery, layer = layui.layer;
		layer.open({
			type : 1,
			area : "500px",
			title : '树种搜索',
			// ,offset: type
			// //具体配置参考：http://www.layui.com/doc/modules/layer.html#offset
			// ,id: 'layerDemo'+type //防止重复弹出
			// id: 'findByage_div',
			anim : 1,
			offset : [ '100px', '249px' ],
			content : $("#findBytreespecies_div"),
			btn : [ '搜索' ],

			btnAlign : 'c' // 按钮居中
			,
			shade : 0,
			yes : function() {
			
				
				findBytreespecies();
//				findByAge($("#select_orgintreeage").children('option:selected')
//						.val(), $("#select_destreeage").children(
//						'option:selected').val());

			}
		});

	});
}


function showLayerOpen_id() {

    layui.use('layer', function() {
        var $ = layui.jquery, layer = layui.layer;
        layer.open({
            type : 1,
            area : "500px",
            title : '标牌搜索',
            // ,offset: type
            // //具体配置参考：http://www.layui.com/doc/modules/layer.html#offset
            // ,id: 'layerDemo'+type //防止重复弹出
            // id: 'findByage_div',
            anim : 1,
            offset : [ '100px', '249px' ],
            content : $("#findBygid_div"),
            btn : [ '搜索' ],

            btnAlign : 'c' // 按钮居中
            ,
            shade : 0,
            yes : function() {


                findById();


            }
        });

    });
}

function showLayerOpen_area() {

    layui.use('layer', function() {
        var $ = layui.jquery, layer = layui.layer;
        layer.open({
            type : 1,
            area : "500px",
            title : '承包人搜索',
            // ,offset: type
            // //具体配置参考：http://www.layui.com/doc/modules/layer.html#offset
            // ,id: 'layerDemo'+type //防止重复弹出
            // id: 'findByage_div',
            anim : 1,
            offset : [ '100px', '249px' ],
            content : $("#findByarea_div"),
            btn : [ '搜索' ],

            btnAlign : 'c' // 按钮居中
            ,
            shade : 0,
            yes : function() {
                findByArea();
//				findByAge($("#select_orgintreeage").children('option:selected')
//						.val(), $("#select_destreeage").children(
//						'option:selected').val());

            }
        });

    });
}


function showerror() {
	layui.use('layer', function() { // 独立版的layer无需执行这一句
		var $ = layui.jquery, layer = layui.layer; // 独立版的layer无需执行这一句

		layer.msg('未搜索到指定数据，请重新输入搜索条件并重试！', {
			icon : 2
		});
	})
}
