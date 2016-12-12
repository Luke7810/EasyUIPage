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

public class MenuTreeServiceTree {
	@Test
	public void testGetAllTree() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		MenuTreeService uis = (MenuTreeService) ac.getBean("menuTreeService");
		
		MenuTree m = uis.getAllTree();
		printAllChildren(m);
		
		String jsonString = JSON.toJSONString(m);
		System.out.println(jsonString);
		
		//System.out.println("*****");
		
		//new SchemaExport(new AnnotationConfiguration().configure()).create(false, true);
		//SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		
		
	}
	
	public void printAllChildren(MenuTree m){
		System.out.println("***" + m.getText());
		
		for(MenuTree child : m.getChildren()){
			printAllChildren(child);
		}
	}
	
	@Test
	public void testSaveTree() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		MenuTreeService uis = (MenuTreeService) ac.getBean("menuTreeService");
		
		MenuTree m = new MenuTree();
		m.setText("User Menu");
		m.setIconCls("icon-sum");
		m.setUrl("");
		
		MenuTree m1 = new MenuTree();
		m1.setText("Actions");
		m1.setIconCls("icon-save");
		m1.setUrl("");
		
		MenuTree m2 = new MenuTree();
		m2.setText("Tools");
		m2.setIconCls("icon-cut");
		m2.setUrl("");
		
		MenuTree m3 = new MenuTree();
		m3.setText("User List");
		m3.setIconCls("");
		m3.setUrl("student");
		
		MenuTree m4 = new MenuTree();
		m4.setText("User Form");
		m4.setIconCls("");
		m4.setUrl("Datagrid");
		
		MenuTree m5 = new MenuTree();
		m5.setText("Tools Form 1");
		m5.setIconCls("");
		m5.setUrl("Test1");
		
		MenuTree m6 = new MenuTree();
		m6.setText("Tools Form 2");
		m6.setIconCls("");
		m6.setUrl("Test2");
		
		//=========================
		m.getChildren().add(m1);
		m.getChildren().add(m2);
		
		m1.getChildren().add(m3);
		m1.getChildren().add(m4);
		
		m2.getChildren().add(m5);
		m2.getChildren().add(m6);
		//===========================
		m1.setParent(m);
		m2.setParent(m);
		
		m3.setParent(m1);
		m4.setParent(m1);
		
		m5.setParent(m2);
		m6.setParent(m2);
		//=========================
		uis.saveTree(m);
		
	}
}
