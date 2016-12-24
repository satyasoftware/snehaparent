package com.satya.core.repo;



import org.springframework.data.mongodb.repository.MongoRepository;

import com.satya.core.bean.Menu;

public interface MenuRepo extends MongoRepository<Menu,Integer> {

/*	Menu findByModuleAndMenuname(String module,String menu);
	List<Menu> findByModule(String module);
	List<Menu> findAll();
	Menu findByMenuId(Integer menuId);*/
}
