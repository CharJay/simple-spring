package com.spring.test.aop;

import com.spring.aop.AbstractAopAdvior;
import com.spring.aop.AopAdvice;
import com.spring.aop.MethodPointcut;
import com.spring.aop.Pointcut;

/**
 * 日志切面
 * @author Administrator
 *
 */
public class LogAopAdvior extends AbstractAopAdvior{
	
	private static final Pointcut DEFAULT_POINTCUT = new MethodPointcut();
	
	private static final AopAdvice DEFAULT_AOPADVICE = new LogAdvice();
	
	public LogAopAdvior(){
		this.pointcut = DEFAULT_POINTCUT;
		this.aopAdvice = DEFAULT_AOPADVICE;
	}
	
	@Override
	public void setPointcut(Pointcut pointcut) {
		if (pointcut != null) {
			this.pointcut = pointcut;
		}else{
			this.pointcut = DEFAULT_POINTCUT;
		}
	}

	@Override
	public void setAopAdvice(AopAdvice aopAdvice) {
		if (aopAdvice != null) {
			this.aopAdvice = aopAdvice;
		}else{
			this.aopAdvice = DEFAULT_AOPADVICE;
		}
		
	}

	@Override
	public boolean match(Class<?> clazz) {
		return this.pointcut.match(clazz);
	}

	
	
}
