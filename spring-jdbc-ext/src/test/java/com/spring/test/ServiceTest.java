package com.spring.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.spring.test.dao.MemberDao;
import com.spring.test.pojo.Member;
import com.spring.test.service.UserService;

@ContextConfiguration(locations = {"classpath*:application-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class ServiceTest {
	@Autowired UserService userService;
	

	@Test
//	@Ignore
	public void test(){
		try {
			userService.add();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}
