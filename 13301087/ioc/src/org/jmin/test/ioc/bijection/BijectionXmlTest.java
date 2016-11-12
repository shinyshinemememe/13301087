/*
* Copyright (c) jmin Organization. All rights reserved.
 */
package org.jmin.test.ioc.bijection;

import org.jmin.ioc.impl.config.BeanContext;
import org.jmin.test.TestCase;
import org.jmin.test.ioc.bijection.object.Husband;
import org.jmin.test.ioc.bijection.object.Wife;

/**
 * A IOC Bijection demo
 *
 * @author Chris
 */
public class BijectionXmlTest extends TestCase{
	
	/**
	 * 测试 context
	 */
	private BeanContext context=null;
	
	/**
	 * 设置环境
	 */
	public void setUp() throws Throwable {
		this.context = new BeanContext("org/jmin/test/ioc/bijection/pojo.xml");
	}
	/**
	 * 测试双向注入
	 */
	public void testBijection()throws Throwable{
		Wife wife =(Wife)this.context.getBean("Wife");
		Husband husband =	(Husband)this.context.getBean("Husband");
		if(wife!=null && wife.getHusband()==husband){
			System.out.println("[XML].........双向注入测试成功..........");
		}else{
			System.out.println("[XML].........双向注入测试失败..........");
		}
	}
	
}