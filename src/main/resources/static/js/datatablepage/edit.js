//得到乡镇函数
function getPointVillage(element) {
    // 清空之前下拉列表的值
    $(element).empty();
    $.ajax({
        url :  "/listVillage",
        type : "GET",
        success : function(result) {
            $("<option></option>").append("请选择").appendTo(element);

            $.each(result, function() {


                var optiontree = $("<option></option>")
                    .append(this).attr("value", this);
                optiontree.appendTo(element);
            })
        }
    });
}

//得到树种函数
function getPointTreespecies(element) {
	// 清空之前下拉列表的值
	$(element).empty();
	$.ajax({
		url :  "/listPointTreespecies",
		type : "GET",
		success : function(result) {
			$.each(result, function() {
				
				
				var optiontree = $("<option></option>")
						.append(this.treespeciesname).attr("value", this.treespeciesid);
				optiontree.appendTo(element);
			})
		}
	});
}
// 得到生长势列表
function getPointgrowingPotential(element) {
	// 清空之前下拉列表的值
	$(element).empty();
	$.ajax({
		url : "/listPointgrowingPotential",
		type : "GET",
		success : function(result) {

			$.each(result, function() {
				var optiontree = $("<option></option>").append(this.growingpotential)
						.attr("value", this.gpid);
				optiontree.appendTo(element);
			})
		}
	});
}

function getPoint(gid) {
	$.ajax({
		url :  "/listPointBygid/" + gid,
		type : "GET",
		// data : "gid=" + gid,
		success : function(result) {

            // var gid= $("<td width='80px'></td>").append(item.gid);
            $("#pointgid_edit_input").val(result.gid);
            // var urban= $("<td width='80px'></td>").append(item.urban);
            $("#pointurban_edit_input").val(result.urban);
            // var town= $("<td width='80px'></td>").append(item.town);
            $("#pointtown_edit_input").val(result.town);
            // var village= $("<td width='80px'></td>").append(item.village);
            $("#pointvillage_edit_input").val(result.village);
            // var area= $("<td width='150px'></td>").append(item.area);
            $("#pointarea_edit_input").val(result.area);
            // var contractor= $("<td width='80px'></td>").append(item.contractor);
            $("#pointcontractor_edit_input").val(result.contractor);
            // var id= $("<td width='80px'></td>").append(item.id);
            $("#pointid_edit_input").val(result.id);

            // var visitage= $("<td width='80px'></td>").append(item.visitage+ "年");
            $("#pointvisitage_edit_input").val(result.visitage);
            // var treeage= $("<td width='80px'></td>").append(item.treeage+ "年");
            $("#pointtreeage_edit_input").val(result.treeage);
            // var treeheight= $("<td width='80px'></td>").append(item.treeheight+ "米");
            $("#pointtreeheight_edit_input").val(result.treeheight);
            // var grounddiameter= $("<td width='80px'></td>").append(item.grounddiameter+ "厘米");
            $("#pointgrounddiameter_edit_input").val(result.grounddiameter);
            // var treearea= $("<td width='80px'></td>").append(item.treearea);
            $("#pointtreearea_edit_input").val(result.treearea);


            // var recorder= $("<td width='80px'></td>").append(item.recorder);
            $("#pointrecorder_edit_input").val(result.recorder);
            // var date= $("<td width='80px'></td>").append(item.date);
            // $("#pointdate_edit_input").val(result.date);
            // var x= $("<td width='80px'></td>").append(item.x);
            $("#pointx_edit_input").val(result.x);
            // var y= $("<td width='80px'></td>").append(item.y);
            $("#pointy_edit_input").val(result.y);
            // var maintenance= $("<td width='80px'></td>").append(item.maintenance);
            $("#pointmaintenance_edit_input").val(result.maintenance);


		 

			$("#pointTreespeciesEdit_select").val([result.treespeciesvar.treespeciesid]);
			// $("#pointgrowingPotentialEdit_select").val(result.growing_potential.gpid);
			// $("#pointEditModal
			// select[name=treespecies]").val(result.treespecies);
			// $("#pointEditModal select[name=treespecies]").val('21211');
			$("#pointEditModal select[name=gpId]").val(
					[result.growingpotential.gpid]);

		}
	});
}

// +"&gid="+gid

function updatePoint(gid) {

	$.ajax({
		url :  "/updatePoint/" + gid,
		type : "PUT",
		data : $("#pointEditModal form").serialize(),
		success : function(result) {

			$("#pointEditModal").modal('hide');
			to_page(currentpage);
		}
	})
}

// 修改数据事件
$(document).on("click", ".edit_btn", function() {
	// 1.查出点信息
	// 2.查出生长势信息，并且显示生长势列表
	getPointTreespecies("#pointTreespeciesEdit_select");
	getPointgrowingPotential("#pointgrowingPotentialEdit_select");
	// /这个属性初始化在261行
	getPoint($(this).attr("edit-id"));
	$("#point_update_Btn").attr("edit-id", $(this).attr("edit-id"));
	$("#pointEditModal").modal({
		backdrop : "staticResource"
	});
	
	

});
///提交更新
$(document).on("click", "#point_update_Btn", function() {
	updatePoint($("#point_update_Btn").attr("edit-id"));

});

//批量修改
$(document).on("click", "#point_BatchEdit_modalBtn", function() {
	// 1.查出点信息
	// 2.查出生长势信息，并且显示生长势列表
	getPointTreespecies("#pointTreespeciesbatchEdit_select");
	getPointgrowingPotential("#pointgrowingPotentialbatchEdit_select");
 
 
 
	$("#pointBatchEditModal").modal({
		backdrop : "staticResource"
	});
	
	
});
function BatchupdatePoint(gids) {
	
	 $.ajax({
			url :  "/BatchupdatePoint/" + gids,
			type : "PUT",
			data : $("#pointBatchEditModal form").serialize(),
			success : function(result) {

				$("#pointBatchEditModal").modal('hide');
				to_page(currentpage);
			}
		})
}

///提交更新
$(document).on("click", "#point_Batchupdate_Btn", function() {
	var edit_idstr="";
	 $.each($(".check_item:checked"),function(){
		 
		 //alert($(this).parents("tr").find("td:eq(1)").text());
		 
		 
		 edit_idstr+=$(this).parents("tr").find("td:eq(1)").text()+"-";
		
		 
	 })
	 
	 edit_idstr=edit_idstr.substring(0, edit_idstr.length-1);
	

	BatchupdatePoint(edit_idstr);

});

