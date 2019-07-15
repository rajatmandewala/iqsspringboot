package com.iqsspringboot.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iqsspringboot.repository.UserRepository;
import com.iqsspringboot.resource.UserResource;
import com.iqsspringboot.resource.UserTypeMapper;
import com.iqsspringboot.resource.UserValidCheckResource;


@Service
@Transactional
public class UserService {	
	private UserRepository userRepository;
	private UserTypeMapper userTypeMapper;	

	@Autowired
	public UserService(UserRepository userRepository,UserTypeMapper userTypeMapper) {
		this.userRepository=userRepository;
		this.userTypeMapper=userTypeMapper;
	}	

	public List<UserValidCheckResource> userValidCheck(UserResource userResource){
		List<UserValidCheckResource> userList=new ArrayList<UserValidCheckResource>();
		if(userRepository.findByUserNameAndPassword(userResource.getUserName(),userResource.getPassword())==null){
			return userList;
		}else{
			userList.add(userTypeMapper.fromUsers(userRepository.findByUserNameAndPassword(userResource.getUserName(),userResource.getPassword())));
		}		
		return userList;		
	}
}

