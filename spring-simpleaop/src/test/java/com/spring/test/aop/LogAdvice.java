package com.spring.test.aop;

import com.spring.aop.AopAdvice;

public class LogAdvice implements AopAdvice{
	
	@Override
	public void before() {
		System.out.println("==before log");
		
	}

	@Override
	public void after() {
		System.out.println("==after log");
	}
	
}
