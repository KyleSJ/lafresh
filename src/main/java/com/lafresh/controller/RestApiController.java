package com.lafresh.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lafresh.vo.SensorDataVO;

@RestController
public class RestApiController {
	
	@PostMapping("/test")
	public String doTest(@RequestBody SensorDataVO sensorData) {
		System.out.println("test ok");
		System.out.println(sensorData.getTemp());
		return "test ok temper is : " + sensorData.getTemp();
	}

}
