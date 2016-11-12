/*
 * Copyright (c) jmin Organization. All rights reserved.
 */
package org.jmin.test.ioc.create;

import org.jmin.ioc.BeanContainer;
import org.jmin.ioc.BeanElementFactory;
import org.jmin.ioc.BeanParameter;
import org.jmin.ioc.BeanParameterFactory;
import org.jmin.ioc.element.InstanceCreation;
import org.jmin.ioc.impl.BeanContainerImpl;
import org.jmin.test.TestCase;
import org.jmin.test.ioc.create.object.Toy;
import org.jmin.test.ioc.create.object.ToyFactory;

/**
 * A IOC creation example
 *
 * @author Chris
 */
public class CreateCase extends TestCase{

	/**
	 * 测试容器
	 */
	private BeanContainer container = null;
	
	/**
	 * 设置环境
	 */
	public void setUp() throws Throwable {
		this.container = new BeanContainerImpl();
		BeanElementFactory beanElementFactory =this.container.getBeanElementFactory();
		BeanParameterFactory beanParameterFactory =this.container.getBeanParameterFactory();
		BeanParameter nameParmeter = beanParameterFactory.createStringParameter("Cat");
		InstanceCreation classCreation = beanElementFactory.createInstanceCreation(new BeanParameter[]{nameParmeter});
		this.container.registerClass("Bean1",Toy.class,classCreation);
		
		InstanceCreation methodCreation = beanElementFactory.createInstanceCreation("create",new BeanParameter[]{nameParmeter});
		this.container.registerClass("Bean2",Toy.class,methodCreation);
		
		InstanceCreation beanCreation = beanElementFactory.createInstanceCreation("factory","create",new BeanParameter[]{nameParmeter});
		this.container.registerClass("Bean3",Toy.class,beanCreation);
		
		this.container.registerClass("factory",ToyFactory.class);
	}
	
	/**
	 * 测试反射构造
	 */
	public void testRelectCreate()throws Throwable{
		Toy toy =(Toy)this.container.getBean("Bean1");
		if(toy!=null){
				System.out.println("[Container].........类反射创建测试成功..........");
			}else{
				throw new Error("[Container]...........类反射创建测试失败............");
			}
	}
	
	/**
	 * 测试工厂方法构造
	 */
	public void testFactoryMethodCreate()throws Throwable{
		Toy toy =(Toy)this.container.getBean("Bean2");
		if(toy!=null){
			System.out.println("[Container].........工厂方法创建测试成功..........");
		}else{
			throw new Error("[Container]...........工厂方法创建测试失败............");
		}
		
	}
	
	/**
	 * 测试工厂Bean构造
	 */
	public void testFactoryBeanCreate()throws Throwable{
		Toy toy =(Toy)this.container.getBean("Bean3");
		if(toy!=null){
			System.out.println("[Container].........工厂Bean测试成功..........");
		}else{
			throw new Error("[Container]...........工厂Bean测试失败............");
		}
	}
}
