package com.budovyy.service;

import com.budovyy.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> getAll();

    Optional<Category> getById(Long id);

    Optional<Category> create(Category category);


    Optional<Category> update(Category category);
}
