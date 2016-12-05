package com.luke.student.dao;
import java.util.List;

import com.luke.student.module.*;
import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

@Component("adminDao")
public class AdminDao {
	private HibernateTemplate hibernateTemplate;
	
	public List<Admin> getAllAdmin() {
		return hibernateTemplate.find("from Admin");
	}
	
	public Admin getAdminbyName(String adminName) {
		List<Admin> ls =  hibernateTemplate.find("from Admin ad where ad.adminname = '"+adminName+"'");
		if(ls.size()>0){
			return ls.get(0);
		}else{
			return null;
		}
	}
	
	public boolean checkAdminbyName(String adminName){
		if(hibernateTemplate.find("from Admin ad where ad.adminname = '"+adminName+"'").size() > 0) {
			return true;
		}else{
			return false;
		}
	}
	
	public boolean checkAdminbyLogin (String adminName, String adminpwd) {
		String hql = "from Admin ad where ad.adminname='"+adminName+"' and ad.adminpwd='"+adminpwd+"'";
		if(hibernateTemplate.find(hql).size() > 0){
			return true;
		}else{
			return false;
		}
	}
	
	//------ All Setter and getter --------------------
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	@Resource(name="hibernateTemplate")
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	
}
