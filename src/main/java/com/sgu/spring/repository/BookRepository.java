package com.sgu.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sgu.spring.model.Book;
import com.sgu.spring.model.Category;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
	public Book findByTag(String tag);
	public List<Book> findByCategory(Category category);
	public List<Book> findByCategoryAndStatus(Category category, Integer status);
	public Long countByStatus(Integer status);
}
