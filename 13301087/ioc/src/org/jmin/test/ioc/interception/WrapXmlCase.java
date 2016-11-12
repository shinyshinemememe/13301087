/*
 * Copyright (c) jmin Organization. All rights reserved.
 */
package org.jmin.test.ioc.interception;

import org.jmin.ioc.impl.config.BeanContext;
import org.jmin.test.TestCase;
import org.jmin.test.ioc.interception.object.Child;

/**
 * 拦截测试
 *
 * @author Chris
 */
public class WrapXmlCase extends TestCase{
	
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
		Child child = (Child) context.getBean("Bean2");
		child.sayHello("Chris");
		System.out.println("[XML].........AOP类修改拦截测试成功..........");
	}
}