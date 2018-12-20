$(function() {


	function cesiumAdd() {
		$("#main").empty();
        var obj = $('<div id="cesiumContainer" style=" margin: 0; padding: 0; overflow: hidden;height:120%"></div>');
        var obj2 = $(' <div id="creditContainer" style="display: none;"></div>');




         $("#main").append(obj);
        $("#main").append(obj2);
	 	  initialGlobeView();
     // showtest();
	}

	function datatableListAdd() {
		$("#main").empty();

		var obj = $('<div ><iframe src = "/datatablepageList" style="width:100%;height:1200px"  frameborder="0"></iframe></div>');
		$("#main").append(obj);

	}

    function userManagerListAdd() {
        $("#main").empty();

        var obj = $('<div ><iframe src = "/userManagerList" style="width:100%;height:1200px"  frameborder="0"></iframe></div>');
        $("#main").append(obj);

    }
    function showCompanyInformation(){
        layer.open({
            title: '公司信息'
            ,content: '北京环球森林科技有限公司是专业从事林业信息化，以地理信息系统集成、软件开发、数据生产、GIS咨询与服务为一体的高新技术企业。 公司在自主技术的基础上，与北京林业大学测绘与3S技术中心、广州南方测绘仪器有限公司深度合作，致力林业信息化软硬件产品科技成果的产品转化和市场推广。 公司集成GIS技术、航空摄影测量技术、地面测量技术、遥感技术，以国内最顶尖的森林调查技术为发展目标，致力于林业数据采集、林业资源管理、林业灾害监控与应急管理产品研发，研发高精度、高效率、易操作的森林调查外业硬件和配套的内业软件，为林业行业提供了从移动端、Web端桌面端、服务器端的完整解决方案，实实在在的提升林业信息化的工作效率、效益和效果。'
        });


	}


    function statisticsindex_treespeciesAdd() {
        $("#main").empty();

        var obj = $('<div ><iframe src = "/ToStatistics_treespecies" style="width:100%;height:1200px"  frameborder="0"></iframe></div>');
        $("#main").append(obj);

    }
    function statisticsindex_treeageAdd() {
        $("#main").empty();

        var obj = $('<div ><iframe src = "/ToTreeStatistics_treeage" style="width:100%;height:1200px"  frameborder="0"></iframe></div>');
        $("#main").append(obj);

    }
    function statisticsindex_areanameAdd() {
        $("#main").empty();

        var obj = $('<div ><iframe src = "/ToTreeStatistics_town" style="width:100%;height:1200px"  frameborder="0"></iframe></div>');
        $("#main").append(obj);

    }



	$(document).on("click", "#cesiumLoad_a", function() {

		cesiumAdd();

	});
	$(document).on("click", "#datatableLoad_a", function() {


        datatableListAdd();

    });

    $(document).on("click", "#user_manager_a", function() {


        userManagerListAdd();

    });


    $(document).on("click", "#CompanyInformation", function() {


        showCompanyInformation();

    });
    $(document).on("click", "#species_statistics_a", function() {


        statisticsindex_treespeciesAdd();

    });
    $(document).on("click", "#area_statistics_a", function() {


        statisticsindex_areanameAdd();

    });
    $(document).on("click", "#age_statistics_a", function() {


        statisticsindex_treeageAdd();

    });





})