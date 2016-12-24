package com.satya.core.dao;
import java.util.List;

import com.satya.core.bean.Menu;
import com.satya.core.bean.MenuMap;
import com.satya.core.bean.SubMenu;

public interface MenuDao {
	public List<SubMenu> getMenuItems(List<Integer> subMenuIds);
	public List<Menu> getMenus(List<Integer> menuIds);
	
	/*public Integer getRoleMenuMaxId();*/
	
	public Long getMaxMenuId();
	
	public List<MenuMap> getMenus(String instType,String role);
	
	public Long getAppointmentId();
	
	public String save(MenuMap menumap);
	public String update(MenuMap menumap);
	public List<SubMenu> getPages(String instType,String role,String header);
}
