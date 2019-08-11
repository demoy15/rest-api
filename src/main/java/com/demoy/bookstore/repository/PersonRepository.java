package com.demoy.bookstore.repository;

import com.demoy.bookstore.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for {@link Person}
 */

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
