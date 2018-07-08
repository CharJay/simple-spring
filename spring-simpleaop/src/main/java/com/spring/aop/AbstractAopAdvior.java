package com.spring.aop;

/**
 * 通知者：需要包含具体切点与通知实现类
 * @author Administrator
 *
 */
public abstract class AbstractAopAdvior implements AopAdvior{
	
	protected Pointcut pointcut;
	
	protected AopAdvice aopAdvice;
	
	
	public Pointcut getPointcut() {
		return pointcut;
	}
	public abstract void setPointcut(Pointcut pointcut) ;
	
	public AopAdvice getAdvice() {
		return aopAdvice;
	}
	
	public abstract void setAopAdvice(AopAdvice aopAdvice) ;
	
	
	
}
