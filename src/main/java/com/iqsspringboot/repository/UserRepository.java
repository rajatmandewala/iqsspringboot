package com.iqsspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.iqsspringboot.model.Users;

public interface UserRepository extends JpaRepository<Users, Long>{
	
	public Users findByUserNameAndPassword(String userName,String password);
	
}