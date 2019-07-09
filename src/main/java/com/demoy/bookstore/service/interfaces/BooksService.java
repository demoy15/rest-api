package com.demoy.bookstore.service.interfaces;

import com.demoy.bookstore.model.Books;

import java.util.List;

public interface BooksService {

    Books getById(Long id);

    void save(Books books);

    void delete(Long id);

    List<Books> getAll();
}
