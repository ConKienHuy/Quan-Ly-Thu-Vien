package com.sgu.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgu.spring.entity.User;
import com.sgu.spring.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User authorize(String name, String pass) {
		User user = userRepository.findByUsername(name)
				// Hàm lamba kiểm tra password có đúng không nếu user tồn tại
				.filter(userExisted -> userExisted.getPassword().equals(pass)) 
				.orElse(null);
		
		return user;
	}
	
	
}
