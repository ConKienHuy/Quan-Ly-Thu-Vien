package com.sgu.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sgu.spring.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
	public List<User> findAllByOrderByDisplayNameAsc();
	public List<User> findAllByActiveOrderByDisplayNameAsc();
	public User findByUsername(String username);
}

