package com.zhang.module.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("api")
public class TestController {
	
	@RequestMapping("/test")
	@ResponseBody
	public String test(){
		return "{name:zhang,value:test}";
	}

}
