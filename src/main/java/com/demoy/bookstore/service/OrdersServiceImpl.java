package com.demoy.bookstore.service;

import com.demoy.bookstore.model.Orders;
import com.demoy.bookstore.repository.OrdersRepository;
import com.demoy.bookstore.service.interfaces.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    OrdersRepository ordersRepository;



    @Override
    public Orders getById(Long id) {
        return ordersRepository.getOne(id);
    }

    @Override
    public Orders save(Orders orders) {
       return this.ordersRepository.save(orders);
    }

    @Override
    public void delete(Long id) {
        ordersRepository.deleteById(id);
    }

    @Override
    public List<Orders> getAll() {
        return ordersRepository.findAll();
    }


}
