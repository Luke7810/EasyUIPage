package com.luke.student.service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.fastjson.JSON;
import com.luke.student.module.MenuTree;

public class MenuTreeServiceTest {
	@Test
	public void testGetAllTree() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		MenuTreeService uis = (MenuTreeService) ac.getBean("menuTreeService");
		
		MenuTree m = uis.getAllTree();
		
		String jsonString = JSON.toJSONString(m);
		System.out.println(jsonString);
	}
}
