package com.spring.aop;

import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibAopProxy implements MethodInterceptor {
	
	private List<AopAdvior> adviors = new LinkedList<AopAdvior>();
	
	public CglibAopProxy(){
		
	}
	
	@Override
	public Object intercept(Object param, Method arg1, Object[] paramArray,
			MethodProxy methodProxy) throws Throwable {
		Object value = null;
		if (adviors.isEmpty()) {
			value = methodProxy.invokeSuper(param, paramArray);
		}else{
			ProceedAdvior proceed = new ProceedAdvior(adviors, param, arg1, paramArray, methodProxy);
			value = proceed.proceed();
		}
		return value; 
	}
	
	public List<AopAdvior> getAdviors() {
		return adviors;
	}
	public void setAdviors(List<AopAdvior> adviors) {
		this.adviors = adviors;
	}
	
}
