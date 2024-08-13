package com.sgu.spring.service.bookservice;

import com.sgu.spring.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> getAll();

    Book get(Long id);

    Book getByTag(String tag);

    void addNew(Book book);

    Book save(Book book);

    boolean hasUsage(Book book);

    void delete(Long id);

    Long getTotalCount();

    Long getTotalIssuedBooks();
}
