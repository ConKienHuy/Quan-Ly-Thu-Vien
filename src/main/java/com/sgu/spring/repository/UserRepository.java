package com.sgu.spring.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sgu.spring.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
	public List<User> findAllByOrderByDisplayNameAsc();
	public List<User> findAllByActiveOrderByDisplayNameAsc(Integer active);
	public Optional<User> findByUsername(String username);
}

