package org.jmin.test.ioc.property;

import org.jmin.ioc.impl.config.BeanContext;
import org.jmin.test.TestCase;

public class PropertyXMLCase extends TestCase{
	
	/**
	 * 测试 context
	 */
	private BeanContext context=null;
	
	/**
	 * 设置环境
	 */
	public void setUp() throws Throwable {
		this.context = new BeanContext("org/jmin/test/ioc/property/pojo.xml");
	}
	/**
	 * 属性注入测试
	 */
	public void testInjection() throws Throwable{
		Girl man = (Girl)this.context.getBean("Bean1");
		if(man!=null){
			if("Chris".equals(man.getName()) && (28== man.getAge())){
				System.out.println("[XML].........属性注入测试成功..........");
			}else{
				throw new Error("[XML]...........属性注入测试失败............");
			}
		}
	}
}
