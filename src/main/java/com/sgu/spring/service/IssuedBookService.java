package com.sgu.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgu.spring.commonValue.Constants;
import com.sgu.spring.entity.Book;
import com.sgu.spring.entity.IssuedBook;
import com.sgu.spring.repository.IssuedBookRepository;

@Service
public class IssuedBookService {
	
	@Autowired
	private IssuedBookRepository issuedBookRepository;
	
	public List<IssuedBook> getAll() {
		return (List<IssuedBook>) issuedBookRepository.findAll();
	}
	
	public IssuedBook get(Long id) {
		return issuedBookRepository.findById(id).get();
	}
	
	public Long getCountByBook(Book book) {
		return issuedBookRepository.countByBookAndReturned(book, Constants.BOOK_NOT_RETURNED);
	}
	
	public IssuedBook save(IssuedBook issuedBook) {
		return issuedBookRepository.save(issuedBook);
	}
	
	public IssuedBook addNew(IssuedBook issuedBook) {
		issuedBook.setReturned( Constants.BOOK_NOT_RETURNED );
		return issuedBookRepository.save(issuedBook);
	}
}
