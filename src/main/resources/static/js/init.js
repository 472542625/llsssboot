// cesium初始化参数
 var geoserverserverpath = "http://localhost:8185";
//var geoserverserverpath = "http://localhost:8085";
//var geoserverserverpath = "http://172.25.13.95:8085";
var center = [ 116.23954075189744, 39.554053791246574 ];


var treeshplayer;
function add_daxing() {
    ///切片底图
    viewer.imageryLayers
        .addImageryProvider(new Cesium.UrlTemplateImageryProvider(
            {
                url : "/staticResource/data/tile/{z}/{x}/{y}.png",
               // minimumLevel : 12,

                maximumLevel : 18
                // 根据数据调整，最大18
            }));
	// 梨园乡镇矢量图
    var daxing_xiangzheng_shplayer = new Cesium.WebMapServiceImageryProvider({
		url : geoserverserverpath + '/geoserver/' + 'forest' + '/wms',
		layers : "forest:daxing_xiangzheng_shp",
		parameters : {
			format : 'image/png',
			transparent : true,
		}
	});
	var daxing_xiangzheng_shplayerImagerylayerName = new Cesium.ImageryLayer(
			daxing_xiangzheng_shplayer);
	viewer.imageryLayers.add(daxing_xiangzheng_shplayerImagerylayerName);

	// 梨园矢量图
     treeshplayer = new Cesium.WebMapServiceImageryProvider({
		url : geoserverserverpath + '/geoserver/' + 'forest' + '/wms',
		layers : "forest:tree",

		parameters : {
			format : 'image/png',
			transparent : true,
		}
	});
	var shplayerImagerylayerName = new Cesium.ImageryLayer(treeshplayer);
	viewer.imageryLayers.add(shplayerImagerylayerName);

}

$(document)
		.ready(
				function() {
					// viewer初始化
					initialGlobeView();
					// 左下角三维信息显示
					//showCartesian3();


					$("#lengthMeasurement").click(function() {
						clearEffects();
						SetMode("drawLine");

					});
					$("#areaMeasurement").click(function() {
						clearEffects();
						SetMode("drawPloy");

					});
					$("#clearMeasurement").click(function() {
						clearViewerEntities();

					});




					// 底图图层选择

					$("#a_localtile")
							.click(
									function() {

										$("#online_map").text("本地地图");
										viewer.imageryLayers.removeAll(false);

										viewer.imageryLayers
												.addImageryProvider(new Cesium.UrlTemplateImageryProvider(
														{
															url : "/staticResource/data/tile/{z}/{x}/{y}.png",
															maximumLevel : 18
														// 根据数据调整，最大18
														}));
										viewer.imageryLayers
												.addImageryProvider(label_googleSource);
										add_daxing();
									});
					$("#a_google")
							.click(
                    
									function() {
										$("#online_map").text("谷歌地图");
										viewer.imageryLayers.removeAll(false);

										viewer.imageryLayers
												.addImageryProvider(new Cesium.UrlTemplateImageryProvider(
														{
															url : 'http://mt{s}.google.cn/vt/lyrs=s&hl=zh-CN&gl=CN&x={x}&y={y}&z={z}&s=Gali',
															subdomains : [ '1',
																	'2', '3' ],
															maximumLevel : 18
														}));

										viewer.imageryLayers
												.addImageryProvider(label_googleSource);
										add_daxing();
									});

					$("#a_3d")
							.click(
									function() {
										$("#online_map").text("三维地形");
										var terrainProvider = new Cesium.CesiumTerrainProvider(
												{
													url : 'https://assets.agi.com/stk-terrain/v1/tilesets/world/tiles',
													requestVertexNormals : true,
													requestWaterMask : true
												});

										viewer.terrainProvider = terrainProvider;
										viewer.scene.globe.enableLighting = false;
										add_daxing();
									});

					$(".homeView").click(
							function() {

								viewer.camera.flyTo({
									destination : Cesium.Cartesian3
											.fromDegrees(116.23812584814823,
													39.56892684177221, 4000)
								});

							})


				})


// Viewer初始化
function initialGlobeView() {

	// 在线地图底图
	// imageryProvider = new Cesium.UrlTemplateImageryProvider({
	// url:
	// 'http://mt{s}.google.cn/vt/lyrs=s&hl=zh-CN&gl=CN&x={x}&y={y}&z={z}&s=Gali',
	// subdomains: ['1', '2', '3'],
	// maximumLevel: 18
	// });

    // imageryProvider = new Cesium.UrlTemplateImageryProvider({
    //     url: "data/tile/{z}/{x}/{y}.png",
    //     maximumLevel: 18 //根据数据调整，最大18
    // });
	var imageryProvider = new Cesium.UrlTemplateImageryProvider(
			{
				url : 'http://mt0.google.cn/vt/lyrs=s@702&hl=zh-CN&gl=cn&x={x}&y={y}&z={z}&s=Ga',
				credit : ''
			});

	viewer = new Cesium.Viewer('cesiumContainer', {

		homeButton : false,
		sceneModePicker : true,
		fullscreenButton : false,
		vrButton : false,
		baseLayerPicker : false,
		animation : false,


		timeline : false,

		geocoder : false,
		navigationHelpButton : false,
		navigationInstructionsInitiallyVisible : false,
		mapProjection : new Cesium.WebMercatorProjection(),
		 imageryProvider : imageryProvider,
	// terrainProvider: terrainProvider //有时候访问不了高程数据，可暂时注释掉或者访问离线数据
       creditContainer: "creditContainer",
        selectionIndicator : true,
        infoBox : false,

	});


	viewer._cesiumWidget._creditContainer.style.display = "none";	//cesiumlogo去掉


	var layers = viewer.scene.imageryLayers;
   //谷歌中文标注
    var label_googleSource = new Cesium.UrlTemplateImageryProvider(
        {
            url : 'http://mt0.google.cn/vt/imgtp=png32&lyrs=h@365000000&hl=zh-CN&gl=cn&x={x}&y={y}&z={z}&s=Galil',
            credit : ''
        });
	layers.addImageryProvider(label_googleSource);
	add_daxing();
	viewer.camera.setView({
		destination : Cesium.Cartesian3.fromDegrees(116.469424797531,
				39.32320241182453, 100000),
		orientation : {
			heading : 0, // 左右偏移
			pitch : 30, // 上下偏移
			roll : 0
		}
	});
  showtest();



}

////添加获取地面三维点坐标的事件函数
function showCartesian3() {

	var scene = viewer.scene;

	handler = new Cesium.ScreenSpaceEventHandler(scene.canvas);

	var handler = new Cesium.ScreenSpaceEventHandler(scene.canvas);
	handler.setInputAction(function(evt) {
		var ray = viewer.camera.getPickRay(evt.position);
		var cartesian = viewer.scene.globe.pick(ray, viewer.scene);
		var cartographic = Cesium.Cartographic.fromCartesian(cartesian);
		var lng = Cesium.Math.toDegrees(cartographic.longitude); // 经度值
		var lat = Cesium.Math.toDegrees(cartographic.latitude); // 纬度值
		// height结果与cartographic.height相差无几，注意：cartographic.height可以为0，也就是说，可以根据经纬度计算出高程。
		var height = viewer.scene.globe.getHeight(cartographic);
		var mapPosition = {
			x : lng,
			y : lat,
			z : height.height
		}; // height的值为地形高度。
		console.log("笛卡尔空间坐标系：X:" + cartesian.x + "m,Y:" + cartesian.y + "m,Z:"
				+ cartesian.z + "m");
		console.log("WGS84地理坐标系：经度:" + lng + ",纬度:" + lat
				+ ",cartographic.height:" + cartographic.height + "m");
	}, Cesium.ScreenSpaceEventType.LEFT_CLICK);

	// 鼠标监听事件
	handler.setInputAction(
			function(movement) {
				var cartesian = scene.camera.pickEllipsoid(
						movement.endPosition, scene.globe.ellipsoid);
				if (cartesian) {
					// cartographic（WGS84）经纬度的弧度表示
					var cartographic = scene.globe.ellipsoid
							.cartesianToCartographic(cartesian);
					// cartographic（WGS84）经纬度的单位弧度转为单位经纬度
					var longitudeString = Cesium.Math
							.toDegrees(cartographic.longitude);
					var latitudeString = Cesium.Math
							.toDegrees(cartographic.latitude);
					var heightString = cartographic.height;

					// 另外一种拿高程的方法
					// var ray = viewer.camera.getPickRay(movement.endPosition);
					// var cartesian1 = viewer.scene.globe.pick(ray,
					// viewer.scene);
					// var cartographic1 =
					// Cesium.Cartographic.fromCartesian(cartesian1);
					// $("#Cartesian3 span:eq(0)").text("笛卡尔空间坐标系：X:" +
					// cartesian.x + "m,Y:" + cartesian.y + "m,Z:" + cartesian.z
					// + "m");
					// $("#Cartesian3 span:eq(1)").text("WGS84地理坐标系：经度:" +
					// longitudeString + " 纬度:" +
					// latitudeString+"高程:"+cartographic1.height);
					$("#Cartesian3 span:eq(1)").text(
							"WGS84地理坐标系：经度:" + longitudeString + "    纬度:"
									+ latitudeString);
					// $("#Cartesian3
					// span:eq(0)").text(viewer.camera.orientation.roll);
				}

				// MOUSE_MOVE
			}, Cesium.ScreenSpaceEventType.MOUSE_MOVE);

}
// getPolygonAreaCenter的辅助函数
function Area(p0, p1, p2) {
	var area = 0.0;
	area = p0.lon * p1.lat + p1.lon * p2.lat + p2.lon * p0.lat - p1.lon
			* p0.lat - p2.lon * p1.lat - p0.lon * p2.lat;
	return area / 2;
}
// line 249 计算polygon的质心
function getPolygonAreaCenter(points) {
	var sum_x = 0;
	var sum_y = 0;
	var sum_area = 0;
	var p1 = points[1];
	var returnpoint = [];
	debugger;
	for (var i = 2; i < points.length; i++) {
		p2 = points[i];
		area = Area(points[0], p1, p2);
		sum_area += area;
		sum_x += (points[0].lon + p1.lon + p2.lon) * area;
		sum_y += (points[0].lat + p1.lat + p2.lat) * area;
		p1 = p2;
	}
	var xx = sum_x / sum_area / 3;
	var yy = sum_y / sum_area / 3;
	returnpoint.push({
		lon : xx,
		lat : yy
	});

	return returnpoint;
}

function clearEffects() {
	/**
	 * [clearEffects handler监听销毁]
	 * 
	 * @return {[type]} [description]
	 */
	if (handler != null) {
		handler.destroy();
	}
}

// 设置各种操作模式
function SetMode(mode) {
	if (mode == "drawPloy") {
		tempPoints = [];
		handler = new Cesium.ScreenSpaceEventHandler(scene.canvas);
		handler.setInputAction(
				function(click) {
					var cartesian = viewer.camera.pickEllipsoid(click.position,
							scene.globe.ellipsoid);
					if (cartesian) {
						var cartographic = Cesium.Cartographic
								.fromCartesian(cartesian);
						var longitudeString = Cesium.Math
								.toDegrees(cartographic.longitude);
						var latitudeString = Cesium.Math
								.toDegrees(cartographic.latitude);
						tempPoints.push({
							lon : longitudeString,
							lat : latitudeString
						});
						var tempLength = tempPoints.length;
						drawPoint(tempPoints[tempPoints.length - 1]);
						if (tempLength > 1) {
							drawLine(tempPoints[tempPoints.length - 2],
									tempPoints[tempPoints.length - 1], true);
						}
					}
				}, Cesium.ScreenSpaceEventType.LEFT_CLICK);

		handler.setInputAction(function(click) {
			var cartesian = viewer.camera.pickEllipsoid(click.position,
					scene.globe.ellipsoid);
			if (cartesian) {
				var tempLength = tempPoints.length;
				if (tempLength < 3) {
					alert('请选择3个以上的点再执行闭合操作命令');
				} else {
					drawLine(tempPoints[0], tempPoints[tempPoints.length - 1],
							true);
					drawPoly(tempPoints, true);
					// highLightAssetsInArea(tempPoints);
					// alert('多边形面积' + SphericalPolygonAreaMeters(tempPoints) +
					// '平方米');
					tempPoints = []; // //右击结束画图并且清空存储点的数组tempPoints
				}

			}
			// 画完了清除画图操作
			if (handler != null) {
				handler.destroy();
			}
		}, Cesium.ScreenSpaceEventType.RIGHT_CLICK);
	} else if ("drawLine" == mode) {
		tempPoints = [];
		handler = new Cesium.ScreenSpaceEventHandler(scene.canvas);
		handler.setInputAction(
				function(click) {
					var cartesian = viewer.camera.pickEllipsoid(click.position,
							scene.globe.ellipsoid);
					if (cartesian) {
						var cartographic = Cesium.Cartographic
								.fromCartesian(cartesian);
						var longitudeString = Cesium.Math
								.toDegrees(cartographic.longitude);

						var latitudeString = Cesium.Math
								.toDegrees(cartographic.latitude);
						tempPoints.push({
							lon : longitudeString,
							lat : latitudeString
						});
						var tempLength = tempPoints.length;

						drawPoint(tempPoints[tempPoints.length - 1]);
						if (tempLength > 1) {
							drawLine(tempPoints[tempPoints.length - 2],
									tempPoints[tempPoints.length - 1], true);
						}
					}
				}, Cesium.ScreenSpaceEventType.LEFT_CLICK);

		// 移动
		// handler.setInputAction(function(movement) {
		// var cartesian = scene.camera.pickEllipsoid(movement.endPosition,
		// scene.globe.ellipsoid);
		// if (tempPoints.length >1) {
		// //判断如果poly没有被定义的话初始化poly
		// drawLine(tempPoints[tempPoints.length - 1], cartesian, true);
		// //判断如果poly被初始化的话

		// tempPoints.pop();
		// cartesian.y += (1 + Math.random());
		// tempPoints.push(cartesian);

		// }
		// }, Cesium.ScreenSpaceEventType.MOUSE_MOVE);
		// 右击
		handler.setInputAction(function(click) {
			tempPoints = [];
			// 画完了清除画图操作
			if (handler != null) {
				handler.destroy();
			}

		}, Cesium.ScreenSpaceEventType.RIGHT_CLICK);
	} else if ("drawCircle" == mode) {
		tempPoints = [];
		handler = new Cesium.ScreenSpaceEventHandler(scene.canvas);
		handler
				.setInputAction(
						function(click) {
							var cartesian = viewer.camera.pickEllipsoid(
									click.position, scene.globe.ellipsoid);
							if (cartesian) {
								var cartographic = Cesium.Cartographic
										.fromCartesian(cartesian);
								var longitudeString = Cesium.Math
										.toDegrees(cartographic.longitude);
								var latitudeString = Cesium.Math
										.toDegrees(cartographic.latitude);
								tempPoints.push({
									lon : longitudeString,
									lat : latitudeString
								});
								var tempLength = tempPoints.length;
								if (tempLength == 1) {
									drawPoint(tempPoints[0]);
								} else if (tempLength == 2) {
									drawPoint(tempPoints[1]);
									drawLine(tempPoints[0], tempPoints[1], true);
									// 算两点间距离
									var distance = getFlatternDistance(
											tempPoints[0].lat,
											tempPoints[0].lon,
											tempPoints[1].lat,
											tempPoints[1].lon);

									var entity = viewer.entities.add({
										position : Cesium.Cartesian3
												.fromDegrees(tempPoints[0].lon,
														tempPoints[0].lat),
										ellipse : {
											semiMinorAxis : distance,
											semiMajorAxis : distance,
											height : 0,
											material : Cesium.Color
													.fromRandom({
														alpha : 0.8
													})
										}
									});
									tempEntities.push(entity);

									// 高亮圈内模型
									for (var i = 0; i < loadedModels.length; i++) {
										for (var j = 0; j < models.length; j++) {
											if (loadedModels[i].id == models[j].id
													&& getFlatternDistance(
															models[j].lat,
															models[j].lon,
															tempPoints[0].lat,
															tempPoints[0].lon) <= distance) {
												loadedModels[i].color = Cesium.Color.SPRINGGREEN;
											}
										}
									}

									// 面积
									setTimeout(function() {
										alert("面积是 " + Math.PI * distance
												* distance + "平方米")
									}, 500);

									tempPoints = [];
								}
							}
						}, Cesium.ScreenSpaceEventType.LEFT_CLICK);
	} else if ("drawSquare" == mode) {
		tempPoints = [];
		handler = new Cesium.ScreenSpaceEventHandler(scene.canvas);
		handler
				.setInputAction(
						function(click) {
							var cartesian = viewer.camera.pickEllipsoid(
									click.position, scene.globe.ellipsoid);
							if (cartesian) {
								var cartographic = Cesium.Cartographic
										.fromCartesian(cartesian);
								var longitudeString = Cesium.Math
										.toDegrees(cartographic.longitude);
								var latitudeString = Cesium.Math
										.toDegrees(cartographic.latitude);
								tempPoints.push({
									lon : longitudeString,
									lat : latitudeString
								});
								var tempLength = tempPoints.length;
								if (tempLength == 1) {
									drawPoint(tempPoints[0]);
								} else if (tempLength == 2) {
									// 算两点间距离
									var distance = getFlatternDistance(
											tempPoints[0].lat,
											tempPoints[0].lon,
											tempPoints[1].lat,
											tempPoints[1].lon);

									var entity = viewer.entities.add({
										position : Cesium.Cartesian3
												.fromDegrees(tempPoints[0].lon,
														tempPoints[0].lat),
										ellipse : {
											semiMinorAxis : distance,
											semiMajorAxis : distance,
											height : 0,
											material : Cesium.Color
													.fromRandom({
														alpha : 0.8
													})
										}
									});
									tempEntities.push(entity);

									// 高亮圈内模型
									for (var i = 0; i < loadedModels.length; i++) {
										for (var j = 0; j < models.length; j++) {
											if (loadedModels[i].id == models[j].id
													&& getFlatternDistance(
															models[j].lat,
															models[j].lon,
															tempPoints[0].lat,
															tempPoints[0].lon) <= distance) {
												loadedModels[i].color = Cesium.Color.SPRINGGREEN;
											}
										}
									}

									tempPoints = [];
								}
							}
						}, Cesium.ScreenSpaceEventType.LEFT_CLICK);
	}
}
// 画图
var tempPoints = []; // 画线、面的时候初始化点数组
var tempEntities = [];
var tempPolygonEntities = [];
function drawPoint(point) {
	var entity = viewer.entities.add({
		position : Cesium.Cartesian3.fromDegrees(point.lon, point.lat),
		point : {
			pixelSize : 10,
			color : Cesium.Color.CHARTREUSE
		}
	});
	tempEntities.push(entity);
}

function drawLine(point1, point2, showDistance) {
	var entity = viewer.entities.add({
		polyline : {
			positions : [
					Cesium.Cartesian3.fromDegrees(point1.lon, point1.lat),
					Cesium.Cartesian3.fromDegrees(point2.lon, point2.lat) ],
			width : 10.0,
			material : new Cesium.PolylineGlowMaterialProperty({
				color : Cesium.Color.CHARTREUSE.withAlpha(.5)
			})
		}
	});
	tempEntities.push(entity);

	// 展示距离
	if (showDistance) {
		var w = Math.abs(point1.lon - point2.lon);
		var h = Math.abs(point1.lat - point2.lat);
		var offsetV = w >= h ? 0.0005 : 0;
		var offsetH = w < h ? 0.001 : 0;
		var distance = getFlatternDistance(point1.lat, point1.lon, point2.lat,
				point2.lon);

		entity = viewer.entities.add({
			position : Cesium.Cartesian3.fromDegrees(
					((point1.lon + point2.lon) / 2) + offsetH,
					((point1.lat + point2.lat) / 2) + offsetV),
			label : {
				text : distance.toFixed(1) + 'm',
				font : '22px Helvetica',
				fillColor : Cesium.Color.DARKBLUE
			}
		});
		tempEntities.push(entity);
	}
}

function drawPoly(points, showArea) {
	var pArray = [];
	for (var i = 0; i < points.length; i++) {
		pArray.push(points[i].lon);
		pArray.push(points[i].lat);
	}
	var entity = viewer.entities.add({
		polygon : {
			hierarchy : new Cesium.PolygonHierarchy(Cesium.Cartesian3
					.fromDegreesArray(pArray)),
			material : Cesium.Color.CHARTREUSE.withAlpha(.5)
		}
	});
	tempPolygonEntities.push(entity);

	// 展示面积
	if (showArea) {
		// 得到多边形质心
		var polygoncenterpoint = getPolygonAreaCenter(points);

		// 得到多边形的面积
		var area = SphericalPolygonAreaMeters(points);
		entity = viewer.entities.add({
			// position:PolygonAreaCenterPoint,
			position : Cesium.Cartesian3.fromDegrees(polygoncenterpoint[0].lon,
					polygoncenterpoint[0].lat),
			// position: Cesium.Cartesian3.fromDegrees(points[0].lon,
			// points[0].lat),
			label : {
				text : area.toFixed(1) + '平方米',
				font : '22px Helvetica',
				fillColor : Cesium.Color.DARKBLUE
			}
		});
		tempEntities.push(entity);
	}
}


// 计算两点间距离
function getFlatternDistance(lat1, lng1, lat2, lng2) {
	var EARTH_RADIUS = 6378137.0; // 单位M
	var PI = Math.PI;

	function getRad(d) {
		return d * PI / 180.0;
	}
	var f = getRad((lat1 + lat2) / 2);
	var g = getRad((lat1 - lat2) / 2);
	var l = getRad((lng1 - lng2) / 2);

	var sg = Math.sin(g);
	var sl = Math.sin(l);
	var sf = Math.sin(f);

	var s, c, w, r, d, h1, h2;
	var a = EARTH_RADIUS;
	var fl = 1 / 298.257;

	sg = sg * sg;
	sl = sl * sl;
	sf = sf * sf;

	s = sg * (1 - sl) + (1 - sf) * sl;
	c = (1 - sg) * (1 - sl) + sf * sl;

	w = Math.atan(Math.sqrt(s / c));
	r = Math.sqrt(s * c) / w;
	d = 2 * w * a;
	h1 = (3 * r - 1) / 2 / c;
	h2 = (3 * r + 1) / 2 / s;

	return d * (1 + fl * (h1 * sf * (1 - sg) - h2 * (1 - sf) * sg));
}

// 计算多边形面积


function SphericalPolygonAreaMeters(points) {
    var earthRadiusMeters = 6371000.0;
    var radiansPerDegree = Math.PI / 180.0;


	var totalAngle = 0;
	for (var i = 0; i < points.length; i++) {
		var j = (i + 1) % points.length;
		var k = (i + 2) % points.length;
		totalAngle += Angle(points[i], points[j], points[k]);
	}
	var planarTotalAngle = (points.length - 2) * 180.0;
	var sphericalExcess = totalAngle - planarTotalAngle;
	if (sphericalExcess > 420.0) {
		totalAngle = points.length * 360.0 - totalAngle;
		sphericalExcess = totalAngle - planarTotalAngle;
	} else if (sphericalExcess > 300.0 && sphericalExcess < 420.0) {
		sphericalExcess = Math.abs(360.0 - sphericalExcess);
	}
	return sphericalExcess * radiansPerDegree * earthRadiusMeters
			* earthRadiusMeters;
}

// /*角度*/计算面积需要用到
function Angle(p1, p2, p3) {
	var bearing21 = Bearing(p2, p1);
	var bearing23 = Bearing(p2, p3);
	var angle = bearing21 - bearing23;
	if (angle < 0) {
		angle += 360;
	}
	return angle;
}
// /*方向*/计算角度用得到
function Bearing(from, to) {

    var radiansPerDegree = Math.PI / 180.0;
    var degreesPerRadian = 180.0 / Math.PI;
	var lat1 = from.lat * radiansPerDegree;
	var lon1 = from.lon * radiansPerDegree;
	var lat2 = to.lat * radiansPerDegree;
	var lon2 = to.lon * radiansPerDegree;
	var angle = -Math.atan2(Math.sin(lon1 - lon2) * Math.cos(lat2), Math
			.cos(lat1)
			* Math.sin(lat2)
			- Math.sin(lat1)
			* Math.cos(lat2)
			* Math.cos(lon1 - lon2));
	if (angle < 0) {
		angle += Math.PI * 2.0;
	}
	angle = angle * degreesPerRadian;
	return angle;
}

function flyTohomeview() {

	viewer.camera.flyTo({
		destination : Cesium.Cartesian3.fromDegrees(116.23812584814823,
				39.56892684177221, 4000)
	});

}
function clearViewerEntities() {
	viewer.entities.removeAll();
}


function findTreespeciesByTreeid(treeid){

	var Treespecies;
    $.ajax({
        url :  "/findTreespeciesByTreeid",
        type : "GET",
         data : "treeid=" + treeid,
        success : function(result) {

              Treespecies = result;


        }
    });

    return Treespecies;

}

function showtest(){
    var TooltipDiv = (function () {
        var isInit = false;


        function _() { };

        _.initTool = function (frameDiv) {
            if (isInit) { return; }

            var div = document.createElement('DIV');
            div.className = "tooltipdiv right";//

            var arrow = document.createElement('DIV');
            arrow.className = "tooltipdiv-arrow";
            div.appendChild(arrow);

            var title = document.createElement('DIV');
            title.className = "tooltipdiv-inner";
            div.appendChild(title);

            this._div = div;
            this._title = title;

            frameDiv.appendChild(div);

            isInit = true;
        }

        _.setVisible = function (visible) {
            if (!isInit) { return; }
            this._div.style.display = visible ? 'block' : 'none';
        };

		/*
		 position屏幕坐标
		 显示在屏幕上
		 */
        _.showAt = function (position, message) {
            if (!isInit) { return; }
            if (position && message) {
                this.setVisible(true);
                this._title.innerHTML = message;
                this._div.style.left = position.x + 10 + "px";
                this._div.style.top = (position.y - this._div.clientHeight / 2) + "px";
            }
        };

        return _;
    })();



    viewer.cesiumWidget.screenSpaceEventHandler.removeInputAction(Cesium.ScreenSpaceEventType.LEFT_DOUBLE_CLICK);
    var scene = viewer.scene;
    var handler = new Cesium.ScreenSpaceEventHandler(scene.canvas);
    var ellipsoid = scene.globe.ellipsoid;
    var cartesian = null;

    TooltipDiv.initTool(viewer.cesiumWidget.container);
    //一 鼠标MOUSE_MOVE
    // handler.setInputAction(function (movement) {
    //     cartesian = viewer.camera.pickEllipsoid(movement.endPosition, ellipsoid);
    //     if (cartesian) {
    //         TooltipCesium.showAt(movement.endPosition, 'MOUSE_MOVE');
    //     } else {
    //         TooltipCesium.setVisible(false);
    //     }
    // }, Cesium.ScreenSpaceEventType.MOUSE_MOVE);
    //二 LEFT_CLICK
    handler.setInputAction(function (movement) {

        cartesian = viewer.camera.pickEllipsoid(movement.position, ellipsoid);
      //  console.log(cartesian);
        if (cartesian) {
            var cartographic = Cesium.Cartographic.fromCartesian(cartesian);
            // console.log("cartographic:"+cartographic);
            // TooltipCesium.showAt(movement.position, 'LEFT_CLICK');
            var xy = new Cesium.Cartesian2();
            var alti = viewer.camera.positionCartographic.height;
            var level = getLevel(alti);
           // console.log(level);
            xy = treeshplayer.tilingScheme.positionToTileXY(cartographic, level, xy);
            var promise = treeshplayer.pickFeatures(xy.x, xy.y, level, cartographic.longitude, cartographic.latitude);
          //  console.log(  promise);
            var treespeciesid=1;

            Cesium.when(promise, function (data) {


                if (data && data.length > 0) {

                    treespeciesid =  data[0].properties.treespecies_id;


                	var gp="";
                	if(data[0].properties.gp_id==0){
                               gp="好";
					}
						else if(data[0].properties.gp_id==1){
                        gp="较好";
                    }
                    else if(data[0].properties.gp_id==2){
                        gp="一般";
                    }
                    else if(data[0].properties.gp_id==3){
                        gp="差";
                    }
                    else if (data[0].properties.gp_id==4)
					{
                        gp="死树";
                    }

                    var info =         "<table style='background-color: black;border-color:white;border:1px ;width: 300px;'>\
<tr style='background-color: black ;color:white;'>\
<td>区</td>\
<td>"
                    + data[0].properties.urban
                    + "</td>\
</tr>"
                    + "<tr style='background-color: black ;color:white;'>\
<td>乡镇</td>\
<td>"
                    + data[0].properties.town
                    + "</td>\
</tr>"
                    + "<tr style='background-color: black ;color:white;'>\
<td>村</td>\
<td>"
                    + data[0].properties.village
                    + "</td>\
</tr>"
                    + "<tr style='background-color: black ;color:white;'>\
<td>位置</td>\
<td>"
                    + data[0].properties.area

                    + "</td>\
</tr>"
                    + "<tr style='background-color: black ;color:white;'>\
<td>承包人</td>\
<td>"
                    + data[0].properties.contractor

                    + "</td>\
</tr>"
                    + "<tr style='background-color: black ;color:white;'>\
<td>标牌编号</td>\
<td>"
                    + data[0].properties.id

                    + "</td>\
</tr>"
                    + "<tr style='background-color: black ;color:white;'>\
<td>果树品种</td>\
<td>"
                    + data[0].properties.treespecies

                    + "</td>\
</tr>"
                    + "<tr style='background-color: black ;color:white;'>\
<td>访问树龄</td>\
<td>"
                    + data[0].properties.visitage
                    + "</td>\
</tr>"
                    + "<tr style='background-color: black ;color:white;'>\
<td>调查树龄</td>\
		          <td>"
                    + data[0].properties.treeage + "年"
                    + "</td>\
</tr>"
                    + "<tr style='background-color: black ;color:white;'>\
				 <td>树高</td>\
		          <td>"
                    + data[0].properties.treeheight + "米"
                    + "</td>\
	</tr>"
                    + "<tr style='background-color: black ;color:white;'>\
	<td>地径</td>\
	<td>"
                    + data[0].properties.grounddiameter+"厘米"
                    + "</td>\
	</tr>" + "<tr style='background-color: black ;color:white;'>\
	<td>冠幅</td>\
	<td>"
                    + data[0].properties.treearea+"平方米"
                    + "</td>\
	</tr>" + "<tr style='background-color: black ;color:white;'>\
	<td>生长势</td>\
	<td>"
                    + gp
                    + "</td>\
	</tr>" + "<tr style='background-color: black ;color:white;'>\
	<td>记录人</td>\
	<td>"
                    + data[0].properties.recorder
                    + "</td>\
	</tr>"

                    + "<tr style='background-color: black ;color:white;'>\
	<td>经度</td>\
	<td>"
                    + data[0].properties.x
                    + "</td>\
	</tr>"
                    + "<tr style='background-color: black ;color:white;'>\
	<td>纬度</td>\
	<td>"
                    + data[0].properties.y
                    + "</td>\
	</tr>"
                    + "<tr style='background-color: black ;color:white;'>\
	<td>维护情况</td>\
	<td>"
                    +" "
                    + "</td>\
	</tr>"
                    //	+ "<tr style='background-color: black ;color:white;'>\
//	<td>图像展示</td>\
                    //<td><img style='height:200px;width:150px' src="+  treeimgpath+" /></td>\
                    //</tr>"


                    + "</table>";

                    TooltipDiv.showAt(movement.position,info);

					}
					else{
                    TooltipDiv.setVisible(false);

                }
                });

         //   console.log(treespeciesid);
           var treespecies = findTreespeciesByTreeid(treespeciesid);
         //  console.log(treespecies);

        }
        else {
            TooltipDiv.setVisible(false);

        }


        var pick = viewer.scene.pick(movement.position);

        if (Cesium.defined(pick)) {
           // console.log("pick1："+pick.id.description);


        }

		}, Cesium.ScreenSpaceEventType.LEFT_CLICK);

    //三 LEFT_DOUBLE_CLICK
    // handler.setInputAction(function (movement) {
    //     cartesian = viewer.camera.pickEllipsoid(movement.position, ellipsoid);
    //     if (cartesian) {
    //         TooltipCesium.showAt(movement.position, 'LEFT_DOUBLE_CLICK');
    //     } else {
    //         TooltipCesium.setVisible(false);
    //     }
    // }, Cesium.ScreenSpaceEventType.LEFT_DOUBLE_CLICK);
    //四 LEFT_DOWN
    // handler.setInputAction(function (movement) {
    //     cartesian = viewer.camera.pickEllipsoid(movement.position, ellipsoid);
    //     if (cartesian) {
    //         TooltipCesium.showAt(movement.position, 'LEFT_DOWN');
    //     } else {
    //         TooltipCesium.setVisible(false);
    //     }
    // }, Cesium.ScreenSpaceEventType.LEFT_DOWN);
    //五 LEFT_UP
    // handler.setInputAction(function (movement) {
    //     cartesian = viewer.camera.pickEllipsoid(movement.position, ellipsoid);
    //     if (cartesian) {
    //         TooltipCesium.showAt(movement.position, 'LEFT_UP');
    //     } else {
    //         TooltipCesium.setVisible(false);
    //     }
    // }, Cesium.ScreenSpaceEventType.LEFT_UP);

}
//获取放大水平（1-18）
function getLevel(height) {
    if (height > 48000000) {
        return 0;
    } else if (height > 24000000) {
        return 1;
    } else if (height > 12000000) {
        return 2;
    } else if (height > 6000000) {
        return 3;
    } else if (height > 3000000) {
        return 4;
    } else if (height > 1500000) {
        return 5;
    } else if (height > 750000) {
        return 6;
    } else if (height > 375000) {
        return 7;
    } else if (height > 187500) {
        return 8;
    } else if (height > 93750) {
        return 9;
    } else if (height > 46875) {
        return 10;
    } else if (height > 23437.5) {
        return 11;
    } else if (height > 11718.75) {
        return 12;
    } else if (height > 5859.38) {
        return 13;
    } else if (height > 2929.69) {
        return 14;
    } else if (height > 1464.84) {
        return 15;
    } else if (height > 732.42) {
        return 16;
    } else if (height > 366.21) {
        return 17;
    } else {
        return 18;
    }
}
 