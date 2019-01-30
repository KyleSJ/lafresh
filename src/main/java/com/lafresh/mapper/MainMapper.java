package com.lafresh.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.lafresh.vo.SensorDataVO;

@Mapper
public interface MainMapper {
	void insertTest(String test);
	void insertSensorData(SensorDataVO sensorData);
	SensorDataVO selectSensorData(int sensorNo);
}
