package com.spring.ioc.factory;

import com.spring.ioc.BeanDefinition;

/**
 * 需要一个beanFactory 定义ioc 容器的一些行为 比如根据名称获取bean， 比如注册bean，参数为bean的名称，bean的定义
 *
 */
public interface BeanFactory {

  /**
   * 根据bean的名称从容器中获取bean对象
   *
   * @param name bean 名称
   * @return bean实例
   * @throws Exception 异常
   */
  Object getBean(String name) throws Exception;

  /**
   * 将bean注册到容器中
   *
   * @param name bean 名称
   * @param bean bean实例
   * @throws Exception 异常
   */
  void registerBeanDefinition(String name, BeanDefinition bean) throws Exception;
}
