package com.lafresh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.lafresh.Service.MainService;
import com.lafresh.vo.SensorDataVO;

@Controller
public class mainController {
	
	@Autowired
	MainService mainService;

	@RequestMapping(value="/", method = RequestMethod.GET)
	public String viewMain() {
		return "test";
	}
	
	@RequestMapping("/sensorData/{sensorNo}")
	@ResponseBody
	public String getSensorData(@PathVariable("sensorNo") int sensorNo) {
		SensorDataVO sensor = mainService.readSensorData(sensorNo);
		
		ObjectWriter ow = new ObjectMapper().writerWithDefaultPrettyPrinter();
		String json="";
		try {
			json = ow.writeValueAsString(sensor);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return json;
	}
	
}
