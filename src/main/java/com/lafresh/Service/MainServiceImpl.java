package com.lafresh.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lafresh.mapper.MainMapper;
import com.lafresh.vo.SensorDataVO;

@Service
public class MainServiceImpl implements MainService{
	
	@Autowired
	MainMapper mainMapper;

	@Override
	public void createTest(String test) {
		mainMapper.insertTest(test);
	}

	@Override
	public void createSensorData(SensorDataVO sensorData) {
		mainMapper.insertSensorData(sensorData);
	}

	@Override
	public SensorDataVO readSensorData(int sensorNo) {
		return mainMapper.selectSensorData(sensorNo);
	}

}
