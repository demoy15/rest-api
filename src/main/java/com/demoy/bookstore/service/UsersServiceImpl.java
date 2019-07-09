package com.demoy.bookstore.service;

import com.demoy.bookstore.model.Orders;
import com.demoy.bookstore.model.Users;
import com.demoy.bookstore.repository.OrdersRepository;
import com.demoy.bookstore.repository.UsersRepository;
import com.demoy.bookstore.service.interfaces.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    OrdersRepository ordersRepository;

    @Override
    public Users getById(Long id) {
        return this.usersRepository.getOne(id);
    }

    @Override
    public void save(Users users) {
       this.usersRepository.save(users);
    }

    @Override
    public void delete(Long id) {
        usersRepository.deleteById(id);
    }

    @Override
    public List<Users> getAll() {
        return usersRepository.findAll();
    }

    @Override
    public List<Orders> getAllById(Long id) {
        return ordersRepository.findAllById(id);
    }


}
