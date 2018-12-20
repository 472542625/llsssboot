//删除数据事件

		
		
		$(document).on("click", "#point_Del_modalBtn", function() {
			var del_idstr="";
			 $.each($(".check_item:checked"),function(){
				 
				//alert($(this).parents("tr").find("td:eq(1)").text());
				 
				 
				del_idstr+=$(this).parents("tr").find("td:eq(1)").text()+"-";
				
				 
			 })
			 
			 del_idstr=del_idstr.substring(0, del_idstr.length-1);
			 if (confirm("确认删除吗？")) {
					$.ajax({
						url : "/deletePoint/" + del_idstr,
						type : "DELETE",
						success : function(result) {

							
							to_page(currentpage);
						}
					})
				} 

		});
		
		
		