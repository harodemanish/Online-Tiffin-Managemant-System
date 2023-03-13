package com.example.practice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.practice.model.User;
import com.example.practice.repositories.UserRepositry;

@Service
public class UserService {
	
	
	@Autowired
	private UserRepositry userRepositry;
	
//	public UserService(@Autowired UserRepositry userRepositry) {
//		super();
//		System.out.println("Inside userservice constructor");
//		this.userRepositry = userRepositry;
//	}
	public java.util.List<User> getAllUsers() {
		 return userRepositry.findAll();
	}
	
	public User addUser(User user,UserRepositry userRepositry) {
		return userRepositry.save(user);
	}
	public User addUser(User user) {
		return userRepositry.save(user);
	}
}
