package com.umang.sporty.service;

import java.util.List;

import com.umang.sporty.exceptionHandler.BusinessException;
import com.umang.sporty.model.User;

public interface UserService {
	
	public User createUser(User user) throws BusinessException;
	public User updateUser(User user);
	public User getUserById(int uid) throws BusinessException;;
	public User getUserByUserEmail(String userEmail) throws BusinessException;
	public User getUserByMobile(String mobile) throws BusinessException;
	
	public String deleteUser(int uid) throws BusinessException;
	public List<User> getAllUsers() throws BusinessException;
	public List<User> getUserByUserName(String name) throws BusinessException;
}
