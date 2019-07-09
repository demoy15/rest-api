package com.demoy.bookstore.controllers;


import com.demoy.bookstore.model.Orders;
import com.demoy.bookstore.model.Users;
import com.demoy.bookstore.service.interfaces.UsersService;
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
@RequestMapping("/api/v1/users/")
public class UsersController {

    @Autowired
    UsersService usersService;


    @ApiOperation(value = "Get user by id")
    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Users> getUser(@PathVariable(value = "id") Long id){
       if(id==null){
           return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
       }

       Users users= this.usersService.getById(id);

       if(users==null){
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }

       return new ResponseEntity<>(users,HttpStatus.OK);
    }

    @ApiOperation(value = "Get all orders by id user")
    @GetMapping(value = "/orders/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Orders>> getUserOrders(@PathVariable(value = "id") Long id){


        if(id==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        List<Orders> ordersList= this.usersService.getAllById(id);

        if (ordersList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(ordersList,HttpStatus.OK);
    }


    @ApiOperation(value = "User creation")
    @PostMapping(value = "/post", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Users> saveUser(@RequestBody @Valid Users user){
        HttpHeaders httpHeaders = new HttpHeaders();

        if(user==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.usersService.save(user);
        return new ResponseEntity<>(user,httpHeaders,HttpStatus.OK);
    }

    @ApiOperation(value = "Change user")
    @PatchMapping(value = "",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Users> updateUser(@RequestBody @Valid Users user){


        HttpHeaders headers = new HttpHeaders();
        if(user==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.usersService.save(user);
        return new ResponseEntity<>(user, headers, HttpStatus.OK);
    }

    @ApiOperation(value = "Delete user by id")
    @DeleteMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Users> deleteUser(@PathVariable("id") Long id){
        Users user = this.usersService.getById(id);

        if(user==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.usersService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @ApiOperation(value = "Get all users")
    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Users>> getAllUsers() {
        List<Users> usersList = this.usersService.getAll();
        if (usersList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(usersList, HttpStatus.OK);
    }

}
