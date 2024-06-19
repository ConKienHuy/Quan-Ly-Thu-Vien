package com.sgu.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sgu.spring.model.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
	public List<Category> findAllByOrderByNameAsc();
}
