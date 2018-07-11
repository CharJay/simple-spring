package com.spring.demo.service.impl;

import com.spring.demo.service.INamedService;
import com.spring.demo.service.IService;
import com.spring.framework.annotation.Autowired;
import com.spring.framework.annotation.Service;

@Service("myName")
public class NamedServiceImpl implements INamedService{

	@Autowired IService service;
	
}
