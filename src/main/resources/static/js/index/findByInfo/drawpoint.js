function addPoint(backData) {
    viewer.entities.removeAll();
    var gid;
    var urban;
    var town;
    var village;
    var area;
    var contractor;
    var id;
    var treespeciesvar;
    var visitage;
    var treeage;
    var treeheight;
    var grounddiameter;
    var treearea;
    var growingpotential;
    var recorder;
    var date;
    var x;
    var y;
    var geom;
    var maintenance;

    var citizensBankPark;

    var pointListJson = [];

   // console.log(backData);
    for (var i = 0; i < backData.length; i++) {

         gid= backData[i].gid;
         urban= backData[i].urban;
         town= backData[i].town;
         village= backData[i].village;
         area= backData[i].area;
         contractor= backData[i].contractor;
         id= backData[i].id;
         treespeciesvar= backData[i].treespeciesvar;
         visitage= backData[i].visitage;
         treeage= backData[i].treeage;
         treeheight= backData[i].treeheight;
         grounddiameter= backData[i].grounddiameter;
         treearea= backData[i].treearea;
         growingpotential= backData[i].growingpotential;
         recorder= backData[i].recorder;
         date= backData[i].date;
         x= backData[i].x;
         y= backData[i].y;
        maintenance= backData[i].maintenance;


        citizensBankPark = viewer.entities
            .add({
                position: Cesium.Cartesian3.fromDegrees(x,
                    y),
                // 广告牌
                billboard: {
                    image: '/staticResource/image/cesium/tree.png',
                    width: 32,
                    height: 32
                },
                label: {
                    text: contractor + ","
                    + treespeciesvar.treespeciesname,
                    font: '12pt SimSun',

                    fillColor: Cesium.Color.BLACK,
                    style: Cesium.LabelStyle.OUTLINE,
                    outlineWidth: 0,
                    verticalOrigin: Cesium.VerticalOrigin.TOP,
                    pixelOffset: new Cesium.Cartesian2(0,
                        32)
                }

                //
            });

        citizensBankPark.name = contractor;
        citizensBankPark.description = "<table style='background-color: black;border-color:white;border:1px ;'>\
<tr style='background-color: black ;color:white;'   >\
<td>序号</td>\
<td>"
            + gid
            + "</td>\
</tr>"
            + "<tr style='background-color: black ;color:white;'>\
<td>区</td>\
<td>"
            + urban
            + "</td>\
</tr>"
            + "<tr style='background-color: black ;color:white;'>\
<td>乡镇</td>\
<td>"
            + town
            + "</td>\
</tr>"
            + "<tr style='background-color: black ;color:white;'>\
<td>村</td>\
<td>"
            + village
            + "</td>\
</tr>"
            + "<tr style='background-color: black ;color:white;'>\
<td>位置</td>\
<td>"
            + area

            + "</td>\
</tr>"
            + "<tr style='background-color: black ;color:white;'>\
<td>承包人</td>\
<td>"
            + contractor

            + "</td>\
</tr>"
            + "<tr style='background-color: black ;color:white;'>\
<td>标牌编号</td>\
<td>"
            + id

            + "</td>\
</tr>"
            + "<tr style='background-color: black ;color:white;'>\
<td>果树品种</td>\
<td>"
            + treespeciesvar.treespeciesname

            + "</td>\
</tr>"
            + "<tr style='background-color: black ;color:white;'>\
<td>访问树龄</td>\
<td>"
            + visitage
            + "</td>\
</tr>"
            + "<tr style='background-color: black ;color:white;'>\
<td>调查树龄</td>\
		          <td>"
            + treeage + "年"
            + "</td>\
</tr>"
            + "<tr style='background-color: black ;color:white;'>\
				 <td>树高</td>\
		          <td>"
            + treeheight + "米"
            + "</td>\
	</tr>"
            + "<tr style='background-color: black ;color:white;'>\
	<td>地径</td>\
	<td>"
            + grounddiameter+"厘米"
            + "</td>\
	</tr>" + "<tr style='background-color: black ;color:white;'>\
	<td>冠幅</td>\
	<td>"
            + treearea+"平方米"
            + "</td>\
	</tr>" + "<tr style='background-color: black ;color:white;'>\
	<td>生长势</td>\
	<td>"
            + growingpotential.growingpotential
            + "</td>\
	</tr>" + "<tr style='background-color: black ;color:white;'>\
	<td>记录人</td>\
	<td>"
            + recorder
            + "</td>\
	</tr>"

            + "<tr style='background-color: black ;color:white;'>\
	<td>经度</td>\
	<td>"
            + x
            + "</td>\
	</tr>"
            + "<tr style='background-color: black ;color:white;'>\
	<td>纬度</td>\
	<td>"
            + y
            + "</td>\
	</tr>"
            + "<tr style='background-color: black ;color:white;'>\
	<td>维护情况</td>\
	<td>"
            + maintenance
            + "</td>\
	</tr>"
            //	+ "<tr style='background-color: black ;color:white;'>\
//	<td>图像展示</td>\
            //<td><img style='height:200px;width:150px' src="+  treeimgpath+" /></td>\
            //</tr>"


            + "</table>";
        var geomcoordinate = backData[i].geom.substring(6,
            backData[i].geom.length - 1).split(" ");

        geomcoordinate[0] = geomcoordinate[0] * 1;
        geomcoordinate[1] = geomcoordinate[1] * 1;
        pointListJson.push({
            gid: gid,
            x: geomcoordinate[0],
            y: geomcoordinate[1],
            geom: geom
        });

    }
    viewer.camera.flyTo({
        destination: Cesium.Cartesian3.fromDegrees(
            pointListJson[0].x, pointListJson[0].y, 100)
    });
}