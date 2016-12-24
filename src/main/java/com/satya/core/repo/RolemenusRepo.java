package com.satya.core.repo;


import com.satya.core.bean.Rolemenus;

public interface RolemenusRepo  {
	Rolemenus findByRole(String role);
}
