
 

function addEcharts_treespecies(echarts_contain, dataurl, title) {

	var legendx = [];
	var legendy = [];
	 

	$.ajax({
		url : dataurl,
		type : "GET",
		success : function(result) {
			$.each(result, function(index, item) {
				legendx.push(item.treecount);
				legendy.push(item.treename);
				 

			});
			var dom = document.getElementById(echarts_contain);
			var myChart = echarts.init(dom);
			var app = {};
			option = null;
			app.title = '坐标轴刻度与标签对齐';                                                                                                                                                                                                                                                                     
			option = {
				color : [ '#3398DB' ],
				tooltip : {
					trigger : 'axis',
					axisPointer : { // 坐标轴指示器，坐标轴触发有效
						type : 'shadow' // 默认为直线，可选为：'line' | 'shadow'
					}
				},
				grid : {
					// left: '3%',
					// right: '4%',
					// bottom: '3%',
					y2:140,
					containLabel : true
				},
				xAxis : [ {
					type : 'category',
					data : legendy,
					axisTick : {
						alignWithLabel : true
					},
					axisLabel : {
						show : true,
						textStyle : {
							color : 'white'
						},
                        interval:0,//横轴信息全部显示
                        rotate:-30,//-30度角倾斜显示
					}
				} ],
				yAxis : [ {
					type : 'value',
					axisLabel : {
						show : true,
						textStyle : {
							color : 'white'
						}
					}

				} ],

				series : [ {
					name : '数量(单位：棵)',
					type : 'bar',
					barWidth : '60%',
					label : {
						normal : {
							show : false,
							position : 'center'
						},
						emphasis : {
							show : true
						},

					},
					data : legendx
				} ]
			};
			if (option && typeof option === "object") {
				myChart.setOption(option, true);
			}

		}
	})

}

function addEcharts_treeage(echarts_contain, dataurl, title) {

	var legendx = [];
	var legendy = [];
	 

	$.ajax({
		url : dataurl,
		type : "GET",
		success : function(result) {
			$.each(result, function(index, item) {
				legendx.push(item.treecount);
				legendy.push(item.treeage);
				 

			});
			var dom = document.getElementById(echarts_contain);
			var myChart = echarts.init(dom);
			var app = {};
			option = null;
			app.title = '坐标轴刻度与标签对齐';                                                                                                                                                                                                                                                                     
			option = {
				color : [ '#3398DB' ],
				tooltip : {
					trigger : 'axis',
					axisPointer : { // 坐标轴指示器，坐标轴触发有效
						type : 'shadow' // 默认为直线，可选为：'line' | 'shadow'
					}
				},
				grid : {
					// left: '3%',
					// right: '4%',
					// bottom: '3%',
					y2:140,
					containLabel : true
				},
				xAxis : [ {
					type : 'category',
					data : legendy,
					axisTick : {
						alignWithLabel : true
					},
					axisLabel : {
						show : true,
						textStyle : {
							color : 'white'
						},
                        interval:0,//横轴信息全部显示
                        rotate:-30,//-30度角倾斜显示
					}
				} ],
				yAxis : [ {
					type : 'value',
					axisLabel : {
						show : true,
						textStyle : {
							color : 'white'
						}
					}

				} ],

				series : [ {
					name : '数量(单位：棵)',
					type : 'bar',
					barWidth : '60%',
					label : {
						normal : {
							show : false,
							position : 'center'
						},
						emphasis : {
							show : true
						},

					},
					data : legendx
				} ]
			};
			if (option && typeof option === "object") {
				myChart.setOption(option, true);
			}

		}
	})

}


function addEcharts_areaname(echarts_contain, dataurl, title) {

	var legendx = [];
	var legendy = [];
	 

	$.ajax({
		url : dataurl,
		type : "GET",
		success : function(result) {
			$.each(result, function(index, item) {
				legendx.push(item.treecount);
				legendy.push(item.area_name);
				 

			});
			var dom = document.getElementById(echarts_contain);
			var myChart = echarts.init(dom);
			var app = {};
			option = null;
			app.title = '坐标轴刻度与标签对齐';                                                                                                                                                                                                                                                                     
			option = {
				color : [ '#3398DB' ],
				tooltip : {
					trigger : 'axis',
					axisPointer : { // 坐标轴指示器，坐标轴触发有效
						type : 'shadow' // 默认为直线，可选为：'line' | 'shadow'
					}
				},
				grid : {
					// left: '3%',
					// right: '4%',
					// bottom: '3%',
					y2:140,
					containLabel : true
				},
				xAxis : [ {
					type : 'category',
					data : legendy,
					axisTick : {
						alignWithLabel : true
					},
					axisLabel : {
						show : true,
						textStyle : {
							color : 'white'
						},
                        interval:0,//横轴信息全部显示
                        rotate:-30,//-30度角倾斜显示
					}
				} ],
				yAxis : [ {
					type : 'value',
					axisLabel : {
						show : true,
						textStyle : {
							color : 'white'
						}
					}

				} ],

				series : [ {
					name : '数量(单位：棵)',
					type : 'bar',
					barWidth : '60%',
					label : {
						normal : {
							show : false,
							position : 'center'
						},
						emphasis : {
							show : true
						},

					},
					data : legendx
				} ]
			};
			if (option && typeof option === "object") {
				myChart.setOption(option, true);
			}

		}
	})

}



