package com.demoy.bookstore.service.interfaces;

import com.demoy.bookstore.model.Orders;
import com.demoy.bookstore.model.Users;

import java.util.List;

public interface UsersService {


    Users getById(Long id);

    void save(Users users);

    void delete(Long id);

    List<Users> getAll();

    List<Orders> getAllById(Long id);



}
