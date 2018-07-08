package com.spring.ioc.io;

import java.io.InputStream;

/**
 * 资源定义
 *
 */
public interface Resource {

  /**
   * 获取输入流
   */
  InputStream getInputstream() throws Exception;
}
