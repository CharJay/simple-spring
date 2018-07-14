package com.spring.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.test.dao.UserDao;
import com.spring.test.pojo.User;
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
	@Test
//	@Ignore
	public void testTran(){
		try {
			userService.serviceMain1();
//			userService.serviceMain2();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}
