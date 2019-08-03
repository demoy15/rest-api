package com.demoy.bookstore.repository;


import com.demoy.bookstore.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for{@link Order]
 */

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findAllByPersonId(Long id);
}
