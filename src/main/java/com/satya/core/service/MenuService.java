package com.satya.core.service;
import java.util.Collection;
import java.util.List;

import com.satya.core.bean.CodeTable;
import com.satya.core.bean.MenuMap;
import com.satya.core.bean.SubMenu;


public interface MenuService {
	
	public MenuMap getPages(String instType,String role,String header);
	public List<String> getMenus(String instType,String role);
	public CodeTable findAll();
	public Collection<String> findInstTypes();
	public Collection<String> findInstRoles(String instType);
	public MenuMap getMenuInfo(Long menuId);
	public List<SubMenu> getSubMenus(Long menuId,String menuname);
	public List<MenuMap>getMenuMap(String instType,String role);
	
	public String saveMenu(String instType,String role,String menuName);
	public String updateMenu(String instType,String role,String menuName,String newmenuName);
	
	public String saveMenuSub(Long menuId,String Pagename, String PageLink);
	
	public String updateMenuSub(Long munuId,String pageName,String pageLink,String newpageName,String newpageLink,int dfault);
	public String deleteMenuSub(Long munuId,String pageName,String pageLink,String newpageName,String newpageLink);
	/*	public String saveMenu(Menu m);
	public List<Menu> findMenu(String module);
	public List<SubMenu> findMenuByHeader(String module,String menuName);
	public List<String> findSubMenu(String module,String header);
	
	public List<Menu> findMenus(String module);
	
	public List<Menu>  findRoleMenu(String role);
	
	public List<Menu> findAll();
	
	public Rolemenus saveRoleMenu(Rolemenus  rmenu);
	
	public String assignMenuToRole(Menu menu);
	
	public List<Menu> getMenus(String role);
	public Menu findMenu(Integer menuId);
	
	private static MenuService instance = null;
	private static List<MenuVo> menuList=new ArrayList<MenuVo>();
	private MenuService(List<MenuVo> menuList) {
	   // Exists only to defeat instantiation.
	}
	public static MenuService getInstance() {
	   if(instance == null) {
		   System.out.println("getting list");
		   menuList.add(new MenuVo("admin", "Home", "providerHome"));
		   menuList.add(new MenuVo("admin", "Add Institute", "addInstitute"));
		   menuList.add(new MenuVo("admin", "Update Institute", "updateInstitute"));
		   menuList.add(new MenuVo("admin", "Add Provider", "providerSearch"));
		   menuList.add(new MenuVo("admin", "Update Provider", "updaInstProvider"));
		   menuList.add(new MenuVo("admin", "Admin Request", "requestToAdmin"));
		   menuList.add(new MenuVo("admin", "Logout", "logout"));
	      instance = new MenuService(menuList);
	   }
	   return instance;
	}
	
	public static List<MenuVo> getMenus(){
		return getInstance().menuList;
	}*/
}

