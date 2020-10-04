package com.umang.sporty.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.umang.sporty.exceptionHandler.BusinessException;
import com.umang.sporty.model.User;
import com.umang.sporty.repository.UserRepository;
import com.umang.sporty.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository repository;
	
	@Override
	public User createUser(User user) throws BusinessException {
		String mob = user.getMobile();
		if(mob.trim().matches("+?[0-9+]{10,12}")) {

			return repository.save(user);
		}else {
			throw new BusinessException("Invalid Mobile Number");
		}
	}

	@Override
	public User updateUser(User user) {
		return repository.save(user);
	}

	@Override
	public User getUserById(int uid) throws BusinessException {
		User user = null;
		try {
			if(uid<=0) {
				throw new BusinessException("Id cannot be negative or zero");
			}
			user = repository.findById(uid).get();
		}catch(NoSuchElementException e) {
			throw new BusinessException("No User found with id = "+uid);
		}
		return user;
	}

	@Override
	public User getUserByUserEmail(String email) throws BusinessException {
		User user = null;
		try {
			user = repository.findByUserEmail(email);
			if(user==null)
				throw new BusinessException("No User found with email = "+email);
		}catch(BusinessException e) {
			throw new BusinessException("No User found with email = "+email);
		}
		return user;
	}

	@Override
	public User getUserByMobile(String mobile) throws BusinessException {
		User user = null;
		try {
			user = repository.findByMobile(mobile);
			if(user==null)
				throw new BusinessException("No User found with mobile = "+mobile);
		}catch(BusinessException e) {
			throw new BusinessException("No User found with mobile = "+mobile);
		}
		return user;
	}

	@Override
	public String deleteUser(int uid) throws BusinessException{
		String output = null;
		try {
			if(uid<=0) {
				throw new BusinessException("Id cannot be negative or zero");
			}
			repository.deleteById(uid);
			output = "Successfully Deleted";
		}catch(EmptyResultDataAccessException e) {
			throw new BusinessException("No User found with id = "+uid);
		}
		return output;
		
	}

	@Override
	public List<User> getAllUsers() throws BusinessException {
		List<User> listOfUsers = repository.findAll();
		if(listOfUsers.size()==0) {
			throw new BusinessException("No User found.");
	    }
		return listOfUsers;
	}

	@Override
	public List<User> getUserByUserName(String name) throws BusinessException {
		List<User> listOfUsers = repository.findByUserName(name);
		if(listOfUsers.size()==0) {
			throw new BusinessException("No User found with name = "+name);
	    }
		return listOfUsers;
	}

}
