package com.umang.sporty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.umang.sporty.exceptionHandler.BusinessException;
import com.umang.sporty.service.AdminService;

@RestController
public class AdminController {
	
	@Autowired
	private AdminService service;
	private MultiValueMap<String, String> errorMap;
	
	public static class UserLoginDetails{
		public String username;
		public String password;
		public UserLoginDetails() {
			
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		
	}
	
	@PostMapping("/loginAdmin")
	public ResponseEntity<String> loginAdmin(@RequestBody UserLoginDetails details){
		try {
			return service.loginAdmin(details.username,details.password);
		} catch (BusinessException e) {
			errorMap=new LinkedMultiValueMap<>();
			errorMap.add("errorMessage", e.getMessage());
			return new ResponseEntity<>(null,errorMap,HttpStatus.UNAUTHORIZED);
		}
	}
	
	public static class BodyReq{
		public String oldPass;
		public String newPass;
		public BodyReq() {
			
		}
		public void setOldPass(String oldPass) {
			this.oldPass = oldPass;
		}
		public void setNewPass(String newPass) {
			this.newPass = newPass;
		}
		
	}
	
	@PutMapping("/changePass")
	public ResponseEntity<String> updatePass(@RequestBody BodyReq bodyObject) {
		try {
			return new ResponseEntity<>(service.updatePass(bodyObject.oldPass, bodyObject.newPass),HttpStatus.OK);
		} catch (BusinessException e) {
			errorMap=new LinkedMultiValueMap<>();
			errorMap.add("errorMessage", e.getMessage());
			return new ResponseEntity<>(null,errorMap,HttpStatus.UNAUTHORIZED);
		}
	}
	
}
