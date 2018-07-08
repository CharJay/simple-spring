package com.spring.aop;

import java.util.Date;

/**
 * 时间通知
 * @author Administrator
 *
 */
public class TimeCountAdvice implements AopAdvice{
	
	private Long starttime;
	
	private Long endtime;

	@Override
	public void before() {
		this.starttime = System.currentTimeMillis();
		System.out.println("===before:  "+new Date().toLocaleString());
		
	}

	@Override
	public void after() {
		this.endtime = System.currentTimeMillis();
		System.out.println("===after:  consume time "+(endtime-starttime));
	}
	
}
