/*
 * Copyright (c) jmin Organization. All rights reserved.
 */
package org.jmin.test.ioc.autowire;

import org.jmin.ioc.impl.config.BeanContext;
import org.jmin.test.TestCase;

/**
 * A IOC Autowire example
 *
 * @author Chris
 */
public class AutowireXmlCase extends TestCase{
	
	/**
	 * 测试 context
	 */
	private BeanContext context=null;
	
	/**
	 * 设置环境
	 */
	public void setUp() throws Throwable {
		this.context = new BeanContext("org/jmin/test/ioc/autowire/pojo.xml");
	}
	
	/**
	 * 测试通过名字装载
	 */
	public void testByName() throws Throwable {
		Boy boy = (Boy)this.context.getBean("Bean1");
		if(boy!=null){
			if("Chris".equals(boy.getName()) && (28== boy.getAge())){
				System.out.println("[XML].........依据属性名字自动装载测试成功..........");
			}else{
				throw new Error("[XML] ...........依据属性名字自动装载测试失败............");
			}
		}
	}

	/**
	 * 测试通过类型装载
	 */
	public void testByType() throws Throwable {
		Boy boy = (Boy)this.context.getBean("Bean2");
		if(boy!=null){
			if("Chris".equals(boy.getName())&& (28== boy.getAge())){
				System.out.println("[XML]...........依据属性类型自动装载测试成功.............");
			}else{
				throw new Error("[XML]............依据属性类型自动装载测试失败...............");
			}
		}
	}
}