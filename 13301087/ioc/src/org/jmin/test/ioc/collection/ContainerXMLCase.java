/*
 * Copyright (c) jmin Organization. All rights reserved.
 */
package org.jmin.test.ioc.collection;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jmin.ioc.impl.config.BeanContext;
import org.jmin.test.TestCase;

/**
 * A IOC Autowire example
 *
 * @author Chris
 */
public class ContainerXMLCase extends TestCase{
	
	/**
	 * 测试 context
	 */
	private BeanContext context=null;
	
	/**
	 * 设置环境
	 */
	public void setUp() throws Throwable {
		this.context = new BeanContext("org/jmin/test/ioc/collection/pojo.xml");
	}
	
	/**
	 * 测试List
	 */
	public void testList()throws Throwable{
		School school = (School)this.context.getBean("school");
		List roomList = school.getRoomList();
		Set classSet = school.getClassSet();
		Map teacherMap= school.getTeacherMap();
		
		if(roomList!=null&&roomList.size()==3){
			System.out.println("[XML].........List测试成功..........");
		}else{
			throw new Error("[XML].........List测试失败..........");
		}
		
		if(classSet!=null&&classSet.size()==3){
			System.out.println("[XML].........Set测试成功..........");
		}else{
			throw new Error("[XML].........Set测试失败..........");
		}
		
		if(teacherMap!=null&&teacherMap.size()==3){
			System.out.println("[XML].........Map测试成功..........");
		}else{
			throw new Error("[XML].........Map测试失败..........");
		}
	}
}