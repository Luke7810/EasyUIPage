package com.luke.student.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.luke.student.dao.MenuTreeDao;
import com.luke.student.module.MenuTree;

@Component("menuTreeService")
public class MenuTreeService {
	private MenuTreeDao menuTreeDao;

	public MenuTree getAllTree() {
		return menuTreeDao.getAllTree();
	}
	
	public void saveTree(MenuTree m){
		menuTreeDao.saveMenuTree(m);
	}
	
	public MenuTreeDao getMenuTreeDao() {
		return menuTreeDao;
	}

	@Resource(name="menuTreeDao")
	public void setMenuTreeDao(MenuTreeDao menuTreeDao) {
		this.menuTreeDao = menuTreeDao;
	}
	
	
}
