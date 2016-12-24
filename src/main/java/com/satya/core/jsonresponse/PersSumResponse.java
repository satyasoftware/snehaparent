package com.satya.core.jsonresponse;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;

import com.satya.core.bean.AdminRequest;
import com.satya.core.bean.CodeTable;
import com.satya.core.bean.Encounter;
import com.satya.core.bean.Institution;
import com.satya.core.bean.Menu;
import com.satya.core.bean.Person;
import com.satya.core.bean.Provider;
import com.satya.core.bean.ProviderInstitute;
import com.satya.core.bean.SubMenu;
import com.satya.core.beanLimit.ProviderL;

public class PersSumResponse extends Response{

	
	private CodeTable codes;
	public CodeTable getCodes() {
		return codes;
	}
	public void setCodes(CodeTable codes) {
		this.codes = codes;
	}
	private String message;
	private boolean instSchedule;
	
	private Collection<String> roles;
	
	private Collection<Person> perList;
	
	private List<Institution> instituList;
	
	private Institution institution;
	
	private Provider provider;
	
	private ProviderInstitute provInst;
	
	private List<String> menuList;
	
	private List<Menu> menusList;
	
	private List<SubMenu> subMeList;
	Collection<Provider> provList;
	
	private Menu menu;
	
	private List<AdminRequest> pendList;
	
	private Page<Person> perPageList;
	
	private Page<Institution> instSearchList;
	
	private Page<Provider> provSearchList;
	
	Map<String,Collection<Provider>> NurseMap;
	
	Map<String,Collection<ProviderL>>  doctMap;
	
	private Encounter encounter;
	
	public Map<String, Collection<ProviderL>> getDoctMap() {
		return doctMap;
	}
	public void setDoctMap(Map<String, Collection<ProviderL>> doctMap) {
		this.doctMap = doctMap;
	}
	public Encounter getEncounter() {
		return encounter;
	}
	public void setEncounter(Encounter encounter) {
		this.encounter = encounter;
	}
	public Collection<String> getRoles() {
		return roles;
	}
	public void setRoles(Collection<String> roles) {
		this.roles = roles;
	}
	public Map<String, Collection<Provider>> getNurseMap() {
		return NurseMap;
	}
	public void setNurseMap(Map<String, Collection<Provider>> nurseMap) {
		NurseMap = nurseMap;
	}
	public Page<Provider> getProvSearchList() {
		return provSearchList;
	}
	public void setProvSearchList(Page<Provider> provSearchList) {
		this.provSearchList = provSearchList;
	}
	public Page<Institution> getInstSearchList() {
		return instSearchList;
	}
	public void setInstSearchList(Page<Institution> instSearchList) {
		this.instSearchList = instSearchList;
	}
	public Page<Person> getPerPageList() {
		return perPageList;
	}
	public void setPerPageList(Page<Person> perPageList) {
		this.perPageList = perPageList;
	}
	public boolean isInstSchedule() {
		return instSchedule;
	}
	public void setInstSchedule(boolean instSchedule) {
		this.instSchedule = instSchedule;
	}
	public Menu getMenu() {
		return menu;
	}
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	public List<SubMenu> getSubMeList() {
		return subMeList;
	}
	public void setSubMeList(List<SubMenu> subMeList) {
		this.subMeList = subMeList;
	}
	public List<Menu> getMenusList() {
		return menusList;
	}
	public void setMenusList(List<Menu> menusList) {
		this.menusList = menusList;
	}

	
	
	public List<Institution> getInstituList() {
		return instituList;
	}
	public void setInstituList(List<Institution> instituList) {
		this.instituList = instituList;
	}
	public List<AdminRequest> getPendList() {
		return pendList;
	}
	public void setPendList(List<AdminRequest> pendList) {
		this.pendList = pendList;
	}
	public List<String> getMenuList() {
		return menuList;
	}
	public void setMenuList(List<String> menuList) {
		this.menuList = menuList;
	}
	public ProviderInstitute getProvInst() {
		return provInst;
	}
	public void setProvInst(ProviderInstitute provInst) {
		this.provInst = provInst;
	}
	public Provider getProvider() {
		return provider;
	}
	public void setProvider(Provider provider) {
		this.provider = provider;
	}
	

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Collection<Person> getPerList() {
		return perList;
	}
	public void setPerList(Collection<Person> perList) {
		this.perList = perList;
	}
	
	

	public Collection<Provider> getProvList() {
		return provList;
	}
	public void setProvList(Collection<Provider> provList) {
		this.provList = provList;
	}
	public Institution getInstitution() {
		return institution;
	}
	public void setInstitution(Institution institution) {
		this.institution = institution;
	}
	
	
}
