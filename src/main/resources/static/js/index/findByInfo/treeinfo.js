
function findByAge() {

	$.ajax({
		url : "/listPointBytreeage",
		type : "GET",
		data : $("#findByage_form").serialize(),
		success : function(result) {

			if (result.length != 0) {
				addPoint(result);
			} else {

				showerror();
			}
		}
	})
}

function findByTreeHeight() {

	$.ajax({
		url : "/listPointBytreeheight",
		type : "GET",
		data : $("#findBytreeheight_form").serialize(),
		success : function(result) {

			if (result.length != 0) {
				addPoint(result);
			} else {

				showerror();
			}

		}
	})
}

function findByContractor() {

	$.ajax({
		url : "/listPointBycontractor/" + $("#contractor").val(),
		type : "GET",

		success : function(result) {

			if (result.length != 0) {
				addPoint(result);
			} else {

				showerror();
			}

		}
	})
}

function list_select_treespecies() {

	$.ajax({
		url : "/listtreespecies",
		type : "GET",
		success : function(result) {

			$("#treespecies_select").empty();
			$.each(result, function(index, item) {
				$("<option></option>").append(item).appendTo(
						"#treespecies_select");

			});

		}
	})
}
function findBytreespecies() {

	$.ajax({
		url : "/listPointBytreespecies/"
				+ $("#treespecies_select").children('option:selected').val(),

		type : "GET",

		success : function(result) {
			// $("#select_branch").empty();
			// $.each(result, function(index, item) {
			// $("<option></option>").append(item).appendTo("#select_branch");
			//
			// });

			if (result.length != 0) {
				addPoint(result);
			} else {

				showerror();
			}

		}
	})
}

function findById() {

    $.ajax({
        url : "/listPointById",

        data : $("#findBygid_form").serialize(),
        type : "GET",

        success : function(result) {
            // $("#select_branch").empty();
            // $.each(result, function(index, item) {
            // $("<option></option>").append(item).appendTo("#select_branch");
            //
            // });

            if (result.length != 0) {
                addPoint(result);
            } else {

                showerror();
            }

        }
    })
}

function findByArea() {

    $.ajax({
        url : "/listPointByArea",
        data : $("#findByarea_form").serialize(),
        type : "GET",

        success : function(result) {

            if (result.length != 0) {
                addPoint(result);
            } else {

                showerror();
            }

        }
    })
}

$(function() {
	$(document).on("click", "#findBytreeage_a", function() {
		showLayerOpen_treeage();

	});

	$(document).on("click", "#findBytreeheight_a", function() {
		showLayerOpen_treeheight();

	});

	$(document).on("click", "#findBycontractor_a", function() {
		showLayerOpen_contractor();

	});
	$(document).on("click", "#findBytreespecies_a", function() {
		showLayerOpen_treespecies();
		list_select_treespecies();

	});

    $(document).on("click", "#findBygid_a", function() {

        showLayerOpen_id();

    });

    $(document).on("click", "#findByarea_a", function() {

        showLayerOpen_area();

    });

});
