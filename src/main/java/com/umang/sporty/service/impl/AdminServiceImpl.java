package com.umang.sporty.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.umang.sporty.config.MyUserDetails;
import com.umang.sporty.model.Admin;
import com.umang.sporty.repository.AdminRepository;

@Service
public class AdminServiceImpl implements UserDetailsService{
	@Autowired
	private AdminRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		Admin user = repository.getUserByUsername(username);
		if (user == null) {
            throw new UsernameNotFoundException("Could not find user");
        }
         
        return new MyUserDetails(user);
	}
	
	public boolean updatePass(String oldPass, String newPass) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String oldEncodedPassword = encoder.encode(oldPass);
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
            throw new UsernameNotFoundException("Could not find user");
        }
        if(user.getPassword()==oldEncodedPassword) {
        	user.setPassword(newEncodedPassword);
        	return true;
        }else {
        	return false;
        }
	}
	
}
