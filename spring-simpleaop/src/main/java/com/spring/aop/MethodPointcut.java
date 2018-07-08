package com.spring.aop;

import java.lang.reflect.Method;

/**
 * 切点实现类
 * @author Administrator
 *
 */
public class MethodPointcut implements Pointcut {
	
	private static String expression = "com.spring.";
	
	@Override
	public boolean match(Class<?> clazz) {
		Method[] methods = clazz.getDeclaredMethods();
		for (Method method : methods) {
			String methodname = clazz.getName()+"."+method.getName();
			if (methodname.startsWith(expression)){
				return true;
			}
		}
		return false;
	}

	public String getExpression() {
		return expression;
	}

	public void setExpression(String expression) {
		this.expression = expression;
	}
	
	
}
