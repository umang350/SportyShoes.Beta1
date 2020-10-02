package com.umang.sporty.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.umang.sporty.config.MyUserDetails;
import com.umang.sporty.exceptionHandler.BusinessException;
import com.umang.sporty.model.Admin;
import com.umang.sporty.repository.AdminRepository;
import com.umang.sporty.service.AdminService;

@Service
public class AdminControlServiceImpl implements AdminService{
	@Autowired
	private AdminRepository repository;
	
	public String updatePass(String oldPass, String newPass) throws BusinessException {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String newEncodedPassword = encoder.encode(newPass);
        Object principal= SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username ="";
        if(principal instanceof UserDetails) {
        	username = ((UserDetails)principal).getUsername();
        }else {
        	username = principal.toString();
        }
        Admin user = repository.getUserByUsername(username);
        if (user == null) {
            throw new BusinessException("Could not find user");
        }
        if(encoder.matches(oldPass, user.getPassword())) {
        	System.out.println(newEncodedPassword);
        	user.setPassword(newEncodedPassword);
        	repository.save(user);
        	return "Password Successfully Changed";
        }else {
        	throw new BusinessException("Old Password Mismatch");
        }
	}
        
        @Override
    	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
    		Admin user = repository.getUserByUsername(username);
    		if (user == null) {
                throw new UsernameNotFoundException("Could not find user");
            }
             
            return new MyUserDetails(user);
    	}
        
        
}

	
