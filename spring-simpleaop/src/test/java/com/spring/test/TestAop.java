package com.spring.test;

import com.spring.aop.ApplicationContext;
import com.spring.aop.DefaultAopAdvior;
import com.spring.test.aop.LogAopAdvior;

public class TestAop {
	private static ApplicationContext context;
	
	public static void main(String[] args) throws IllegalArgumentException, InstantiationException, IllegalAccessException {
		context = ApplicationContext.getContext();
		context.register(DefaultAopAdvior.class, false);
		context.register(LogAopAdvior.class, false);
		context.register(StreamDemo.class, true);
		StreamDemo streamDemo = context.getBean(StreamDemo.class);
		streamDemo.demoForAddDataTime();
		streamDemo.demoStreamAddDataTime();
		streamDemo.demoParallelStreamAddDataTime();
		streamDemo.demoForFilterDataTime();
		streamDemo.demoStreamFilterDataTime();
		streamDemo.demoParallelStreamFilterDataTime();
		streamDemo.demoForDataTime();
		streamDemo.demoStreamForDataTime();
		streamDemo.demoParallelStreamForDataTime();
	}
	
	
}
