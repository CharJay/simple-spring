package com.spring.aop;

/**
 * 切点
 * @author Administrator
 *
 */
public interface Pointcut {
	
	boolean match(Class<?> clazz);
	
}
