package com.demoy.bookstore.repository;


import com.demoy.bookstore.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for{@link Books]
 */

@Repository
public interface BooksRepository extends JpaRepository<Books,Long> {


}
