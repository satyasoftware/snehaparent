package com.satya.core.service;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satya.core.bean.CodeTable;
import com.satya.core.bean.InstitutionType;
import com.satya.core.bean.MenuMap;
import com.satya.core.bean.SubMenu;
import com.satya.core.dao.MenuDao;
import com.satya.core.repo.CodetablesRepo;
import com.satya.core.repo.MenuMapRepo;

@Service
//@Transactional(readOnly = true)
public class MenuServiceImpl implements MenuService {
	@Autowired  private MenuDao menuDao;
	
	@Autowired	private MenuMapRepo menuMapRepo;
	
	//@Autowired private CodetablesRepo codetableRepo;

	//public static CodeTable codetab=null;

public List<String> getMenus(String instType,String role){
	List<String> menunames=new ArrayList<String>();
	System.out.println("instType"+instType+"= instType=="+role);
	List<MenuMap> menus= menuDao.getMenus(instType, role);
	System.out.println();
	for(MenuMap m:menus){
		menunames.add(m.getMenuName());
	}
	return menunames;
}

@Override
public List<MenuMap>getMenuMap(String instType,String role){
	System.out.println("instType"+instType+"= instType=="+role);
	return menuDao.getMenus(instType, role);
}

@Override
public List<SubMenu> getSubMenus(Long menuId,String menuname){
	MenuMap m= menuMapRepo.findByMenuIdAndMenuName(menuId, menuname);
	if(m!=null) return m.getSubmenuList();
	else return null;

}


@Override
public MenuMap getMenuInfo(Long menuId){
	 return menuMapRepo.findByMenuId(menuId);

}

public MenuMap getPages(String instType,String role,String menuName){
	 return menuMapRepo.findByInstTypeAndRoleAndMenuNameIgnoringCase(instType, role, menuName);

}

@Override
public CodeTable findAll(){
	/*if(codetab==null){
		System.out.println("Codetables data empty so fetch");
		codetab=new CodeTable();
    List<CodeTable> codetables=codetableRepo.findAll();
    codetab=codetables.get(0) ;
	}else System.out.println("Codetables data exist");*/
    return CodeTable.getInstance() ;
}

public Collection<String> findInstTypes(){
	CodeTable cod=findAll();
	Collection<InstitutionType> instTypes=cod.getInstType();
	Collection<String> inst= new TreeSet<String>();
	for(InstitutionType inType:instTypes){
		inst.add(inType.getInstType());
	}
	return inst;
}

public Collection<String> findInstRoles(String instType){
	CodeTable cod=findAll();
	Collection<InstitutionType> instTypes=cod.getInstType();
	Collection<String> roles= new TreeSet<String>();
	for(InstitutionType inType:instTypes){
		if(inType.getInstType().equalsIgnoreCase(instType)){
			roles=inType.getRoles();
		}
	}
	return roles;
}


	@Override
	public String saveMenuSub(Long munuId,String pageName,String pageLink){
		MenuMap menumap=menuMapRepo.findByMenuId(munuId);
		String status="";
		if(menumap!=null){
			List<SubMenu>menus=menumap.getSubmenuList();
			if(menus!=null && menus.size()>0){
				SubMenu sm=new SubMenu();
				sm.setPagename(pageName);
				sm.setPagelink(pageLink);
				menus.add(sm);
			}
			else {
				menus=new ArrayList<SubMenu>();	
				SubMenu sm=new SubMenu();
				sm.setPagename(pageName);
				sm.setPagelink(pageLink);
				menus.add(sm);
			}
			menumap.setSubmenuList(menus);
			menuMapRepo.save(menumap);
		}
		return status;
	}

	@Override
	public String updateMenuSub(Long munuId,String pageName,String pageLink,String newpageName,String newpageLink,int dfault){
		MenuMap menumap=menuMapRepo.findByMenuId(munuId);
		String status="";
		if(menumap!=null){
			List<SubMenu> menus=menumap.getSubmenuList();
			if(menus!=null && menus.size()>0){
				for(SubMenu s:menus){
					if(s.getPagename().equalsIgnoreCase(pageName)){
						s.setPagename(newpageName);
						s.setPagelink(newpageLink);
						if(dfault==1){
							 s.setDfault(true);
						     menumap.setDfault(true);
						}
						else {
							s.setDfault(false);
						    menumap.setDfault(false);
						}
						
						break;
					}
				}
			}
			
			menumap.setSubmenuList(menus);
			menuMapRepo.save(menumap);
		}
		return status;
	}
	
	@Override
	public String deleteMenuSub(Long munuId,String pageName,String pageLink,String newpageName,String newpageLink){
		MenuMap menumap=menuMapRepo.findByMenuId(munuId);
		String status="";
		if(menumap!=null){
			List<SubMenu> menus=menumap.getSubmenuList();
			if(menus!=null && menus.size()>0){
				for(SubMenu s:menus){
					if(s.getPagename().equalsIgnoreCase(pageName)){
						menus.remove(s);
						break;
					}
				}
			}
			
			menumap.setSubmenuList(menus);
			menuMapRepo.save(menumap);
		}
		return status;
	}

	@Override
	public String saveMenu(String instType,String role,String menuName){
		String status="";
		
		MenuMap menumap=menuMapRepo.findByInstTypeAndRoleAndMenuNameIgnoringCase(instType, role, menuName);
		if(menumap==null){
			MenuMap menuma=new MenuMap();
			menuma.setMenuId(menuDao.getMaxMenuId());
			menuma.setInstType(instType);
			menuma.setRole(role);
			menuma.setMenuName(menuName);
			menuma.setDfault(false);
			List<SubMenu> sub=new ArrayList<SubMenu>();
			menuma.setSubmenuList(sub);
			try{
			menuMapRepo.save(menuma);
			 status="This Menu Name Added";
			}catch(Exception e){e.printStackTrace();}
		}else status="This Menu Name Already Exist";
		
		return status;
	}
	
	@Override
	public String updateMenu(String instType,String role,String menuName,String newmenuName){
		MenuMap menumap=menuMapRepo.findByInstTypeAndRoleAndMenuNameIgnoringCase(instType, role, menuName);
		String status="";
		if(menumap!=null){
			menumap.setMenuName(newmenuName);
			menuMapRepo.save(menumap);
			status="This Menu Name Updated";
		}
		
		return status;
	}
	
	/*public String saveMenudfdzfgfhgx(String instType,String role,String menuName){
		MenuMap menumap=menuMapRepo.findByInstTypeAndRole(instType, role);
		String status="";
		boolean exist=false;
		if(menumap!=null){
			List<Menu> menus=menumap.getMenus();
			if(menus!=null && menus.size()>0){
				Menu exmenu=null;
				for(Menu m:menus){
					if(m.getName().equalsIgnoreCase(menuName)){
						exist=true;
						status=" Menu Name Already Exist";
						exmenu=m;
						break;
					}
				}
				if(!exist){
					menus=new ArrayList<Menu>();
					Menu m=new Menu();
					m.setName(menuName);
					//m.setDfault(mstatus);
					List<SubMenu> sub=new ArrayList<SubMenu>();
					m.setSubmenu(sub);
					menus.add(m);
					status="New Menu Name Added";
					menumap.setMenus(menus);
				}
				menuMapRepo.save(menumap);
				
			} else {
				menus=new ArrayList<Menu>();
				Menu m=new Menu();
				m.setName(menuName);
				List<SubMenu> sub=new ArrayList<SubMenu>();
				m.setSubmenu(sub);
				menus.add(m);
				status="New Menu Name Added";
				menumap.setMenus(menus);
			}
			
			menuMapRepo.save(menumap);
		}else{
			List<Menu> menus=new ArrayList<Menu>();
			menumap=new MenuMap();
			menumap.setMenuId(menuDao.getMaxId());
			menumap.setInstType(instType);
			menumap.setRole(role);
			Menu m=new Menu();
			m.setName(menuName);
			List<SubMenu> sub=new ArrayList<SubMenu>();
			m.setSubmenu(sub);
			menus.add(m);
			menumap.setMenus(menus);
			menuMapRepo.save(menumap);
			status="New Role Menu Added";
		}
		return status;
	}*/
	/*menuMapRepo.save(menuMap);
	
	String status="";
	if(m.getMenuType().equals("Header")){
		 m.setMenuId(menuDao.getMaxId());
		 List<SubMenu> subList=new ArrayList<SubMenu>();
		// String[] roles={};
		 
		 m.setSubmenu(subList);
		 //Set<String> roleSet=new HashSet<String>();
		 
		 //Set<String> roleSet=new HashSet<String>();
		 //m.setRoleList(roleSet);
	      menuRepo.save(m);
	      status="New Header Added";
	}else if(m.getMenuType().equals("Side") && m.getExistheadMenus()!=null){
		SubMenu sub=new SubMenu();
		Set<String> roles=new HashSet<String>();
		 sub.setRoles(roles);
		sub.setName(m.getMenuname());
		sub.setLink(m.getMenulink());
		Menu existMenu =menuRepo.findByModuleAndMenuname(m.getModule(),m.getExistheadMenus());
		List<SubMenu> subList=new ArrayList<SubMenu>();
		if(existMenu!=null && existMenu.getSubmenu()!=null)
			subList=existMenu.getSubmenu();
				subList.add(sub);
				menuRepo.save(existMenu);
				 status="New Side Menu Item Added To Header "+m.getExistheadMenus();
			
	}*/
	
/*
@Override
public String assignMenuToRole(Menu menu){
	String status="";
	Menu existMenu =menuRepo.findByMenuId(menu.getMenuId());
	List<SubMenu> sub=new ArrayList<SubMenu>();
	sub=existMenu.getSubmenu();
	for(SubMenu subm:sub){
		if(subm.getName().equals(menu.getExistheadMenus())){
			Set<String> roles=new HashSet<String>();
			roles=subm.getRoles();
			roles.add(menu.getRole());
			break;
		}
	}
	menuRepo.save(existMenu);
	 status="This Menu is assigned to this role";
	return status;
}
@Override
public List<Menu> findAll(){
	return menuRepo.findAll();
}
	@Override
	public List<Menu> findMenu(String module){
		return menuRepo.findByModule(module);
}
	
	@Override
	public List<SubMenu> findMenuByHeader(String module,String menuName){
		Menu menu= menuRepo.findByModuleAndMenuname(module,menuName);
		if(menu!=null &&  menu.getSubmenu()!=null)
		return menu.getSubmenu();
		else return null;
		
}
	@Override
	public Rolemenus saveRoleMenu(Rolemenus  rmenu){
		Rolemenus roleMenu =roleMenuRepo.findByRole(rmenu.getRole());
		if(roleMenu==null){
			
			rmenu.setRolemenuId(menuDao.getRoleMenuMaxId());
		}
		rmenu.setRolemenuId(menuDao.getRoleMenuMaxId());
		
		return roleMenu;
	}
	@Override
	public List<Menu>  findRoleMenu(String role){
		Rolemenus roleMenu =roleMenuRepo.findByRole(role);
		if(roleMenu==null) return null;
		//List<String> head=new ArrayList<String>();
		List<Integer> menuid=roleMenu.getMenuIds(); 
		return menuDao.getMenus(menuid);
}
	@Override
	public List<Menu> findMenus(String module){
		return menuRepo.findByModule(module);
		
}
	@Override
	public Menu findMenu(Integer menuId){
		return menuRepo.findByMenuId(menuId);
     }	
	
	@Override
	public List<Menu> getMenus(String role){
		return menuDao.getMenus(role);
	}
	
	
	public Rolemenus saveroleMenu(Rolemenus r){
		return roleMenuRepo.save(r);
	}*/
}
