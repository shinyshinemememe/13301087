/*
*Copyright (c) jmin Organization. All rights reserved.
 */
package org.jmin.test.ioc.interception.object;

import java.lang.reflect.Method;

import org.jmin.ioc.BeanInterceptor;

/**
 * A interceptor class for IOC test
 *
 * @author Chris Liao
 */

public class ChildInterceptor2 implements BeanInterceptor{

	 /**
	  * intercept method
	  */
	 public void before(final Object bean,Method method,Object[] params)throws Throwable{
	 	System.out.println("ManInterceptor3 before");
	 }
	 
	 /**
	  * intercept method
	  */
	 public void after(final Object bean,Method method,Object[] params,final Object result)throws Throwable{
	 	System.out.println("ManInterceptor3 after");
	 }
	 
	 /**
	  * intercept method
	  */
	 public void afterThrowing(final Object bean,Method method,Object[] params,Throwable throwable)throws Throwable{
	 	System.out.println("ManInterceptor3 afterThrowing");
	 }
	 
	 /**
	  * intercept method
	  */
	 public void afterFinally(final Object bean,Method method,Object[] params,final Object result,Throwable throwable)throws Throwable{
	 	System.out.println("ManInterceptor3 afterFinally");
	 }
}