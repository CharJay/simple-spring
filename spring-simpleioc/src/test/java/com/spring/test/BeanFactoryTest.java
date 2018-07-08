package com.spring.test;

import org.junit.Test;

import com.spring.ioc.BeanDefinition;
import com.spring.ioc.PropertyValue;
import com.spring.ioc.PropertyValues;
import com.spring.ioc.factory.AutowireBeanFactory;
import com.spring.ioc.factory.BeanFactory;
import com.spring.test.bean.Student;

/**
 *
 */
public class BeanFactoryTest {

	  // 类全名称
	  private final String classname = "com.spring.test.bean.Student";
	  // 属性名称
	  private final String property1 = "name";
	  private final String property2 = "age";
	  // 属性值
	  private String value1 = "林左";
	  private Integer value2 = 12;
	  // 类id
	  private final String name = "student";

	  @Test
	  public void test() throws Exception {

	    // 创建自动注册bean工厂
	    BeanFactory beanfactory = new AutowireBeanFactory();
	    // 创建一个bean定义对象
	    BeanDefinition beandefinition = new BeanDefinition();
	    // 给bean定义对象设置类名并创建class对象
	    beandefinition.setClassname(classname);

	    // 创建一个成员变量集合
	    PropertyValues pv = new PropertyValues();

	    // 给bean定义设置成员变量集合
	    beandefinition.setPropertyValues(pv);

	    // 向bean定义添加成员变量集合
	    beandefinition.getPropertyValues().addPropertyValue(new PropertyValue(property1, value1));
	    beandefinition.getPropertyValues().addPropertyValue(new PropertyValue(property2, value2));

	    // bean工厂将bean定义注册到容器中
	    beanfactory.registerBeanDefinition(name, beandefinition);

	    // 从容器中获取bean实例
	    Student student = (Student) beanfactory.getBean(name);

	    // 调用实例方法
	    student.say();;


	  }

}
