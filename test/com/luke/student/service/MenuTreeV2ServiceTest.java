package com.luke.student.service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import com.alibaba.fastjson.JSON;
import com.luke.student.module.MenuTree;
import com.luke.student.module.MenuTreeV2;

public class MenuTreeV2ServiceTest {
	@Test
	public void testGetAllTree() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		MenuTreeV2Service uis = (MenuTreeV2Service) ac.getBean("menuTreeV2Service");
		
		MenuTreeV2 m = uis.getAllTree();
		
		String jsonString = JSON.toJSONString(m);
		System.out.println(jsonString);
		
	}
	

	@Test
	public void testGetTreeByAccess() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		MenuTreeV2Service uis = (MenuTreeV2Service) ac.getBean("menuTreeV2Service");
		
		String access[] = {"2"};
		
		MenuTreeV2 m = uis.getAllTreeByAccess(access);
		
		String jsonString = JSON.toJSONString(m);
		System.out.println(jsonString);
	}
	
	@Test
	public void testGetRootNode() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		MenuTreeV2Service uis = (MenuTreeV2Service) ac.getBean("menuTreeV2Service");
		
		System.out.println(uis.getRootNode());
	}
	
	@Test
	public void testGetNodeById() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		MenuTreeV2Service uis = (MenuTreeV2Service) ac.getBean("menuTreeV2Service");
		
		MenuTreeV2 m = uis.getTreeById(8);
		
		System.out.println(m.getText());
	}
}
