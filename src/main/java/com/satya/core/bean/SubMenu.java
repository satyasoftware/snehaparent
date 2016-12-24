package com.satya.core.bean;

import java.io.Serializable;

public class SubMenu implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String pagename;
	private String pagelink;
	public boolean dfault; //'Y' or 'N'
	public boolean isDfault() {
		return dfault;
	}
	public void setDfault(boolean dfault) {
		this.dfault = dfault;
	}
	
	public String getPagename() {
		return pagename;
	}
	public void setPagename(String pagename) {
		this.pagename = pagename;
	}
	public String getPagelink() {
		return pagelink;
	}
	public void setPagelink(String pagelink) {
		this.pagelink = pagelink;
	}
	
	
	
	
	/*private Set<String> roles;
	
	
	public Set<String> getRoles() {
		return roles;
	}
	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}
	public Integer getSubmenuId() {
		return submenuId;
	}
	public void setSubmenuId(Integer submenuId) {
		this.submenuId = submenuId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}*/
	
}
