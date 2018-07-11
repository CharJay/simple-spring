package com.spring.demo.ctrl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.spring.demo.service.INamedService;
import com.spring.demo.service.IService;
import com.spring.framework.annotation.Autowired;
import com.spring.framework.annotation.Controller;
import com.spring.framework.annotation.RequestMapping;
import com.spring.framework.annotation.RequestParam;
import com.spring.framework.servlet.ModelAndView;

@Controller
@RequestMapping("/web")
public class FirstAction {

	@Autowired private IService service;
	
	@Autowired("myName") private INamedService namedService;
	
	
	@RequestMapping("/query/.*.json")
//	@GPResponseBody
	public ModelAndView query(HttpServletRequest request,HttpServletResponse response, 
			@RequestParam(value="name",required=false) String name,
			@RequestParam("addr") String addr){
		//out(response,"get params name = " + name);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("name", name);
		model.put("addr", addr);
		return new ModelAndView("first.pgml",model);
	}
	
	
	@RequestMapping("/add.json")
	public ModelAndView add(HttpServletRequest request,HttpServletResponse response){
		out(response,"this is json string");
		return null;
	}
	
	
	
	public void out(HttpServletResponse response,String str){
		try {
			response.getWriter().write(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
