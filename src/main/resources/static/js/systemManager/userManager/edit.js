//得到树种函数
// function getPointTreespecies(element) {
// 	// 清空之前下拉列表的值
// 	$(element).empty();
// 	$.ajax({
// 		url : path + "/listPointTreespecies",
// 		type : "GET",
// 		success : function(result) {
// 			$.each(result, function() {
//
//
// 				var optiontree = $("<option></option>")
// 						.append(this.treespeciesname).attr("value", this.treespeciesid);
// 				optiontree.appendTo(element);
// 			})
// 		}
// 	});
// }
// 得到生长势列表
function getRole(element) {
	// 清空之前下拉列表的值
	$(element).empty();
     $("<option></option>").append("系统管理")
        .attr("value", 3).appendTo(element);
    $("<option></option>").append("数据维护")
        .attr("value", 4).appendTo(element);
    $("<option></option>").append("数据查询")
        .attr("value", 5).appendTo(element);


}

function getPoint(uid) {
	$.ajax({
		url :"/findUserByUid/" + uid,
		type : "GET",
		// data : "gid=" + gid,
		success : function(result) {
console.log(result.uid);
            $("#account_edit_input").val(result.account);
			$("#password_edit_input").val(result.password);
			$("#position_edit_input").val(result.position);
			$("#email_edit_input").val(result.email);
			$("#phone_edit_input").val(result.phone);


		 

			// $("#pointTreespeciesEdit_select").val([result.treespeciesvar.treespeciesid]);
            //
			// $("#pointEditModal select[name=gpId]").val(
			// 		[result.growingpotential.gpid]);

		}
	});
}

function getRoleId(uid) {
    $.ajax({
        url :"/findRoleByUid/" + uid,
        type : "GET",
        // data : "gid=" + gid,
        success : function(result) {


            $("#userRoleEdit_select").val([result]);

            // $("#pointEditModal select[name=gpId]").val(
            // 		[result.growingpotential.gpid]);

        }
    });
}

// +"&gid="+gid

function updatePoint(uid) {

	$.ajax({
		url : "/updateUser/" + uid,
		type : "PUT",
		data : $("#pointEditModal form").serialize()+"&userid="+$("#userRoleEdit_select").val() ,
		success : function(result) {

			$("#pointEditModal").modal('hide');
			to_page(currentpage);
		}
	})
}

// 修改数据事件
$(document).on("click", ".edit_btn", function() {


	// /这个属性初始化在261行

	getPoint($(this).attr("edit-id"));
    getRole("#userRoleEdit_select");
    getRoleId($(this).attr("edit-id"));
    $("#point_update_Btn").attr("edit-id", $(this).attr("edit-id"));
	$("#pointEditModal").modal({
		backdrop : "staticResource"
	});

	

});
///提交更新
$(document).on("click", "#point_update_Btn", function() {
	updatePoint($("#point_update_Btn").attr("edit-id"));

});




