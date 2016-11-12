/*
 * Copyright (c) jmin Organization. All rights reserved.
 */
package org.jmin.test.ioc.invocation;

import org.jmin.ioc.impl.config.BeanContext;
import org.jmin.test.TestCase;

/**
 * 调用注入方式
 *
 * @author Chris
 */
public class InvocationXmlCase extends TestCase{
	
	/**
	 * 测试 context
	 */
	private BeanContext context=null;
	
	/**
	 * 设置环境
	 */
	public void setUp() throws Throwable {
		this.context = new BeanContext("org/jmin/test/ioc/invocation/pojo.xml");
	}
	
	/**
	 * 测试方法调用注入
	 */
	public void testByName() throws Throwable {
		Man boy = (Man)this.context.getBean("Bean1");
		if(boy!=null){
			if("Chris".equals(boy.getName())){
				System.out.println("[XML]........方法调用测试成功..........");
			}else{
				throw new Error("[XML]..........方法调用测试失败............");
			}
		}
	}
}