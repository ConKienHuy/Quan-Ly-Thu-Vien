package com.sgu.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sgu.spring.model.Book;
import com.sgu.spring.model.IssuedBook;

@Repository
public interface IssuedBookRepository extends CrudRepository<IssuedBook, Long> {
	public Long countByBookAndReturned(Book book, Integer returned);
}
