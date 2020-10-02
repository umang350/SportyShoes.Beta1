package com.umang.sporty.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.umang.sporty.model.Admin;

public interface AdminRepository extends CrudRepository<Admin, Integer>{

	@Query("SELECT u FROM Admin u WHERE u.username = :username")
    public Admin getUserByUsername(@Param("username") String username);
}
