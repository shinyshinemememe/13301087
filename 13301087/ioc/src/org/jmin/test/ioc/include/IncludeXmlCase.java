/*
 * Copyright (c) jmin Organization. All rights reserved.
 */
package org.jmin.test.ioc.include;

import org.jmin.ioc.impl.config.BeanContext;
import org.jmin.test.TestCase;
import org.jmin.test.ioc.include.object.Computer;

/**
 * XML include测试
 *
 * @author Chris
 */
public class IncludeXmlCase extends TestCase{
	
	/**
	 * 测试 context
	 */
	private BeanContext context=null;
	
	/**
	 * 设置环境
	 */
	public void setUp() throws Throwable {
		this.context = new BeanContext("org/jmin/test/ioc/include/pojo.xml");
	}
	
	/**
	 * 测试通过
	 */
	public void testByName() throws Throwable {
		Computer computer = (Computer)context.getBean("Bean1");
		if(computer!=null && computer.getKeyBoard()!=null && computer.getMonitor()!=null){
			System.out.println("[XML].........Include xml file 测试成功..........");
		}else{
			throw new Error("[XML] ...........Include xml file 测试失败............");
	  }
	}
}