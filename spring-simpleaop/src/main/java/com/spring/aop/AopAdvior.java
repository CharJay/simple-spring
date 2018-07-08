package com.spring.aop;

/**
 * AOP通知者接口
 * @author Administrator
 *
 */
public interface AopAdvior {
	
	/**
	 * 是否匹配该bean
	 * @return
	 */
	public abstract boolean match(Class<?> clazz);
	
	AopAdvice getAdvice();
	
}
