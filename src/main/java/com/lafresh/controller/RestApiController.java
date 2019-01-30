package com.lafresh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lafresh.Service.MainService;
import com.lafresh.vo.SensorDataVO;
import com.lafresh.vo.SensorVO;

@RestController
public class RestApiController {
	
	@Autowired
	MainService mainService;
	
	@PostMapping("/test")
	public String doTest(@RequestBody SensorVO sensor) {
		
		SensorDataVO sensorDataA = new SensorDataVO();
		sensorDataA.setNo(1);
		sensorDataA.setTemp(sensor.getTempA());
		sensorDataA.setHum(sensor.getHumA());
		
		SensorDataVO sensorDataB = new SensorDataVO();
		sensorDataB.setNo(2);
		sensorDataB.setTemp(sensor.getTempA());
		sensorDataB.setHum(sensor.getHumA());
		
		mainService.createSensorData(sensorDataA);
		mainService.createSensorData(sensorDataB);
		
		return "test ok temper";
	}

}
