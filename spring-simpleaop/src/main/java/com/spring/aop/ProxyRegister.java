package com.spring.aop;

import java.lang.reflect.Proxy;
import java.util.LinkedList;
import java.util.List;

import net.sf.cglib.proxy.Enhancer;

/**
 * 被代理对象注册类
 * @author Administrator
 *
 */
public class ProxyRegister {
	
	private static ApplicationContext context = ApplicationContext.getContext();
	
	//注册代理对象
	@SuppressWarnings("unchecked")
	public <T> T register(Class<T> clazz) throws IllegalArgumentException, InstantiationException, IllegalAccessException {
		if (clazz.getInterfaces() == null || clazz.getInterfaces().length == 0) {
			Enhancer enhancer = new Enhancer();
	        enhancer.setSuperclass(clazz);
	        CglibAopProxy cglibProxy = new CglibAopProxy();
	        checkAndPutAdvior(cglibProxy,clazz);
	        enhancer.setCallback(cglibProxy);
	        return (T) enhancer.create();
		}
		return (T)Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),new JdkDynamicAopProxy(clazz.newInstance(), null));
	}

	/**
	 * 拦截器链
	 * @param cglibProxy
	 * @param clazz
	 */
	private void checkAndPutAdvior(CglibAopProxy cglibProxy,Class<?> clazz) {
		List<AopAdvior> adviors = context.getBeans(AopAdvior.class);
		List<AopAdvior> matchAdvior = new LinkedList<AopAdvior>();
		for (AopAdvior advior : adviors) {
			if (advior.match(clazz)) {
				matchAdvior.add(advior);
			}
		}
		cglibProxy.setAdviors(matchAdvior);
	}
	
}
