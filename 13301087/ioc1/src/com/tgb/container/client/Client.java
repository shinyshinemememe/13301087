package com.tgb.container.client;

import com.tgb.container.BeanFactory;
import com.tgb.container.ClassPathXmlApplicationContext;
import com.tgb.container.FileSystemXmlApplicationContext;
import com.tgb.container.service.Service;

public class Client {
	public static void main(String[] args) throws Exception {
		//从类路径加载配置文件
		BeanFactory factory = new ClassPathXmlApplicationContext("applicationContext.xml");
		//使用文件系统加载配置文件
//		BeanFactory factory = new FileSystemXmlApplicationContext("src/applicationContext.xml");
		Service service = (Service) factory.getBean("service");
		service.serviceMethod();

	}
}
