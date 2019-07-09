package com.demoy.bookstore.repository;

import com.demoy.bookstore.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for {@link Users}
 */

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

}
