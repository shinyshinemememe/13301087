package org.jmin.test.ioc.create;

import org.jmin.ioc.impl.config.BeanContext;
import org.jmin.test.TestCase;
import org.jmin.test.ioc.create.object.Toy;

/**
 * A IOC creation example
 *
 * @author Chris
 */
public class CreatetXMLCase extends TestCase{

	/**
	 * 测试 context
	 */
	private BeanContext context=null;
	
	/**
	 * 设置环境
	 */
	public void setUp() throws Throwable {
		this.context = new BeanContext("org/jmin/test/ioc/create/pojo.xml");
	}
	
	/**
	 * 测试反射构造
	 */
	public void testRelectCreate()throws Throwable{
		Toy toy =(Toy)this.context.getBean("Bean1");
		if(toy!=null){
				System.out.println("[XML].........类反射创建测试成功..........");
			}else{
				throw new Error("[XML]...........类反射创建测试失败............");
			}
	}
	
	/**
	 * 测试工厂方法构造
	 */
	public void testFactoryMethodCreate()throws Throwable{
		Toy toy =(Toy)this.context.getBean("Bean2");
		if(toy!=null){
			System.out.println("[XML].........工厂方法创建测试成功..........");
		}else{
			throw new Error("[XML]...........工厂方法创建测试失败............");
		}
		
	}
	
	/**
	 * 测试工厂Bean构造
	 */
	public void testFactoryBeanCreate()throws Throwable{
		Toy toy =(Toy)this.context.getBean("Bean3");
		if(toy!=null){
			System.out.println("[XML].........工厂Bean测试成功..........");
		}else{
			throw new Error("[XML]...........工厂Bean测试失败............");
		}
	}
}