package com.luke.student.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.luke.student.dao.MenuTreeV2Dao;
import com.luke.student.module.MenuTreeV2;

@Component("menuTreeV2Service")
public class MenuTreeV2Service {
	private MenuTreeV2Dao menuTreeV2Dao;

	@SuppressWarnings("unchecked")
	public MenuTreeV2 getTreeById(int rootId) {
		MenuTreeV2 rootNode = menuTreeV2Dao.getNodeById(rootId);
		List<MenuTreeV2> childNodes = menuTreeV2Dao.getChildNodeByPid(rootId);
		
		for(MenuTreeV2 child : childNodes){
			MenuTreeV2 n = getTreeById(child.getId());
			rootNode.children.add(n);
		}
		return rootNode;
	}
	
	public MenuTreeV2 getTreeByIdWithAccess(int rootId, String access[]){
		MenuTreeV2 rootNode = menuTreeV2Dao.getNodeById(rootId);
		List<MenuTreeV2> childNodes = menuTreeV2Dao.getChildNodeByPidWithAcces(rootId, access);
		
		for(MenuTreeV2 child : childNodes){
			MenuTreeV2 n = getTreeById(child.getId());
			rootNode.children.add(n);
		}
		return rootNode;
	}
	
	public MenuTreeV2 getAllTree(){
		return getTreeById(menuTreeV2Dao.getRootNodeId());
	}
	
	public MenuTreeV2 getAllTreeByAccess(String access[]){
		return getTreeByIdWithAccess(menuTreeV2Dao.getRootNodeId(), access);
	}
	
	public int getRootNode(){
		return menuTreeV2Dao.getRootNodeId();
	}

	
	public MenuTreeV2Dao getMenuTreeV2Dao() {
		return menuTreeV2Dao;
	}
	@Resource(name="menuTreeV2Dao")
	public void setMenuTreeV2Dao(MenuTreeV2Dao menuTreeV2Dao) {
		this.menuTreeV2Dao = menuTreeV2Dao;
	}
}
