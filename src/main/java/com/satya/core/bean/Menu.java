package com.satya.core.bean;

import java.util.List;

public class Menu {
	private String name;
	private Boolean dfault;
	private List<SubMenu> submenu;
	public Menu(){
	
	}
	public Menu(String name, List<SubMenu> submenu) {
		super();
		this.name = name;
		this.submenu = submenu;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public List<SubMenu> getSubmenu() {
		return submenu;
	}
	public void setSubmenu(List<SubMenu> submenu) {
		this.submenu = submenu;
	}
	
	public Boolean getDfault() {
		return dfault;
	}
	public void setDfault(Boolean dfault) {
		this.dfault = dfault;
	}
	
	
	
	
	
	/*@NotEmpty private String module;
	@NotEmpty private String menuname;
	@NotEmpty private String menulink;
	
	@Transient private String role;
	@Transient
	@NotEmpty private String menuType;
	@Transient private String existheadMenus;
	@Transient
	 private String existsideMenus;
	
	private List<SubMenu> submenu;
	
	private Set<String> roleList;
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public List<SubMenu> getSubmenu() {
		return submenu;
	}
	public void setSubmenu(List<SubMenu> submenu) {
		this.submenu = submenu;
	}
	public Set<String> getRoleList() {
		return roleList;
	}
	public void setRoleList(Set<String> roleList) {
		this.roleList = roleList;
	}
	public String getExistsideMenus() {
		return existsideMenus;
	}
	public void setExistsideMenus(String existsideMenus) {
		this.existsideMenus = existsideMenus;
	}
	public String getExistheadMenus() {
		return existheadMenus;
	}
	public void setExistheadMenus(String existheadMenus) {
		this.existheadMenus = existheadMenus;
	}
	public Integer getMenuId() {
		return menuId;
	}
	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}
	
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
	}
	
	
	public String getMenuType() {
		return menuType;
	}
	public void setMenuType(String menuType) {
		this.menuType = menuType;
	}
	public String getMenuname() {
		return menuname;
	}
	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}
	public String getMenulink() {
		return menulink;
	}
	public void setMenulink(String menulink) {
		this.menulink = menulink;
	}
	*/
	
}
