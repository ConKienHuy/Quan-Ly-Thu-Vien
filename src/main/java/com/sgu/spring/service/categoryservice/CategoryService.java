package com.sgu.spring.service.categoryservice;

import com.sgu.spring.entity.Category;

import java.util.List;

public interface CategoryService {
    Long getTotalCount();

    List<Category> getAllBySort();

    List<Category> getAll();

    Category get(Long id);

    public Category addNew(Category category);

    public Category save(Category category);

    public void delete(Category category);

    public void delete(Long id);

    public boolean hasForeignkey(Category category);
}
