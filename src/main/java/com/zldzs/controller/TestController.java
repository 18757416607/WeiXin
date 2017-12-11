package com.zldzs.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.http.client.ClientProtocolException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zldzs.pojo.AccessToken;
import com.zldzs.service.ITestConnService;
import com.zldzs.util.RequestWx;
import com.zldzs.util.wx.WxFileUpload;

@Controller
public class TestController {

	
	@Resource
	private ITestConnService iTestConnService;
	
	@RequestMapping(value = "/test")
	@ResponseBody
	public Map<String,Object> test1(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("name", "aaa");
		map.put("name1","ttt");
		map.put("date", new Date());
		map.put("flag", 1);
		return map;
	}
	
	
	@RequestMapping(value = "/t")
	@ResponseBody
	public int test(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("name", "aaa");
		map.put("name1","ttt");
		map.put("date", new Date());
		map.put("flag", 1);
		return iTestConnService.add(map);
	}
	
}
