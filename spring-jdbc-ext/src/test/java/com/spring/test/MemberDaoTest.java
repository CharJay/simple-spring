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

@ContextConfiguration(locations = {"classpath*:application-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class MemberDaoTest {
	@Autowired MemberDao memberDao;
	
	//自己的框架（择其善者而从之，开发出一个适合自己的框架）
	//爱美之心，人皆有之
	//找对象，一定是找个适合自己的（有时候需要去接受对方的缺点）	
	

	@Test
//	@Ignore
	public void testSelectByName(){
		try {
			List<Member> r = memberDao.selectByName("tom");
			System.out.println(JSON.toJSON(r));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
//	@Ignore
	public void testSelectAll(){
		try {
			System.out.println("-------" + JSON.toJSONString(memberDao.selectAll()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
//	@Ignore
	public void testInsertOne(){
		try {
			Member data = new Member();
			data.setName("小星星");
			boolean r = memberDao.insterOne(data);
			if(r){
				System.out.println(data.getId());
			}else{
				System.out.println("失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	@Ignore
	public void testUpdate(){
		try {
			Member data = new Member();
			data.setId(6L);
			data.setName("于菲");
			boolean r = memberDao.updataOne(data);
			System.out.println(r);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	@Ignore
	public void testDelete(){
		try {
			Member data = new Member();
			data.setId(6L);
			boolean r = memberDao.deleteOne(data);
			System.out.println(r);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
}
