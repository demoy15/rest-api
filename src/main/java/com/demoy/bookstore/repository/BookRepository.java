package com.demoy.bookstore.repository;


import com.demoy.bookstore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for{@link Book]
 */

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
