package com.luke.student.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.luke.student.dao.AdminDao;
import com.luke.student.module.Admin;

@Component("adminService")
public class AdminService {
	private AdminDao adminDao;
	
	public List<Admin> adminList() {
		return adminDao.getAllAdmin();
	}
	
	public Admin getAdminbyName(String adminName){
		return adminDao.getAdminbyName(adminName);
	}
	
	public boolean checkAdminbyname(String adminName){
		return adminDao.checkAdminbyName(adminName);
	}
	
	public boolean checkAdminLogin(String adminName, String adminpwd){
		if(adminName.trim()=="" || adminpwd.trim()=="") {
			return false;
		}else{
			if(adminDao.checkAdminbyLogin(adminName, adminpwd)){
				return true;
			}
		}
		return false;
	}
	
	//------All Setter and getter------------------
	public AdminDao getAdminDao() {
		return adminDao;
	}
	@Resource(name = "adminDao")
	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}
	
	
}
