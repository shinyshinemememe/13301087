/*
 * Copyright (c) jmin Organization. All rights reserved.
 */
package org.jmin.test.ioc.bijection;

import org.jmin.ioc.BeanContainer;
import org.jmin.ioc.BeanElementFactory;
import org.jmin.ioc.BeanParameter;
import org.jmin.ioc.BeanParameterFactory;
import org.jmin.ioc.element.InjectionProperty;
import org.jmin.ioc.impl.BeanContainerImpl;
import org.jmin.test.TestCase;
import org.jmin.test.ioc.bijection.object.Husband;
import org.jmin.test.ioc.bijection.object.Wife;

/**
 * 双向注入测试
 * 
 * @author Chris Liao
 */
public class BijectionTest extends TestCase{

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
		BeanParameter WifNameParmeter =  beanParameterFactory.createStringParameter("Summer");
		InjectionProperty WifenameProperty = beanElementFactory.createInjectionProperty("name",WifNameParmeter);
		BeanParameter HusbandParmeter =  beanParameterFactory.createReferenceParameter("Husband");
		InjectionProperty HusbandProperty =  beanElementFactory.createInjectionProperty("husband",HusbandParmeter);
		this.container.registerClass("Wife",Wife.class,new InjectionProperty[] {WifenameProperty,HusbandProperty});
		
		BeanParameter HusNameParmeter =  beanParameterFactory.createStringParameter("Chris");
		InjectionProperty HusNameProperty = beanElementFactory.createInjectionProperty("name",HusNameParmeter);
		BeanParameter WifeParmeter =  beanParameterFactory.createReferenceParameter("Wife");
		InjectionProperty WifeProperty =  beanElementFactory.createInjectionProperty("wife",WifeParmeter);
		this.container.registerClass("Husband",Husband.class,new InjectionProperty[] {HusNameProperty,WifeProperty});
	}
	
	/**
	 * 测试双向注入
	 */
	public void testBijection()throws Throwable{
		Wife wife =(Wife)this.container.getBean("Wife");
		Husband husband =	(Husband)this.container.getBean("Husband");
		if(wife!=null && wife.getHusband()==husband){
			System.out.println("[Container].........双向注入测试成功..........");
		}else{
			System.out.println("[Container].........双向注入测试失败..........");
		}
	}
}