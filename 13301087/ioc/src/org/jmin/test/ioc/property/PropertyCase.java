package org.jmin.test.ioc.property;

import org.jmin.ioc.BeanContainer;
import org.jmin.ioc.BeanElementFactory;
import org.jmin.ioc.BeanParameter;
import org.jmin.ioc.BeanParameterFactory;
import org.jmin.ioc.element.InjectionProperty;
import org.jmin.ioc.impl.BeanContainerImpl;
import org.jmin.test.TestCase;

/**
 * 属性注入测试
 * 
 * @author Chris liao
 *
 */
public class PropertyCase extends TestCase{
	
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
    BeanParameter nameParmeter = beanParameterFactory.createStringParameter("Chris");
    BeanParameter ageParmeter = beanParameterFactory.createIntegerParameter(28);
    InjectionProperty nameProperty = beanElementFactory.createInjectionProperty("name",nameParmeter);
    InjectionProperty ageProperty = beanElementFactory.createInjectionProperty("age",ageParmeter);
		container.registerClass("Bean1", Girl.class, new InjectionProperty[] {nameProperty, ageProperty });
	}
	
	/**
	 * 属性注入测试
	 */
	public void testInjection() throws Throwable{
		Girl man = (Girl)this.container.getBean("Bean1");
		if(man!=null){
			if("Chris".equals(man.getName()) && (28== man.getAge())){
				System.out.println("[Container].........属性注入测试成功..........");
			}else{
				throw new Error("[Container]...........属性注入测试失败............");
			}
		}
	}
}