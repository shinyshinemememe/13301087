/*
 * Copyright (c) jmin Organization. All rights reserved.
 */
package org.jmin.test.ioc.autowire;

import org.jmin.ioc.BeanContainer;
import org.jmin.ioc.element.PropertyAutowire;
import org.jmin.ioc.impl.BeanContainerImpl;
import org.jmin.test.TestCase;

/**
 * A IOC Autowire example
 *
 * @author Chris
 */
public class AutowireCase extends TestCase{
	
	/**
	 * 测试容器
	 */
	private BeanContainer container = null;
	
	/**
	 * 设置环境
	 */
	public void setUp() throws Throwable {
		this.container = new BeanContainerImpl();
		this.container.registerClass("Bean1", Boy.class);
		this.container.registerClass("Bean2", Boy.class);
		this.container.setPropertyAutowire("Bean1",PropertyAutowire.BY_NAME);
		this.container.setPropertyAutowire("Bean2",PropertyAutowire.BY_TYPE);
		
		this.container.registerInstance("name", "Chris");
		this.container.registerInstance("age",  new Integer(28));
	}

	/**
	 * 测试通过名字装载
	 */
	public void testByName() throws Throwable {
		Boy boy = (Boy)this.container.getBean("Bean1");
		if(boy!=null){
			if("Chris".equals(boy.getName()) && (28== boy.getAge())){
				System.out.println("[Container].........依据属性名字自动装载测试成功..........");
			}else{
				throw new Error("[Container]...........依据属性名字自动装载测试失败............");
			}
		}
	}

	/**
	 * 测试通过类型装载
	 */
	public void testByType() throws Throwable {
		Boy boy = (Boy)this.container.getBean("Bean2");
		if(boy!=null){
			if("Chris".equals(boy.getName())&& (28== boy.getAge())){
				System.out.println("[Container]...........依据属性类型自动装载测试成功.............");
			}else{
				throw new Error("[Container]............依据属性类型自动装载测试失败...............");
			}
		}
	}
}
