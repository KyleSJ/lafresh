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
	canvas {
	  display: inline-block !important;
	}
</style>

<!-- Resources -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.15.1/moment.min.js"></script>
    <script src="https://playground.abysscorp.org/chartjs/livecharts/dist/Chart.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>

<!-- Chart code -->
<script>
var samples = 20;
var speed = 1000;
let timeout = samples * speed;
var values = [];
var labels = [];
var charts = [];
var value = 0;
var scale = 1;

addEmptyValues(values, samples);



var originalCalculateXLabelRotation = Chart.Scale.prototype.calculateXLabelRotation

function initialize() {
  charts.push(new Chart(document.getElementById("chart0"), {
    type: 'line',
    data: {
      //labels: labels,
      datasets: [{
        data: values,
        backgroundColor: 'rgba(255, 99, 132, 0.1)',
        borderColor: 'rgb(255, 99, 132)',
        borderWidth: 2,
        lineTension: 0.25,
        pointRadius: 0
      }]
    },
    options: {
      responsive: true,
      animation: {
        duration: speed * 1.5,
        easing: 'linear'
      },
      legend: false,
      scales: {
        xAxes: [{
          type: "time",
          display: true
        }],
        yAxes: [{
          ticks: {
            max: 40,
            min: 0
          }
        }]
      }
    }
  }));
}

function addEmptyValues(arr, n) {
  for(var i = 0; i < n; i++) {
    arr.push({
      x: moment().subtract((n - i) * speed, 'milliseconds').toDate(),
      y: null
    });
  }
}

function rescale() {
  var padding = [];
  
  addEmptyValues(padding, 10);
  values.splice.apply(values, padding);
  
  scale++;
}

function updateCharts(){
  charts.forEach(function(chart) {
    chart.update();
  });
}

function progress() {
  value = getSensorData(1)
  values.push({
    x: new Date(),
    y: value
  });
  values.shift();
}

function advance() {
  if (values[0] !== null && scale < 4) {
    //rescale();
    updateCharts();
  }
  
  progress();
  updateCharts();
  
  setTimeout(function() {
    requestAnimationFrame(advance);
  }, speed);
}

//센서데이터
function getSensorData(storeNo){
	var res = 10;
	var b = false;
	$.ajax({
		url: '/sensorData/' + storeNo,
		dataType : 'json',
		async : false,
		success: function(data){
			console.log(data);
			res = data.temp;
			return data.temp;
		}
	});
	return res;
}

window.onload = function() {
  initialize();
  advance();
};

</script>
  <body>
    <canvas id="chart0" style="width:512px;height:320px"></canvas>
    <canvas id="chart1" style="width:512px;height:320px"></canvas>
  </body>
</html>