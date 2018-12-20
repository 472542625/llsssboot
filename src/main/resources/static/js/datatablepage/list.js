var totalpage, currentpage;



		$(function() {
            $("#check_all").click(function () {

                //prop获取原生属性，attr获取自定义属性

                $(".check_item").prop("checked", $(this).prop("checked"));
            })

            //判断当前选中的元素是不是选满了，满选check_all也勾上
            $("#check_item")
                .click(
                    function () {
                        //prop获取原生属性，attr获取自定义属性
                        var flag = $(".check_item:checked").length == $(".check_item").length;
                        if (flag) {

                            $("#check_item").prop("checked", flag);

                        }
                    })
            to_page(1);

			//查询中树种列表初始化初始化

            getPointTreespecies("#Treespecies_select");//此函数在edit.js文件中
            getPointgrowingPotential("#growingPotential_select");
            getPointVillage("#Village_select");
            var optionTreespecies = $("<option></option>")
                .append("请选择").attr("value", 0);
            optionTreespecies.appendTo($("#Treespecies_select"));

            var optiongrowingPotential = $("<option></option>")
                .append("请选择").attr("value", 9);
            optiongrowingPotential.appendTo($("#growingPotential_select"));


		})
		//跳转页码函数
		function to_page(pn) {
			$.ajax({

                url :  "/listFyjsonPoint",
				data : "pn=" + pn,
				type : "get",
				success : function(result) {


					 if(result.extend.pageInfo.list.length!=0){
					build_points_table(result);
					build_pages_info(result);
					build_pages_nav(result);
                     }
				}
			})
		}
		//分页查询模块数据加载函数
		function build_points_table(result) {
			$("#points_table tbody").empty();
			var points = result.extend.pageInfo.list;
			$
					.each(
							points,
							function(index, item) {
								 var checkboxTd = $("<td><input type='checkbox' class='check_item' /></td>");
                                // var gid= $("<td width='80px'></td>").append(item.gid);
                                // var urban= $("<td width='80px'></td>").append(item.urban);
                                // var town= $("<td width='80px'></td>").append(item.town);
                                // var village= $("<td width='80px'></td>").append(item.village);
                                // var area= $("<td width='150px'></td>").append(item.area);
                                // var contractor= $("<td width='80px'></td>").append(item.contractor);
                                // var id= $("<td width='80px'></td>").append(item.id);
                                // var treespeciesvar= $("<td width='80px'></td>").append(item.treespeciesvar.treespeciesname);
                                // var visitage= $("<td width='80px'></td>").append(item.visitage+ "年");
                                // var treeage= $("<td width='80px'></td>").append(item.treeage+ "年");
                                // var treeheight= $("<td width='80px'></td>").append(item.treeheight+ "米");
                                // var grounddiameter= $("<td width='80px'></td>").append(item.grounddiameter+ "厘米");
                                // var treearea= $("<td width='80px'></td>").append(item.treearea);
                                // var growingpotential= $("<td width='80px'></td>").append(item.growingpotential.growingpotential);
                                // var recorder= $("<td width='80px'></td>").append(item.recorder);
                                // var date= $("<td width='80px'></td>").append(item.date);
                                // var x= $("<td width='80px'></td>").append(item.x);
                                // var y= $("<td width='80px'></td>").append(item.y);
                                // var maintenance= $("<td width='80px'></td>").append(item.maintenance);

								var pointId = $("<td width='80px'></td>").append(item.gid);
								var pointarea = $("<td width='150px'></td>")
										.append(item.area);
								var pointx = $("<td width='80px'></td>").append(item.x);
								var pointy = $("<td width='80px'></td>").append(item.y);
								var pointcontractor = $("<td width='80px'></td>").append(
										item.contractor);
								// var pointrecorder = $("<td width='150px'></td>").append(
								// 		item.recorder);
								var pointtreespecies = $("<td width='100px'></td>").append(
										item.treespeciesvar.treespeciesname);
								var pointtreeage = $("<td width='100px'></td>").append(
										item.treeage + "年");
								var pointtreeheight = $("<td width='100px'></td>").append(
										item.treeheight + "米");
								var pointgrowing_potential = $("<td width='100px'></td>")
										.append(item.growingpotential.growingpotential);
								var pointgrounddiameter = $("<td width='100px'></td>")
										.append(item.grounddiameter + "厘米");

								var editBtn = $("<button></button>")
										.addClass(
												"btn btn-primary btn-sm edit_btn")
										.append(
												$("<span></span>")
														.addClass(
																"glyphicon glyphicon-pencil"))
										;
								//自定义给这个控件一个edit-id属性,在数据修改弹出框中用到

								editBtn.attr("edit-id", item.gid);

								var btn = $("<td width='150px'></td>").append(editBtn);

								// $("<tr></tr>").append(checkboxTd).append(gid)
								// 		.append(urban).append(town)
								// 		.append(village).append(area).
								// 		 append(contractor).append(id).
								//          append(treespeciesvar).append(visitage).append(treeage).append(treeheight).append(
                                 //    grounddiameter).append(treearea).append(growingpotential).append(recorder).append(date)
								// 	.append(x).append(y).append(maintenance).append(btn).appendTo("#points_table");

                                $("<tr></tr>").append(checkboxTd).append(pointId)
                                    .append(pointarea).append(pointx)
                                    .append(pointy).append(pointcontractor).
                                append(pointtreespecies).append(
                                    pointtreeage).append(
                                    pointtreeheight).append(
                                    pointgrowing_potential).append(
                                    pointgrounddiameter)
                                    .append(btn).appendTo("#points_table");
							});
		}
		//分页查询左下角记录数模块
		function build_pages_info(result) {
			$("#page_info_area").empty();
			$("#page_info_area").append(
					"当前" + result.extend.pageInfo.pageNum + "页，总" + result.extend.pageInfo.pages + " 页，总"
							+ result.extend.pageInfo.total + "条记录");
			totalpage = result.extend.pageInfo.pages;
			currentpage = result.extend.pageInfo.pageNum;
		}
		//分 页查询右下角页码切换模块
		function build_pages_nav(result ) {
			$("#page_info_nav").empty();
			var ul = $("<ul></ul>").addClass("pagination");
			var firstPageLi = $("<li></li>").append(
					$("<a></a>").append("首页"));
			var prePageLi = $("<li></li>").append(
					$("<a></a>").append("&laquo;"));
			if (result.extend.pageInfo.hasPreviousPage == false) {
				firstPageLi.addClass("disabled");
				prePageLi.addClass("disabled");
			} else {
				firstPageLi.click(function() {
					to_page(1);
				});
				prePageLi.click(function() {
					to_page(result.extend.pageInfo.pageNum - 1);
				});
			}
			;

			var nextPageLi = $("<li></li>").append(
					$("<a></a>").append("&raquo;"));
			var lastPageLi = $("<li></li>").append(
					$("<a></a>").append("末页"));

			if (result.hasNextPage == false) {
				lastPageLi.addClass("disabled");
				nextPageLi.addClass("disabled");
			} else {
				lastPageLi.click(function() {
					//	result.pages
					to_page(totalpage);
				});
				nextPageLi.click(function() {
					to_page(result.extend.pageInfo.pageNum + 1);
				});
			}
			;
			ul.append(firstPageLi).append(prePageLi);//添加首页和前一页
			
			
			$.each(result.extend.pageInfo.navigatepageNums, function(index, item) {
				var numLi = $("<li></li>").append($("<a></a>").append(item));
				if (result.extend.pageInfo.pageNum == item) {
					numLi.addClass("active");
				}
				numLi.click(function() {
					to_page(item);
				});
				ul.append(numLi);
			});
			
			ul.append(nextPageLi).append(lastPageLi);//添加下一页和末页
			var navEle = $("<nav></nav>").append(ul);
			navEle.appendTo("#page_info_nav");
		}


//查询后的右下角页码切换模块
function build_pages_nav_select(result) {
    $("#page_info_nav").empty();
    var ul = $("<ul></ul>").addClass("pagination");
    var firstPageLi = $("<li></li>").append(
        $("<a></a>").append("首页"));
    var prePageLi = $("<li></li>").append(
        $("<a></a>").append("&laquo;"));
    if (result.extend.pageInfo.hasPreviousPage == false) {
        firstPageLi.addClass("disabled");
        prePageLi.addClass("disabled");
    } else {
        firstPageLi.click(function() {
            to_page_select(1);
        });
        prePageLi.click(function() {
            to_page_select(result.extend.pageInfo.pageNum - 1);
        });
    }
    ;

    var nextPageLi = $("<li></li>").append(
        $("<a></a>").append("&raquo;"));
    var lastPageLi = $("<li></li>").append(
        $("<a></a>").append("末页"));

    if (result.hasNextPage == false) {
        lastPageLi.addClass("disabled");
        nextPageLi.addClass("disabled");
    } else {
        lastPageLi.click(function() {
            //	result.pages
            to_page_select(totalpage);
        });
        nextPageLi.click(function() {
            to_page_select(result.extend.pageInfo.pageNum + 1);
        });
    }
    ;
    ul.append(firstPageLi).append(prePageLi);//添加首页和前一页


    $.each(result.extend.pageInfo.navigatepageNums, function(index, item) {
        var numLi = $("<li></li>").append($("<a></a>").append(item));
        if (result.extend.pageInfo.pageNum == item) {
            numLi.addClass("active");
        }
        numLi.click(function() {
            to_page_select(item);
        });
        ul.append(numLi);
    });

    ul.append(nextPageLi).append(lastPageLi);//添加下一页和末页
    var navEle = $("<nav></nav>").append(ul);
    navEle.appendTo("#page_info_nav");
}




function to_page_select(pn) {

			//alert($("#tree_select_form").serialize());
    $.ajax({
        url: "/selectTreeByCondtion",
        data:$("#tree_select_form").serialize()+"&"+"pn=" + pn,
        type: "get",
        success: function (result) {

            if(result.extend.pageInfo.list.length!=0){

            build_points_table(result);
            build_pages_info(result);
            build_pages_nav_select(result);}

            else{
               $("#points_table tbody").empty();
                $("#page_info_area").empty();
                $("#page_info_nav").empty();
                layui.use('layer', function() { // 独立版的layer无需执行这一句
                    var $ = layui.jquery, layer = layui.layer; // 独立版的layer无需执行这一句

                    layer.msg('未搜索到指定数据，请重新输入搜索条件并重试！', {
                        icon : 2
                    });
                })
			}
        }
    })
}
// 修改数据事件
$(document).on("click", "#tree_select_Btn", function() {

    to_page_select(1);


});

		