package com.zldzs.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zldzs.dao.ITestConnDao;
import com.zldzs.dao.ZdemoDao;
import com.zldzs.service.ITestConnService;

@Service
public class TestConnServiceImpl  implements ITestConnService{

	@Resource
	private ITestConnDao testConnDao;
	
	@Resource
	private ZdemoDao zdemoDao;
	
	public int add(Map<String, Object> map) {
		testConnDao.add(map);
		return zdemoDao.addDemo(map);
	}

}
