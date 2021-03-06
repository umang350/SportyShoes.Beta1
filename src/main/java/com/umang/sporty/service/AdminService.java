package com.umang.sporty.service;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.umang.sporty.exceptionHandler.BusinessException;

public interface AdminService {

	UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
	
	public String updatePass(String oldPass, String newPass) throws BusinessException;
	public ResponseEntity<String> loginAdmin(String username, String password) throws BusinessException;
}
