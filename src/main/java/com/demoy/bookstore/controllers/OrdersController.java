package com.demoy.bookstore.controllers;


import com.demoy.bookstore.model.Orders;
import com.demoy.bookstore.service.interfaces.OrdersService;
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
@RequestMapping("/api/v1/orders/")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;


    @ApiOperation(value = "Get order by id")
    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Orders> getOrder(@PathVariable(value = "id") Long ordersId){
        if(ordersId==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Orders orders = this.ordersService.getById(ordersId);

        if(orders==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @ApiOperation(value = "Order creation")
    @PostMapping(value = "/post", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Orders> saveOrder(@RequestBody Orders order) {

        if (order == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if(order.getBooks().equals(null)){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        this.ordersService.save(order);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(order, headers, HttpStatus.CREATED);
    }


    @ApiOperation(value = "Change order")
    @PatchMapping(value = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Orders> updateOrder(@RequestBody @Valid Orders order) {
        HttpHeaders headers = new HttpHeaders();

        if(order == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.ordersService.save(order);

        return new ResponseEntity<>(order, headers, HttpStatus.OK);
    }

    @ApiOperation(value = "Delete order by id")
    @DeleteMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Orders> deleteOrder(@PathVariable(value = "id") Long id) {
        Orders orders = this.ordersService.getById(id);

        if(orders == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.ordersService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ApiOperation(value = "Get all orders")
    @GetMapping(value = "",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Orders>> getAllOrders() {
        List<Orders> ordersList = this.ordersService.getAll();
        if (ordersList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(ordersList, HttpStatus.OK);
    }
}
