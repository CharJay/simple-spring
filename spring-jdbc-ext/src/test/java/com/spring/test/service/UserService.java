package com.spring.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spring.test.dao.MemberDao;
import com.spring.test.dao.UserDao;
import com.spring.test.pojo.Member;
import com.spring.test.pojo.User;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private UserService1 userService1;
	@Autowired
	private UserService2 userService2;
	
	public void add() throws Exception{
		User u=new User();
		u.setUser_name("fadsfa");
		userDao.insterOne(u);
		Member m=new Member();
		m.setName("dsdags");
		memberDao.insterOne(m);
		if(true){
			throw new RuntimeException("ee");
		}
	}
	
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void serviceMain1() throws Exception{
//		userService1.service1();
		userDao.update1();
		//如果service2设置为REQUIRED_NEW那么抛出ex3异常，service2不会回滚，service1回滚
		//如果service2设置为REQUIRED，那么都回滚
		userService2.service2();
		if(true){
			throw new RuntimeException("ex3");
		}
	}
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void serviceMain2() throws Exception{
//		userService1.service1();
		userDao.update1();
		try {
			//如果service2设置为REQUIRED，那么假设service2抛异常了，下面读取到的是脏数据，不是回滚后的数据
			//如果service2设置为NESTED，那么假设service2抛异常了，下面读取到的是回滚后的数据
			userService2.service2();
		} catch (Exception e) {
//			e.printStackTrace();
		}
		User user = userDao.selectById(2L);//判断是否读取到脏数据
		System.out.println(user.toString());
//		if(true){
//			throw new RuntimeException("ex3");
//		}
	}
}
