package com.demoy.bookstore.service.interfaces;

import com.demoy.bookstore.model.Order;
import com.demoy.bookstore.model.Person;

import java.util.List;

public interface PersonService {

    Person getById(Long id);

    void save(Person person);

    void delete(Long id);

    List<Person> getAll();

    List<Order> getAllByPersonId(Long id);
}
