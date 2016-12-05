package com.luke.student.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.luke.student.service.AdminService;

@Component("loginAction")
@Scope("prototype")
public class AdminAction {
	private AdminService adminService;
	private String adminname;
	private String adminpwd;
	private InputStream inputStream;
	
	public String checkAdminLogin() {
		try {
			if(adminService.checkAdminLogin(adminname, adminpwd)){
				inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
			}else{
				inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "login";
	}
	
	//-------All Setter and getter---------
	public AdminService getAdminService() {
		return adminService;
	}
	@Resource(name = "adminService")
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
	public String getAdminname() {
		return adminname;
	}
	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}
	public String getAdminpwd() {
		return adminpwd;
	}
	public void setAdminpwd(String adminpwd) {
		this.adminpwd = adminpwd;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	
	
	
}
