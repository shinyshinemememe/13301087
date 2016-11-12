/*
* Copyright (c) jmin Organization. All rights reserved.
*/
package org.jmin.test.ioc.bijection.object;

/**
 * 双向注入类
 * 
 * @author Chris liao
 */
public class Husband {
	
	/**
	 *名字
	 */
	private String name;
	
	/**
	 * 妻子
	 */
	private Wife wife;

	/**
	 *名字
	 */
	public String getName() {
		return name;
	}
	
	/**
	 *名字
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 妻子
	 */
	public Wife getWife() {
		return wife;
	}
	
	/**
	 * 妻子
	 */
	public void setWife(Wife wife) {
		this.wife = wife;
	}
}
