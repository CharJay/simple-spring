package com.spring.test.bean;

public class Student {

	private String name;
	private String age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public void say(){
		System.out.println("我的名字是："+name+"，今年"+age+"岁了");
	}

	
}
