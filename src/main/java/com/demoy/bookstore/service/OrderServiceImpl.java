package com.demoy.bookstore.service;

import com.demoy.bookstore.dto.OrderDTO;
import com.demoy.bookstore.mapper.OrderMapper;
import com.demoy.bookstore.model.Book;
import com.demoy.bookstore.model.Order;
import com.demoy.bookstore.repository.OrderRepository;
import com.demoy.bookstore.service.interfaces.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderMapper orderMapper;

    /** Gets object "Order" by id */
    @Override
    public Order getById(Long id) {
        return orderRepository.getOne(id);
    }

    /** Save object "Order" */
    @Override
    public Order save(OrderDTO order) {
       Order order1 = orderMapper.toOrder(order);
       return orderRepository.save(order1);
   }

    /** Delete object "Order" by id */
    @Override
    public void delete(Long id) {
        orderRepository.deleteById(id);
    }

    /** Gets all objects "Order" */
    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    /** Summing the prices of all books in the order */
    public Long sumPriceBook(List<Book> bookList){
       Long result=0L;
       for(Book a:bookList){
          result+=a.getPrice();
       }
       return result;
    }
}
