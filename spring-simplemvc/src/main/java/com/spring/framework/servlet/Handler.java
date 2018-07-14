package com.spring.framework.servlet;

import java.lang.reflect.Method;
import java.util.regex.Pattern;

/**
 * 存储url与方法的映射
 * @author Administrator
 *
 */
public class Handler {
	protected Object controller;
	protected Method method;
	protected Pattern pattern;
	
	protected Handler(Pattern pattern,Object controller,Method method){
		this.pattern = pattern;
		this.controller = controller;
		this.method = method;
	}
}
