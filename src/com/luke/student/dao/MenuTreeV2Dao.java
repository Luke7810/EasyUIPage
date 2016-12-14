package com.luke.student.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.luke.student.module.MenuTreeV2;

@Component("menuTreeV2Dao")
public class MenuTreeV2Dao {
	private HibernateTemplate hibernateTemplate;

	
	public MenuTreeV2 getNodeById(int id){
		return (MenuTreeV2) hibernateTemplate.find("from MenuTreeV2 m where m.id="+id).get(0);
	}
	
	public List<MenuTreeV2> getChildNodeByPid (int id){
		return  hibernateTemplate.find("from MenuTreeV2 m where m.pid="+id);
	}
	
	public List<MenuTreeV2> getChildNodeByPidWithAcces(int id, String access[]){
		String hql = "from MenuTreeV2 m where m.pid="+id+" and ";
		String strAc = "(";
		for(int i=0; i<access.length; i++){
			if(i == 0) {
				strAc = strAc + "m.access like '%"+access[i]+"%' ";
			}else{
				strAc = strAc + " OR m.access like '%"+access[i]+"%' ";
			}
		}
		
		strAc = strAc + ")";
		
		hql = hql + strAc;
		
		return  hibernateTemplate.find(hql);
	}
	
	
	public int getRootNodeId(){
		MenuTreeV2 m = (MenuTreeV2) hibernateTemplate.find("from MenuTreeV2 m where m.pid = 0").get(0);
		return m.getId();
	}

	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	@Resource(name="hibernateTemplate")
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	
}
