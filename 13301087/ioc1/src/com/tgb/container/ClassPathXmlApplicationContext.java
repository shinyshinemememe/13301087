package com.tgb.container;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.xpath.XPath;

import com.tgb.container.dao.Dao;
import com.tgb.container.service.Service;
/**
 * ����·�����������ļ�
 * @author liang
 *
 */
public class ClassPathXmlApplicationContext implements BeanFactory{
	
	//�����ĺ��ģ��������ע���Bean
	private Map<String, Object> beans =new HashMap<String, Object>();
	
	
	//����xml�ļ���ͨ�����佫���õ�beasn�ŵ�container��
	public ClassPathXmlApplicationContext(String fileName) throws Exception{
		//����SAXBuilder����
		SAXBuilder saxBuilder = new SAXBuilder();
		//��ȡ��Դ�����document����
		Document doc = saxBuilder.build(this.getClass().getClassLoader().getResourceAsStream(fileName));
		//��ȡ��Ԫ��
		Element rootEle = doc.getRootElement();
		//�Ӹ�Ԫ�ػ�����е���Ԫ�أ�����Ԫ�ؼ���
		List listBean = XPath.selectNodes(rootEle, "/beans/bean");
		  
		//������Ԫ�ص���Ԫ�ؼ��ϣ�ɨ�������ļ��е�bean
		for (int i = 0; i < listBean.size(); i++) { 			  
		   Element bean = (Element) listBean.get(i);
		   String id = bean.getAttributeValue("id");
		   String clazz = bean.getAttributeValue("class");
		   //���䣬ʵ����
		   Object o = Class.forName(clazz).newInstance();
		   beans.put(id, o);
		  }
		
		//���ﻹ��������ԭ����һ����
		Service service =(Service)beans.get("service");
		Dao dao = (Dao)beans.get("dao");
		//����ע�룬Serviceʵ������dao��ʵ��
		service.setDao(dao);
		
	}
	

	
	/**
	 * �������
	 * 
	 * @param id
	 * @return
	 */
	@Override
	public Object getBean(String id) {
		return beans.get(id);
	}

}