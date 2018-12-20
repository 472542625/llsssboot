var totalpage, currentpage;


		$(function() {


                $("#check_all").click(function() {

                    //prop获取原生属性，attr获取自定义属性

                    $(".check_item").prop("checked", $(this).prop("checked"));
                })

                //判断当前选中的元素是不是选满了，满选check_all也勾上
                $("#check_item")
                    .click(
                        function() {
                            //prop获取原生属性，attr获取自定义属性
                            var flag = $(".check_item:checked").length == $(".check_item").length;
                            if (flag) {

                                $("#check_item").prop("checked", flag);

                            }
                        })

			to_page(1);

		})
		//跳转页码函数
		function to_page(pn) {
			$.ajax({
				url :  "/listFyUser",
				data : "pn=" + pn,
				type : "get",
				success : function(result) {
					//console.log(result);
					build_points_table(result);
					build_pages_info(result);
					build_pages_nav(result);
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
								var checkboxTd = $("<td width='80px'><input type='checkbox' class='check_item' /></td>")
								var uid = $("<td width='80px'></td>").append(item.uid);
								var account = $("<td width='150px'></td>")
										.append(item.account);
								var position = $("<td width='100px'></td>").append(item.position);
								var email = $("<td width='100px'></td>").append(item.email);
								var phone = $("<td width='100px'></td>").append(
										item.phone);



								var editBtn = $("<button></button>")
										.addClass(
												"btn btn-primary btn-sm edit_btn")
										.append(
												$("<span></span>")
														.addClass(
																"glyphicon glyphicon-pencil"))
										.append("修改");
								//自定义给这个控件一个edit-id属性,在数据修改弹出框中用到

								editBtn.attr("edit-id", item.uid);
								var deleteBtn = $("<button></button>")
										.addClass(
												"btn btn-danger btn-sm delete_btn")
										.append(
												$("<span></span>")
														.addClass(
																"glyphicon glyphicon-trash"))
										.append("删除");
								deleteBtn.attr("delete-id", item.uid);
								var btn = $("<td width='150px'></td>").append(editBtn)
										.append(" ").append(deleteBtn);
								$("<tr></tr>").append(checkboxTd).append(uid)
										.append(account).append(position)
										.append(email).append(phone)
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
		function build_pages_nav(result) {
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

	
	

		