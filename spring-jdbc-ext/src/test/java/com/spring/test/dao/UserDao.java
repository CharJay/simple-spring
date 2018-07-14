package com.spring.test.dao;

import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.spring.jdbc.framework.BaseDaoSupport;
import com.spring.jdbc.framework.QueryRule;
import com.spring.test.pojo.User;

@Repository
public class UserDao extends BaseDaoSupport<User, Long> {

	@Override
	protected String getPKColumn() { return "id"; }

	@Resource(name="dataSource")
	protected void setDataSource(DataSource dataSource) {
		super.setDataSourceReadOnly(dataSource);
		super.setDataSourceWrite(dataSource);
	}
	
	public List<User> selectByName(String name) throws Exception{
		QueryRule queryRule = 
		QueryRule.getInstance()
		.andEqual("user_name", name)
		.addAscOrder("id");
		
		return super.find(queryRule);
	}
	public User selectById(Long id) throws Exception{
		QueryRule queryRule = 
				QueryRule.getInstance()
				.andEqual("id", id);
		return super.findUnique(queryRule);
	}
	
	public List<User> selectAll() throws Exception{
		return super.getAll();
	}
	
	public boolean insterOne(User m) throws Exception{
		Long id = super.insertAndReturnId(m);
		m.setId(id);
		return id > 0;
	}
	
	public boolean updataOne(User m) throws Exception{
		long count = super.update(m);
		return count > 0;
	}
	
	public boolean deleteOne(User m) throws Exception{
		long count = super.delete(m);
		return count > 0;
	}
	
	public int update1() throws Exception{
		return super.update("update t_user set user_name ='123' where id=1");
	}
	public int update2() throws Exception{
		return super.update("update t_user set user_name ='1234' where id=2");
	}
	
}
