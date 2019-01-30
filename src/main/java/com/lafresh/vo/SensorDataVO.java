package com.lafresh.vo;

public class SensorDataVO {
	
	private int no;
	private float temp;
	private float hum;
	private String date;

	public float getTemp() {
		return temp;
	}

	public void setTemp(float temp) {
		this.temp = temp;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public float getHum() {
		return hum;
	}

	public void setHum(float hum) {
		this.hum = hum;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
}
