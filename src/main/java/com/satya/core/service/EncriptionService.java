package com.satya.core.service;
public interface EncriptionService {
	 static final byte[] SALT = { (byte) 0x21, (byte) 0x21, (byte) 0xF0,
		(byte) 0x55, (byte) 0xC3, (byte) 0x9F, (byte) 0x5A, (byte) 0x75 };

 final static int ITERATION_COUNT = 31;
 
 
 public String encode(String input);
 public String decode(String token);
}
