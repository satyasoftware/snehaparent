package com.satya.core.service;

import java.util.List;

import com.satya.core.bean.AdminRequest;

public interface AdmReqService {
	public AdminRequest saveRequest(AdminRequest req);
	public List<AdminRequest>	getPendingRequest(Long provId,String admReqstatus);
	//public void saveUser();
}
