package com.satya.core.bean;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
@SuppressWarnings("serial")
@Document(collection="MENUMAP")
public class MenuMap implements Serializable {

	@Id private Long menuId;
	private String instType;
	private String role;
	private String menuName;
	private boolean dfault; 
	@Transient private boolean isdefau;
	
	
	
	public boolean isIsdefau() {
		return isdefau;
	}
	public void setIsdefau(boolean isdefau) {
		this.isdefau = isdefau;
	}
	public boolean isDfault() {
		return dfault;
	}
	public void setDfault(boolean dfault) {
		this.dfault = dfault;
	}
	
	private List<SubMenu> submenuList;
	
	@Transient private SubMenu submenu;
	@Transient private String existmenu;

	public Long getMenuId() {
		return menuId;
	}
	

	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	public String getInstType() {
		return instType;
	}

	public void setInstType(String instType) {
		this.instType = instType;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}



	public SubMenu getSubmenu() {
		return submenu;
	}

	public void setSubmenu(SubMenu submenu) {
		this.submenu = submenu;
	}

	public List<SubMenu> getSubmenuList() {
		return submenuList;
	}

	public void setSubmenuList(List<SubMenu> submenuList) {
		this.submenuList = submenuList;
	}

	public String getExistmenu() {
		return existmenu;
	}

	public void setExistmenu(String existmenu) {
		this.existmenu = existmenu;
	}
	
	
	
	
}
