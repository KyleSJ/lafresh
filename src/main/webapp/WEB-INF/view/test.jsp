<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/include/header.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>L.afresh</title>
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
    <script type="text/javascript" src="js/mainScript.js"></script>

<!-- Chart code -->
<script>


</script>
  <body>
		<div class ="header-top-area" style = "background-color: #00c292; width:100%; height:30px;diplay:block;">
			<div style = "margin-right:15px;">
	      		<img src="img/logo/logo.png" alt="">
			</div>
		</div>
		<div style = "width:500px; height:300px; display:block;">
  			<div style = "display:block;">
				<canvas id="chart0" style="width:512px;height:320px"></canvas>
   				<canvas id="chart1" style="width:512px;height:320px"></canvas>
			</div>
		</div>
  </body>
</html>