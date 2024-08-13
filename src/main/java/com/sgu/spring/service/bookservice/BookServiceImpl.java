package com.sgu.spring.service.bookservice;

import com.sgu.spring.entity.Book;
import com.sgu.spring.repository.BookRepository;
import com.sgu.spring.commonValue.Constants;
import com.sgu.spring.service.IssuedBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    private IssuedBookService issuedBookService;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, IssuedBookService issudedBookService) {
        this.bookRepository = bookRepository;
        this.issuedBookService = issudedBookService;
    } // Constructor Injection

    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book get(Long id) {
        return bookRepository.getOne(id);
    }

    @Override
    public Book getByTag(String tag) {
        return bookRepository.findByTag(tag);
    }

    @Override
    public void addNew(Book book) {
        book.setCreateDate(new Date());
        book.setStatus(Constants.BOOK_STATUS_AVAILABLE);
        bookRepository.save(book);
    }

    @Override
    public Book save(Book book) {
       return bookRepository.save(book);
    }

    @Override
    public boolean hasUsage(Book book) {
        return issuedBookService.getCountByBook(book)>0;
    }

    @Override
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Long getTotalCount() {
        return bookRepository.count();
    }

    @Override
    public Long getTotalIssuedBooks() {
        return bookRepository.countByStatus(Constants.BOOK_NOT_RETURNED);
    }
}
