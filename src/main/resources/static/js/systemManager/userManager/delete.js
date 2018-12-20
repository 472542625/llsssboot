//删除数据事件
$(document).on("click", ".delete_btn", function() {
    //1.是否删除对话框
    //var  = $(this).parents("tr").find("td:eq(0)").text();
    var uid = $(this).attr("delete-id");

    if (confirm("确认删除编号【" + uid + "】吗？")) {
        $.ajax({
            url : "/deleteuser/" + uid,
            type : "DELETE",
            success : function(result) {

                to_page(currentpage);
            }
        })
    }

});

		
		
		// $(document).on("click", "#point_Del_modalBtn", function() {
		// 	var del_idstr="";
		// 	 $.each($(".check_item:checked"),function(){
		//
		// 		//alert($(this).parents("tr").find("td:eq(1)").text());
		//
		//
		// 		del_idstr+=$(this).parents("tr").find("td:eq(1)").text()+"-";
		//
		//
		// 	 })
		//
		// 	 del_idstr=del_idstr.substring(0, del_idstr.length-1);
		// 	 if (confirm("确认删除吗？")) {
		// 			$.ajax({
		// 				url : path+"/deletePoint/" + del_idstr,
		// 				type : "DELETE",
		// 				success : function(result) {
        //
		//
		// 					to_page(currentpage);
		// 				}
		// 			})
		// 		}
        //
		// });
		//
		
		