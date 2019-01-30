package com.lafresh.Service;

import com.lafresh.vo.SensorDataVO;

public interface MainService {

	public void createTest(String test);
	
	public void createSensorData(SensorDataVO sensorData);
	
	public SensorDataVO readSensorData(int sensorNo);
	
}
