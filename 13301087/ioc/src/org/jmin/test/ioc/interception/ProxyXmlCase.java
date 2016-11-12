/*
 * Copyright (c) jmin Organization. All rights reserved.
 */
package org.jmin.test.ioc.interception;

import org.jmin.ioc.impl.config.BeanContext;
import org.jmin.test.TestCase;
import org.jmin.test.ioc.interception.object.Young;

/**
 *  代理测试
 *
 * @author Chris
 */
public class ProxyXmlCase extends TestCase{
	
	/**
	 * 测试 context
	 */
	private BeanContext context=null;
	
	/**
	 * 设置环境
	 */
	public void setUp() throws Throwable {
		this.context = new BeanContext("org/jmin/test/ioc/interception/pojo.xml");
	}
	
	/**
	 * 方法拦截测试
	 */
	public void testIntercept()throws Throwable{
		Young child = (Young)context.getBean("Bean1");
		child.sayHello("Chris");
		System.out.println("[XML].........Proxy拦截测试成功..........");
	}	
}