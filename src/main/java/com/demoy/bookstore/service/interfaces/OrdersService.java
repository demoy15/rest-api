package com.demoy.bookstore.service.interfaces;

import com.demoy.bookstore.model.Orders;

import java.util.List;

public interface OrdersService {

    Orders getById(Long id);

    void save(Orders orders);

    void delete(Long id);

    List<Orders> getAll();


}
