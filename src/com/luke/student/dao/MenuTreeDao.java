package com.luke.student.dao;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.luke.student.module.MenuTree;

@Component("menuTreeDao")
public class MenuTreeDao {
	private HibernateTemplate hibernateTemplate;
	
	public MenuTree getAllTree() {
		return (MenuTree) hibernateTemplate.find("from MenuTree m where parent is null").get(0);
		//return (MenuTree) hibernateTemplate.find("from MenuTree m where m.id=8").get(0);
	}
	
	public void saveMenuTree(MenuTree m){
		hibernateTemplate.save(m);
	}
	
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Resource(name = "hibernateTemplate")
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

}
