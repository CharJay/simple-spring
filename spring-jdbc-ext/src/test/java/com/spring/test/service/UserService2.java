package com.spring.test.service;

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
public class UserService2 {
	@Autowired
	private UserDao userDao;
	
	@Transactional(propagation=Propagation.NESTED,rollbackFor=Exception.class)
	public int service2() throws Exception{
		int cnt = userDao.update2();
		if(true){
			throw new RuntimeException("ex1");
		}
		return cnt;
	}
}
