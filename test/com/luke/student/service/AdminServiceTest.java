package com.luke.student.service;

import java.util.List;

import org.junit.Test;

import com.luke.student.module.Admin;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AdminServiceTest {
	@Test
	public void testgetAdminbyName(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		AdminService uis = (AdminService) ac.getBean("adminService");
		
		String sname = "admin-6";
		Admin ad = uis.getAdminbyName(sname);
		if(null==ad){
			System.out.println("**********"+sname+" is not a admin");
		}else{
			System.out.println("**********"+ad.getAdminpwd());
		}
	}
	
	@Test
	public void testCheckAdminbyname(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		AdminService uis = (AdminService) ac.getBean("adminService");
		
		
		String sname = "admin-7";
		if(uis.checkAdminbyname(sname)){
			System.out.println("************get admin");
		}else{
			System.out.println("************Not get admin");
		}
	}
	
	@Test
	public void testCheCkAdminLogin(){
		String sname = "admin-1";
		String spwd = "123456";
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		AdminService uis = (AdminService) ac.getBean("adminService");
		if(uis.checkAdminLogin(sname, spwd)){
			System.out.println("************admin login");
		}else{
			System.out.println("************admin login failed");
		}
	}
	
	@Test
	public void testGetAllAdmin() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		AdminService uis = (AdminService) ac.getBean("adminService");
		
		List<Admin> ls = uis.adminList();
		for(Admin ad : ls){
			System.out.println("*********"+ad.getAdminname());
		}
	}
}
