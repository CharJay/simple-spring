package com.spring.aop;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * aop运行的舞台
 * @author Administrator
 *
 */
public class ApplicationContext {
	
	private static ApplicationContext context;
	
	private static ProxyRegister proxyRegister = new ProxyRegister();
	
	private static Map<Class<?>,Object> beanMap = new ConcurrentHashMap<Class<?>, Object>();
	
	private ApplicationContext(){
		
	}
	
	/**
	 * 注册Bean
	 * @param clazz
	 * @param isProxy
	 * @throws IllegalArgumentException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public <T> void register(Class<T> clazz,boolean isProxy) throws IllegalArgumentException, InstantiationException, IllegalAccessException{
		if (beanMap.containsKey(clazz)) {
			return;
		}
		if(isProxy){
			beanMap.put(clazz,proxyRegister.register(clazz));
			return;
		}
		beanMap.put(clazz,clazz.newInstance());
	}
	
	public static ApplicationContext getContext(){
		synchronized (ApplicationContext.class) {
			if (context == null) {
				return new ApplicationContext();
			}
		}
		return context;
	}
	@SuppressWarnings("unchecked")
	public <T> T getBean(Class<?> clazz){
		return (T)beanMap.get(clazz);
	}
	
	@SuppressWarnings("unchecked")
	public <T> List<T> getBeans(Class<T> clazz){
		List<T> list = new ArrayList<T>();
		for (Map.Entry<Class<?>, Object> entry:beanMap.entrySet()) {
			if (clazz.isAssignableFrom(entry.getKey())) {
				list.add((T)entry.getValue());
			}
		}
		return list;
	}
}
