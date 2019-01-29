package com.lafresh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lafresh.Service.MainService;

@Controller
public class mainController {
	
	@Autowired
	MainService mainService;

	@RequestMapping(value="/", method = RequestMethod.GET)
	public String viewMain() {
		mainService.createTest("test ok");
		return "test";
	}
}
