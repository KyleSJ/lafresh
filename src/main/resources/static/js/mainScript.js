$().ready(function(){
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
	            max: 30,
	            min: 20
	          }
	        }]
	      }
	    }
	  }));
	  charts.push(new Chart(document.getElementById("chart1"), {
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
						  max: 30,
						  min: 20
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
})