package com.tiffinservice.TiffinService.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiffinservice.TiffinService.Entities.User;
import com.tiffinservice.TiffinService.Repositry.UserRepositry;

@Service
public class UserService {

	@Autowired
	private UserRepositry userRepository;

	public User save(User user2) {
		return userRepository.save(user2);
		
	}
}
