package com.luke.student.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.luke.student.module.Admin;
import com.luke.student.module.MenuTree;
import com.luke.student.module.MenuTreeV2;
import com.luke.student.service.AdminService;
import com.luke.student.service.MenuTreeV2Service;

@Component("menuTreeV2Action")
@Scope("prototype")
public class MenuTreeV2Action implements SessionAware{
	private MenuTreeV2Service menuTreeV2Service;
	private AdminService adminService;
	
	private InputStream inputStream;
	private Map<String, Object> session;
	
	public String getMenubyAccess() {
		try {
			String adminName = (String) session.get("admin");
			Admin ad = adminService.getAdminbyName(adminName);
			
			String access[] = ad.getAuthor().split(",");
			
			MenuTreeV2 m = menuTreeV2Service.getAllTreeByAccess(access);
			ArrayList<MenuTreeV2> List = new ArrayList<MenuTreeV2>(); 
			List.add(m);
			String jsonString = JSON.toJSONString(List);
			inputStream = new ByteArrayInputStream(jsonString.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return "ajax-success";
	}
	
	public MenuTreeV2Service getMenuTreeV2Service() {
		return menuTreeV2Service;
	}
	@Resource(name = "menuTreeV2Service")
	public void setMenuTreeV2Service(MenuTreeV2Service menuTreeV2Service) {
		this.menuTreeV2Service = menuTreeV2Service;
	}
	public AdminService getAdminService() {
		return adminService;
	}
	@Resource(name = "adminService")
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
	public InputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	
	
}
