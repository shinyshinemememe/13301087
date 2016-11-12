package org.jmin.test.ioc.simple;

import org.jmin.ioc.BeanContainer;
import org.jmin.ioc.impl.BeanContainerImpl;
import org.jmin.test.TestCase;
import org.jmin.test.ioc.simple.object.Company;

/**
 * 初始化测试
 * 
 * @author Chris 
 */
public class InitCase extends TestCase{
	
	/**
	 * 测试容器
	 */
	private BeanContainer container = null;
	
	/**
	 * 设置环境
	 */
	public void setUp() throws Throwable {
		this.container = new BeanContainerImpl();
		this.container.registerClass("Bean1",Company.class);
		this.container.setInitMethodName("Bean1","init");
		this.container.setDestroyMethodName("Bean1","destroy");
		
		this.container.registerClass("Bean2",Company.class);
		this.container.registerClass("Bean3",Company.class);
		this.container.setInstanceSingleton("Bean2",true);
		this.container.setInstanceSingleton("Bean3",false);
	}
	
	/**
	 * 测试初始化
	 */
	public void testInit()throws Throwable{
		Company company = (Company) this.container.getBean("Bean1");
		if (company != null) {
			System.out.println("[Container].........初始化测试成功..........");
		} else {
			throw new Error("[Container]...........初始化测试失败............");
		}
	}
	
	/**
	 * 测试单利
	 */
	public void testSingle()throws Throwable{
		if(this.container.getBean("Bean2")== this.container.getBean("Bean2")){
			System.out.println("[Container].........单例测试成功..........");
		}else{
			System.out.println("[Container].........单例化测试成功..........");
		}
		
		if(this.container.getBean("Bean3")!=this.container.getBean("Bean3")){
			System.out.println("[Container].........多例测试成功..........");
		}else{
			System.out.println("[Container].........多例测试成功..........");
		}
	}
}