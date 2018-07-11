package com.spring.framework.servlet;

import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HandlerAdapter {
	
	private Map<String,Integer> paramMapping;
	
	public HandlerAdapter(Map<String,Integer> paramMapping){
		this.paramMapping = paramMapping;
	}
	
	//主要目的是用反射调用url对应的method
	public ModelAndView handle(HttpServletRequest req, HttpServletResponse resp,Handler handler) throws Exception{
		
		//为什么要传req、为什么要穿resp、为什么传handler
		Class<?> [] paramTypes = handler.method.getParameterTypes();
		
		//要想给参数赋值，只能通过索引号来找到具体的某个参数
		
		Object [] paramValues = new Object[paramTypes.length];
		
		Map<String,String[]> params = req.getParameterMap();
		
		for (Entry<String, String[]> param : params.entrySet()) {
			String value = Arrays.toString(param.getValue()).replaceAll("\\[|\\]", "").replaceAll(",\\s", ",");
			
			if(!this.paramMapping.containsKey(param.getKey())){continue;}
			
			int index = this.paramMapping.get(param.getKey());
			
			//单个赋值是不行的
			paramValues[index] = castStringValue(value,paramTypes[index]);
		}
		
		//request 和 response 要赋值
		String reqName = HttpServletRequest.class.getName();
		if(this.paramMapping.containsKey(reqName)){
			int reqIndex = this.paramMapping.get(reqName);
			paramValues[reqIndex] = req;
		}
		
		
		String resqName = HttpServletResponse.class.getName();
			if(this.paramMapping.containsKey(resqName)){
			int respIndex = this.paramMapping.get(resqName);
			paramValues[respIndex] = resp;
		}
		
		boolean isModelAndView = handler.method.getReturnType() == ModelAndView.class;
		Object r = handler.method.invoke(handler.controller, paramValues);
		if(isModelAndView){
			return (ModelAndView)r;
		}else{
			return null;
		}
		
	}
	
	
	private Object castStringValue(String value,Class<?> clazz){
		if(clazz == String.class){
			return value;
		}else if(clazz == Integer.class){
			return Integer.valueOf(value);
		}else if(clazz == int.class){
			return Integer.valueOf(value).intValue();
		}else{
			return null;
		}
	}
}
