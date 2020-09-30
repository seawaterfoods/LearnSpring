package com.joe.retailforest.service;

import org.springframework.stereotype.Service;


public interface AESService {
	
	
	String encrypt(String value, String hashKey, String hashIv);
	
	String decrypt(String value, String hashKey, String hashIv);
	
	String getSHA256(String input);

}
