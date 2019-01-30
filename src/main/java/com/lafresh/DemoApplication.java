package com.lafresh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.lafresh.mapper")
public class DemoApplication {
  public static boolean onceA = false;
  public static boolean onceB = false;

  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }
}

