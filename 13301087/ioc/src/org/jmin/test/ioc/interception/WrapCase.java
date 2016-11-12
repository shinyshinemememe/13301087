package org.jmin.test.ioc.interception;

import org.jmin.ioc.BeanContainer;
import org.jmin.ioc.BeanElementFactory;
import org.jmin.ioc.element.InvocationInterception;
import org.jmin.ioc.impl.BeanContainerImpl;
import org.jmin.test.TestCase;
import org.jmin.test.ioc.interception.object.Child;
import org.jmin.test.ioc.interception.object.ChildInterceptor;
import org.jmin.test.ioc.interception.object.ChildInterceptor2;

/**
 * 方法拦截测试
 * 
 * @author chris
 *
 */
public class WrapCase extends TestCase{
	
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
		InvocationInterception interception = beanElementFactory.createInvocationInterception("sayHello", new Class[] {java.lang.String.class });
		interception.addInterceptorClass(ChildInterceptor.class);
		interception.addInterceptorClass(ChildInterceptor2.class);
		container.registerClass("Bean2", Child.class);
		container.addInvocationInterception("Bean2",interception);
	}
	
	/**
	 * 方法拦截测试
	 */
	public void testIntercept()throws Throwable{
		Child child = (Child) container.getBean("Bean2");
		child.sayHello("Chris");
		System.out.println("[Container].........AOP类修改拦截测试成功..........");
	}
}