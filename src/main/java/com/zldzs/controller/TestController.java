package com.zldzs.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zldzs.service.ITestConnService;

@Controller
public class TestController {

	
	@Resource
	private ITestConnService iTestConnService;
	
	@RequestMapping(value = "/t")
	@ResponseBody
	public int test(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("name", "aaa");
		map.put("date", new Date());
		map.put("flag", 1);
		return iTestConnService.add(map);
	}
	
}
