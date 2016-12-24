package com.satya.core.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.satya.core.bean.MenuMap;

public interface MenuMapRepo extends MongoRepository<MenuMap, Long> {
	MenuMap findByMenuId(Long menuId);
	MenuMap findByMenuIdAndMenuName(Long menuId,String menuName);
	MenuMap findByInstTypeAndRole(String instType,String role);
	MenuMap findByInstTypeAndRoleAndMenuNameIgnoringCase(String instType,String role,String menuName);
}
