package org.jmin.test.ioc.invocation;

import org.jmin.ioc.BeanContainer;
import org.jmin.ioc.BeanElementFactory;
import org.jmin.ioc.BeanParameter;
import org.jmin.ioc.BeanParameterFactory;
import org.jmin.ioc.element.InjectionInvocation;
import org.jmin.ioc.impl.BeanContainerImpl;
import org.jmin.test.TestCase;

/**
 * 调用注入
 * 
 * @author Chris Liao 
 */
public class InvocationCase  extends TestCase{

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
		BeanParameter helloParmeter = beanParameterFactory.createStringParameter("Chris");
		InjectionInvocation invocation = beanElementFactory.createInjectionInvocation("sayHello",new BeanParameter[] {helloParmeter });
		this.container.registerClass("Bean1", Man.class, new InjectionInvocation[] {invocation });
	}

	/**
	 * 测试方法调用注入
	 */
	public void testByName() throws Throwable {
		Man boy = (Man)this.container.getBean("Bean1");
		if(boy!=null){
			if("Chris".equals(boy.getName())){
				System.out.println("[Container]........方法调用测试成功..........");
			}else{
				throw new Error("[Container]..........方法调用测试失败............");
			}
		}
	}
}