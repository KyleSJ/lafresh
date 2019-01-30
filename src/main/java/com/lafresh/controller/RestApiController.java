package com.lafresh.controller;

import com.lafresh.DemoApplication;
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
		sensorDataB.setTemp(sensor.getTempB());
		sensorDataB.setHum(sensor.getHumB());

		SendAlarm alarm = new SendAlarm();
		
		if(sensor.getTempA() >= 30 || sensor.getHumA() >= 80) {
			sensor.setStatusA(1);
		}else {
			sensor.setStatusA(0);
		}
		
		if(sensor.getTempB() >= 30 || sensor.getHumB() >= 80) {
			sensor.setStatusB(1);
		}else {
			sensor.setStatusB(0);
		}
		
		if (sensor.getStatusA() == 1 && DemoApplication.onceA == false) {
			System.out.println("1");
			System.out.println("A data : " + sensor.getTempA() +"     " + sensor.getHumA() + "     " + sensor.getStatusA() + "    "  + DemoApplication.onceA );
			System.out.println();
			alarm.send("storageA");
			DemoApplication.onceA = true;
		} else if (sensor.getStatusA() == 0 && DemoApplication.onceA == true) {
			System.out.println("2");
			System.out.println("A data : " + sensor.getTempA() +"     " + sensor.getHumA() + "     " + sensor.getStatusA() + "    "  + DemoApplication.onceA );
			System.out.println();
			DemoApplication.onceA = false;
		}

		if (sensor.getStatusB() == 1 && DemoApplication.onceB == false) {
			System.out.println("3");
			System.out.println("B data : " + sensor.getTempB() +"     " + sensor.getHumB() + "     " + sensor.getStatusB() + "    "  + DemoApplication.onceB );
			System.out.println();
			alarm.send("storageB");
			DemoApplication.onceB = true;
		} else if (sensor.getStatusB() == 0 && DemoApplication.onceB == true) {
			System.out.println("4");
			System.out.println("B data : " + sensor.getTempB() +"     " + sensor.getHumB() + "     " + sensor.getStatusB() + "    "  + DemoApplication.onceB );
			System.out.println();
			DemoApplication.onceB = false;
		}

		mainService.createSensorData(sensorDataA);
		mainService.createSensorData(sensorDataB);

		return "test ok temper";
	}

}
