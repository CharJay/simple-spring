package com.spring.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Optional;

/**
 * JDK代理
 * @author Administrator
 *
 */
public class JdkDynamicAopProxy implements InvocationHandler {
	
	private AopAdvice aopAdvice;
	
	private Object handler;
	
	public JdkDynamicAopProxy(Object handler) {
		this.handler = handler;
	}
	
	public JdkDynamicAopProxy(Object handler, AopAdvice aopAdvice) {
		this.handler = handler;
		this.aopAdvice = aopAdvice;
	}
	
	@Override
	public Object invoke(Object paramObject, Method paramMethod,
			Object[] paramArrayOfObject) throws Throwable {
		Optional<AopAdvice> advice = Optional.ofNullable(aopAdvice);
		advice.ifPresent(val->val.before());
		paramMethod.invoke(handler, paramArrayOfObject);
		advice.ifPresent(val->val.after());
		return null;
	}



	public AopAdvice getAopAdvice() {
		return aopAdvice;
	}

	public void setAopAdvice(AopAdvice aopAdvice) {
		this.aopAdvice = aopAdvice;
	}

	public Object getHandler() {
		return handler;
	}

	public void setHandler(Object handler) {
		this.handler = handler;
	}
	
	
	
}
