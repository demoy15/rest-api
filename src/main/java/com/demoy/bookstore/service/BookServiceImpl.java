package com.demoy.bookstore.service;

import com.demoy.bookstore.model.Book;
import com.demoy.bookstore.repository.BookRepository;
import com.demoy.bookstore.service.interfaces.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    /**
     * Gets object "Book" by id
     */
    @Override
    public Book getById(Long id) {
        return bookRepository.getOne(id);
    }

    /**
     * Save object "Book"
     */
    @Override
    public void save(Book book) {
        this.bookRepository.save(book);
    }

    /**
     * Delete object "Book" by id
     */
    @Override
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }

    /**
     * Gets all objects "Book"
     */
    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }
}
