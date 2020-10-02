package com.umang.sporty.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.umang.sporty.model.User;


public interface UserRepository extends JpaRepository<User, Integer>{

	public List<User> findByUserName(String name);
	public User findByUserEmail(String userEmail);
	public User findByMobile(String mobile);
}
