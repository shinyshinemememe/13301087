package com.tgb.container.client;

import com.tgb.container.BeanFactory;
import com.tgb.container.ClassPathXmlApplicationContext;
import com.tgb.container.FileSystemXmlApplicationContext;
import com.tgb.container.service.Service;

public class Client {
	public static void main(String[] args) throws Exception {
		//����·�����������ļ�
		BeanFactory factory = new ClassPathXmlApplicationContext("applicationContext.xml");
		//ʹ���ļ�ϵͳ���������ļ�
//		BeanFactory factory = new FileSystemXmlApplicationContext("src/applicationContext.xml");
		Service service = (Service) factory.getBean("service");
		service.serviceMethod();

	}
}
