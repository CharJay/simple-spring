package com.spring.aop;

/**
 * 通知者通知处理类
 * @author Administrator
 *
 */
public class AopAdviorProceed {
	
	private AopAdvior aopAdvior;
	
	public AopAdviorProceed(AopAdvior aopAdvior){
		this.aopAdvior = aopAdvior;
	}
	
	public Object invoke(ProceedAdvior proceed) throws Throwable{
		Object value = null;
		aopAdvior.getAdvice().before();
		value = proceed.proceed();
		aopAdvior.getAdvice().after();
		return value;
	}
	
}
