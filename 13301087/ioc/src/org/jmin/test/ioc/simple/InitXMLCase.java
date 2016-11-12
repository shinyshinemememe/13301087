package org.jmin.test.ioc.simple;

import org.jmin.ioc.impl.config.BeanContext;
import org.jmin.test.TestCase;
import org.jmin.test.ioc.simple.object.Child;
import org.jmin.test.ioc.simple.object.Company;

public class InitXMLCase extends TestCase{
	
	/**
	 * 测试 context
	 */
	private BeanContext context=null;
	
	/**
	 * 设置环境
	 */
	public void setUp() throws Throwable {
		this.context = new BeanContext("org/jmin/test/ioc/simple/pojo.xml");
	}
	
	/**
	 * 测试初始化
	 */
	public void testInit()throws Throwable{
		Company company = (Company) this.context.getBean("Bean1");
		if (company != null) {
			System.out.println("[XML].........初始化测试成功..........");
		} else {
			throw new Error("[XML]...........初始化测试失败............");
		}
	}
	
	/**
	 * 测试单利
	 */
	public void testSingle()throws Throwable{
		if(this.context.getBean("Bean2")== this.context.getBean("Bean2")){
			System.out.println("[XML].........单例测试成功..........");
		}else{
			System.err.println("[XML].........单例化测试失败..........");
		}
		
		if(this.context.getBean("Bean3")!=this.context.getBean("Bean3")){
			System.out.println("[XML].........多例测试成功..........");
		}else{
			System.err.println("[XML].........多例测试失败..........");
		}
	}
	
	/**
	 * 测试Parent
	 */
	public void testParent()throws Throwable{
		Child child =(Child)context.getBean("child");
		if(child!=null && "Chris".equals(child.getName())){
			System.out.println("[XML].........Parent测试成功..........");
		}else{
			System.err.println("[XML].........Parent测试失败..........");
		}
	}
}
