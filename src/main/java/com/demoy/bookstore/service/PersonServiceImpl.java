package com.demoy.bookstore.service;

import com.demoy.bookstore.model.Order;
import com.demoy.bookstore.model.Person;
import com.demoy.bookstore.repository.OrderRepository;
import com.demoy.bookstore.repository.PersonRepository;
import com.demoy.bookstore.service.interfaces.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    OrderRepository orderRepository;

    /** Gets object "Person" by id */
    @Override
    public Person getById(Long id) {
        return this.personRepository.getOne(id);
    }

    /** Save object "Person" */
    @Override
    public void save(Person person) {
       this.personRepository.save(person);
    }

    /** Delete object "Person" by id */
    @Override
    public void delete(Long id) {
        personRepository.deleteById(id);
    }

    /** Gets all objects "Person" */
    @Override
    public List<Person> getAll() {
        return personRepository.findAll();
    }

    /** Gets all objects "Order" by "Person's" id*/
    @Override
    public List<Order> getAllByPersonId(Long id) {
        return orderRepository.findAllByPersonId(id);
    }
}
