package com.demoy.bookstore.service;

import com.demoy.bookstore.model.Books;
import com.demoy.bookstore.repository.BooksRepository;
import com.demoy.bookstore.service.interfaces.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BooksServiceImpl implements BooksService {

    @Autowired
    BooksRepository booksRepository;


    @Override
    public Books getById(Long id) {
        return booksRepository.getOne(id);
    }

    @Override
    public void save(Books books) {
        booksRepository.save(books);
    }

    @Override
    public void delete(Long id) {
        booksRepository.deleteById(id);
    }

    @Override
    public List<Books> getAll() {
        return booksRepository.findAll();
    }





}
