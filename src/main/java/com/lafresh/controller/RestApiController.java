package com.lafresh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lafresh.Service.MainService;
import com.lafresh.vo.SensorDataVO;

@RestController
public class RestApiController {
	
	@Autowired
	MainService mainService;
	
	@PostMapping("/test")
	public String doTest(@RequestBody SensorDataVO sensorData) {
		
		mainService.createSensorData(sensorData);
		
		return "test ok temper is : " + sensorData.getTemp() + ", no : "+ sensorData.getNo();
	}

}
