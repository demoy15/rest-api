package com.demoy.bookstore.service.interfaces;

import com.demoy.bookstore.dto.OrderDTO;
import com.demoy.bookstore.model.Book;
import com.demoy.bookstore.model.Order;

import java.util.List;

public interface OrderService {

    Order getById(Long id);

    Order save(OrderDTO order);

    void delete(Long id);

    List<Order> getAll();

    Long sumPriceBook(List<Book> bookList);
}
