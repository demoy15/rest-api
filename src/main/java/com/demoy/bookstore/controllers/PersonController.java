package com.demoy.bookstore.controllers;


import com.demoy.bookstore.model.Order;
import com.demoy.bookstore.model.Person;
import com.demoy.bookstore.service.interfaces.PersonService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/user/")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService){
        this.personService=personService;
    }

    /**
     * Gets person by id
     */
    @ApiOperation(value = "Gets person by id")
    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Person> getUser(@PathVariable(value = "id") Long id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Person person = this.personService.getById(id);
        if (person == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    /**
     * Gets all objects "Order" by "Person's" id
     */
    @ApiOperation(value = "Gets all orders by id person")
    @GetMapping(value = "/order/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Order>> getUserOrders(@PathVariable(value = "id") Long id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        List<Order> orderList = this.personService.getAllByPersonId(id);
        if (orderList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(orderList, HttpStatus.OK);
    }

    /**
     * Creation object "Person"
     */
    @ApiOperation(value = "Person creation")
    @PostMapping(value = "/post", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Person> saveUser(@RequestBody @Valid Person person) {
        HttpHeaders httpHeaders = new HttpHeaders();
        if (person == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.personService.save(person);
        return new ResponseEntity<>(person, httpHeaders, HttpStatus.OK);
    }

    /**
     * Change object "Person"
     */
    @ApiOperation(value = "Change person")
    @PatchMapping(value = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Person> updateUser(@RequestBody @Valid Person person) {
        HttpHeaders headers = new HttpHeaders();
        if (person == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.personService.save(person);
        return new ResponseEntity<>(person, headers, HttpStatus.OK);
    }

    /**
     * Delete object "Person" by id
     */
    @ApiOperation(value = "Delete person by id")
    @DeleteMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Person> deleteUser(@PathVariable("id") Long id) {
        Person person = this.personService.getById(id);
        if (person == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.personService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * Gets all objects "Person"
     */
    @ApiOperation(value = "Get all persons")
    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Person>> getAllUsers() {
        List<Person> personList = this.personService.getAll();
        if (personList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(personList, HttpStatus.OK);
    }
}
