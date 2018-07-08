package com.spring.test;

import java.util.Map;
import org.junit.Test;

import com.spring.ioc.BeanDefinition;
import com.spring.ioc.factory.AutowireBeanFactory;
import com.spring.ioc.factory.BeanFactory;
import com.spring.ioc.io.ResourceLoader;
import com.spring.ioc.xml.XmlBeanDefinitionReader;
import com.spring.test.bean.ReferenceBean;

public class XmlBeanDefinitionReaderTest {

  @Test
  public void test() throws Exception {
    // 创建一个XML解析器，携带一个资源加载器
    XmlBeanDefinitionReader xml = new XmlBeanDefinitionReader(new ResourceLoader());
    // 解析该文件
    xml.readerXML("myspring.xml");

    // 创建一个自动注入bean工厂
    BeanFactory beanfactory = new AutowireBeanFactory();
    // 循环xml中的所有bean
    for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xml.getRegistry().entrySet()) {
      // 将XML容器中的bean注册到bean工厂
      beanfactory
          .registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
    }
    
    // 获取持有另一个bean对象的bean（也是从容器中取得的）
    ReferenceBean bean = (ReferenceBean) beanfactory.getBean("referenceBean");
    // 调用对象方法
    bean.say();


  }
}
