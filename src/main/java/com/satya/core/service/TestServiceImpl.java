package com.satya.core.service;

import org.springframework.stereotype.Service;

@Service("tcestService")
public class TestServiceImpl implements TestService {

	public	String findAll(){
		System.out.println("findAll");
		return "findAll";
	}
	public	String findById(){
		System.out.println("findById");
		return "findById";
	}
}
