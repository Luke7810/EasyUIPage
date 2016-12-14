package com.luke.student.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.luke.student.module.MenuTree;
import com.luke.student.service.MenuTreeService;


@Component("menuTreeAction")
@Scope("prototype")
public class MenuTreeAction {
	private MenuTreeService menuTreeService;
	private InputStream inputStream;
	
	public String getMenuTree(){
		
		try {
			ArrayList<MenuTree> List = new ArrayList<MenuTree>(); 
			MenuTree m = menuTreeService.getAllTree();
			List.add(m);
			String jsonString = JSON.toJSONString(List);
			inputStream = new ByteArrayInputStream(jsonString.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "ajax-success";
	}
	
	public MenuTreeService getMenuTreeService() {
		return menuTreeService;
	}
	@Resource(name="menuTreeService")
	public void setMenuTreeService(MenuTreeService menuTreeService) {
		this.menuTreeService = menuTreeService;
	}
	public InputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	
	
}
