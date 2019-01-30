<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/include/header.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<!-- Styles -->
<style>
#chartdiv {
  width: 100%;
  height: 500px;
}

</style>

<!-- Resources -->
<script src="https://www.amcharts.com/lib/4/core.js"></script>
<script src="https://www.amcharts.com/lib/4/charts.js"></script>
<script src="https://www.amcharts.com/lib/4/themes/animated.js"></script>
<script
  src="https://code.jquery.com/jquery-3.3.1.min.js"
  integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
  crossorigin="anonymous"></script>

<!-- Chart code -->
<script>

var chart = null;

$().ready(function(){
	// Themes begin
	am4core.useTheme(am4themes_animated);
	// Themes end
	
	// Add data
	
	// Create chart instance
	chart = am4core.create("chartdiv", am4charts.XYChart);
	
	//chart.dateFormatter.dateFormat = "HH-mm-ss";
	
	chart.data = new Array();
	
	//Create axes
	var dateAxis = chart.xAxes.push(new am4charts.DateAxis());
	dateAxis.dateFormatter = new am4core.DateFormatter();
	dateAxis.dateFormatter.dateFormat = "HH-mm-ss";
	var valueAxis = chart.yAxes.push(new am4charts.ValueAxis());
	
	// Create series
	var series = chart.series.push(new am4charts.LineSeries());
	series.dataFields.valueY = "temp";
	series.dataFields.dateX = "date";
	series.tooltipText = "{temp}"
	series.strokeWidth = 2;
	series.minBulletDistance = 15;
	
	// Drop-shaped tooltips
	series.tooltip.background.cornerRadius = 20;
	series.tooltip.background.strokeOpacity = 0;
	series.tooltip.pointerOrientation = "vertical"; 
	series.tooltip.label.minWidth = 40;
	series.tooltip.label.minHeight = 40;
	series.tooltip.label.textAlign = "middle";
	series.tooltip.label.textValign = "middle";
	
	// Make bullets grow on hover
	var bullet = series.bullets.push(new am4charts.CircleBullet());
	bullet.circle.strokeWidth = 2;
	bullet.circle.radius = 4;
	bullet.circle.fill = am4core.color("#fff");
	
	var bullethover = bullet.states.create("hover");
	bullethover.properties.scale = 1.3;
	
	// Make a panning cursor
	chart.cursor = new am4charts.XYCursor();
	chart.cursor.behavior = "panXY";
	chart.cursor.xAxis = dateAxis;
	chart.cursor.snapToSeries = series;
	
	// Create vertical scrollbar and place it before the value axis
	chart.scrollbarY = new am4core.Scrollbar();
	chart.scrollbarY.parent = chart.leftAxesContainer;
	chart.scrollbarY.toBack();
	
	// Create a horizontal scrollbar with previe and place it underneath the date axis
	chart.scrollbarX = new am4charts.XYChartScrollbar();
	chart.scrollbarX.series.push(series);
	chart.scrollbarX.parent = chart.bottomAxesContainer;
	
	chart.events.on("ready", function () {
	  dateAxis.zoom({start:0.79, end:1});
	});
	
	setInterval(function(){
		getSensorData(1);
		chart.validateData();
		console.log(chart.data);
	}, 1000);
	
})
	
function getSensorData(storeNo){
	$.ajax({
		url: '/sensorData/' + storeNo,
		dataType : 'json',
		success: function(data){
			chart.data.push(data);
		}
	})
}
	
	
</script>
<body>

	<div id="chartdiv"></div>

</body>
</html>