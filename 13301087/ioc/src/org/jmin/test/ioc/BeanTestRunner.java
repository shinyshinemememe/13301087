package org.jmin.test.ioc;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

import org.jmin.ioc.impl.util.ClassUtil;
import org.jmin.test.TestRunner;

public class BeanTestRunner {
	
	/**
	 * 默认配置文件名
	 */
	private static String defaultFilename="testCase.properties";
	
	/**
	 * 装载测试配置文件
	 */
	private static Class[] getTestCaseClasses()throws Exception{
		return getTestCaseClasses(defaultFilename);
	}
	
	/**
	 * 装载测试配置文件
	 */
	private static Class[] getTestCaseClasses(String caseFile)throws Exception{
		List classList = new ArrayList();
		InputStream propertiesStream = null;
		try {
			Properties properties = new SortKeyProperties();
			propertiesStream = BeanTestRunner.class.getResourceAsStream(caseFile);
			if(propertiesStream==null)
				throw new FileNotFoundException(caseFile);
			
			properties.load(propertiesStream);
			Enumeration enumtion = properties.keys();
			while(enumtion.hasMoreElements()){
				Class clazz = ClassUtil.loadClass((String)enumtion.nextElement());
				classList.add(clazz);
			}
			
			return (Class[])classList.toArray(new Class[0]);

		} finally {
		  if(propertiesStream !=null)
				try {
					propertiesStream.close();
				} catch (IOException e) {
				}
		}
	}
	
	/**
	 * 测试入口
	 */
	public static void main(String[] ags)throws Throwable{
		TestRunner.run(getTestCaseClasses());
	}
}
