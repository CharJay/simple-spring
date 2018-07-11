package com.spring.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
	
	@Transactional
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
}
