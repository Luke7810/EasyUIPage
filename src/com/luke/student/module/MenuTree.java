package com.luke.student.module;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tree")
public class MenuTree {
	private int id;
	private String text;
	private String url;
	private String iconCls;
	private Set<MenuTree> children = new HashSet<MenuTree>();
	private MenuTree parent;
	
	
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getIconCls() {
		return iconCls;
	}
	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}
	
	@OneToMany(mappedBy="parent" , cascade = CascadeType.ALL, fetch = FetchType.EAGER )
	public Set<MenuTree> getChildren() {
		return children;
	}
	public void setChildren(Set<MenuTree> children) {
		this.children = children;
	}
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER )
	@JoinColumn(name="pid")
	public MenuTree getParent() {
		return parent;
	}
	public void setParent(MenuTree parent) {
		this.parent = parent;
	}
	@Override
	public String toString() {
		return "MenuTree [id=" + id + ", text=" + text + ", url=" + url
				+ ", iconCls=" + iconCls + ", children=" + children
				+ ", parent=" + parent + "]";
	}
	
	
}
