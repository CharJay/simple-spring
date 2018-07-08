package com.spring.aop;

import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

import net.sf.cglib.proxy.MethodProxy;

/**
 * 处理者
 * @author Administrator
 *
 */
public class ProceedAdvior {
	
	private List<AopAdvior> adviors = new LinkedList<AopAdvior>();
	
	private int currentIndex = -1;
	
	private Object param ;
	
	private Method arg1 ;
	
	private Object[] paramArray;
	
	private MethodProxy methodProxy;
	
	public ProceedAdvior(List<AopAdvior> adviors,Object param, Method arg1, Object[] paramArray,
			MethodProxy methodProxy){
		this.adviors = adviors;
		this.param = param;
		this.arg1 = arg1;
		this.param = param;
		this.paramArray = paramArray;
		this.methodProxy = methodProxy;
	}
	
	/**
	 * 主要处理
	 * @return
	 * @throws Throwable
	 */
	public Object proceed() throws Throwable{
		
		if (currentIndex+1 == adviors.size()) {
			return methodProxy.invokeSuper(param, paramArray);
		}
		AopAdvior advior = this.adviors.get(++currentIndex);
		AopAdviorProceed adviorProceed = new AopAdviorProceed(advior);
		return adviorProceed.invoke(this);
	}
	
}
