package com.satya.core.service;
import java.util.List;

import com.satya.core.bean.AdminRequest;
import com.satya.core.bean.RequestCorresponds;
import com.satya.core.bean.SpAdmin;

public interface SpAdminService {
	public SpAdmin save(SpAdmin supAdmin);
	public SpAdmin update(SpAdmin supAdmin);
	public SpAdmin checkForLogin(final String userId, final String password);
	
	public List<AdminRequest>	getAllRequests(String status);
	
	public AdminRequest getAdmRequest(Long admReqId,Long instId);
	public AdminRequest	updateAdmRequestStatus(RequestCorresponds admCorr);
}
