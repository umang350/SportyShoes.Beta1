package com.umang.sporty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
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
