package com.demoy.bookstore.repository;


import com.demoy.bookstore.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for{@link Orders]
 */

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {

    List<Orders> findAllById(Long id);
}
