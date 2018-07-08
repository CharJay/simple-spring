package com.spring.test.bean;

public class ReferenceBean {

  private Student student;

  public void say() {
	  student.say();;
  }

  public void setHello(Student student) {
    this.student = student;
  }
}
