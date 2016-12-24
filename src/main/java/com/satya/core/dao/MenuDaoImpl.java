package com.satya.core.dao;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.satya.core.bean.Appointment;
import com.satya.core.bean.Menu;
import com.satya.core.bean.MenuMap;
import com.satya.core.bean.SubMenu;


@Repository ("MenuDao")
public class MenuDaoImpl implements MenuDao {
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public List<SubMenu> getMenuItems(List<Integer> subMenuIds){
		Query query = new Query();
        query.addCriteria(Criteria.where("submenuId").in(subMenuIds));
		query.fields().include("_id").include("name");
	List<SubMenu> submenus=mongoTemplate.find(query, SubMenu.class);
	System.out.println("size="+submenus.size());
	return submenus;
	}
	
	@Override
	public List<MenuMap> getMenus(String instType,String role){
		Query query = new Query();
		Criteria criteria = new Criteria();
		criteria.andOperator(Criteria.where("instType").in(instType),Criteria.where("role").in(role));
        query.addCriteria(criteria);
        query.with(new Sort(Sort.Direction.ASC,"menuId"));
        //query.fields().include("_id").include("menuName").include("dfault");
        System.out.println("criteria="+criteria.getCriteriaObject());
	   return mongoTemplate.find(query, MenuMap.class);
	    
	}
	@Override
	public String save(MenuMap menumap){
		menumap.setMenuId(getMaxMenuId());
		mongoTemplate.save(menumap);
		return "success";
	}
	@Override
	public String update(MenuMap menumap){
		menumap.setMenuId(getMaxMenuId());
		mongoTemplate.save(menumap);
		return "success";
	}
	@Override
	public List<SubMenu> getPages(String instType,String role,String header){
		Query query = new Query();
		Criteria criteria = new Criteria();
		criteria.andOperator(Criteria.where("instType").in(instType),Criteria.where("role").in(role),Criteria.where("menuName").in(header));
        query.addCriteria(criteria);
        query.fields().include("_id").include("submenuList");
        System.out.println("criteria "+criteria.getCriteriaObject());
	  List<MenuMap> menus=mongoTemplate.find(query, MenuMap.class);
	   System.out.println("size="+menus.size());
	   //List<SubMenu> subList=menus.get(0).getSubmenu();
	   if(menus!=null && menus.size()>0){
	    return menus.get(0).getSubmenuList();
	   }
	   else return null;
	}
	
	@Override
	public Long getMaxMenuId(){
		Long maxid=1L;
		Query query = new Query();
		query.with(new Sort(Sort.Direction.DESC,"menuId"));
        query.limit(1);
		query.fields().include("menuId");
		MenuMap sub=mongoTemplate.findOne(query, MenuMap.class);
		if(sub==null || sub.getMenuId()==null) maxid= 1L;
		else  maxid=sub.getMenuId()+1L;
		System.out.println("MenuMap maxid="+maxid);
		return maxid;
	}
	
	
	
	
	
	@Override
	public List<Menu> getMenus(List<Integer> menuIds){
		Query query = new Query();
        query.addCriteria(Criteria.where("menuId").in(menuIds));
		query.fields().include("_id").include("menuname");
	List<Menu> submenus=mongoTemplate.find(query, Menu.class);
	System.out.println("size="+submenus.size());
	
	//System.out.println("Max="+getMaxId());
	return submenus;
	}
	/*@Override
	public Integer getRoleMenuMaxId(){
		//Integer maxid=1;
		Query query = new Query();
		query.with(new Sort(Sort.Direction.DESC,"rolemenuId"));
        query.limit(1);
		query.fields().include("_id");
		Rolemenus sub=mongoTemplate.findOne(query, Rolemenus.class);
		return sub.getRolemenuId();
		
	}*/
	
	@Override
	public Long getAppointmentId(){
		//Integer maxid=1;
		try{
		Query query = new Query();
		query.with(new Sort(Sort.Direction.DESC,"appointmentId"));
        query.limit(1);
		query.fields().include("_id");
		Appointment appo=mongoTemplate.findOne(query, Appointment.class);
		if(appo==null || appo.getAppointmentId()==null) return 1L;
		else return appo.getAppointmentId()+1;
		}catch(Exception e){e.printStackTrace();}
		return 1L;
	}
	
	
}
