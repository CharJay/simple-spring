package com.spring.aop;

/**
 * 默认切面：拥有默认切点与默认通知
 * @author Administrator
 *
 */
public class DefaultAopAdvior extends AbstractAopAdvior{
	
	private static final Pointcut DEFAULT_POINTCUT = new MethodPointcut();
	
	private static final AopAdvice DEFAULT_AOPADVICE = new TimeCountAdvice();
	
	public DefaultAopAdvior(){
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
