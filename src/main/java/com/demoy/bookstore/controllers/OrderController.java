package com.demoy.bookstore.controllers;


import com.demoy.bookstore.dto.BookDTO;
import com.demoy.bookstore.dto.OrderDTO;
import com.demoy.bookstore.model.Book;
import com.demoy.bookstore.model.Order;
import com.demoy.bookstore.service.interfaces.BookService;
import com.demoy.bookstore.service.interfaces.OrderService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api/v1/order/")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private BookService bookService;

    /** Gets object "Order" by id */
    @ApiOperation(value = "Get order by id")
    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Order> getOrder(@PathVariable(value = "id") Long ordersId){

        if(ordersId==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Order order = orderService.getById(ordersId);

        if(order ==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    /** Creation object "Order" */
    @ApiOperation(value = "Order creation")
    @PostMapping(value = "/post", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Order> saveOrder(@RequestBody OrderDTO orderDTO) {

        if (orderDTO == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        HttpHeaders headers = new HttpHeaders();

            Order order = orderService.save(orderDTO);

            order.setTotalPayment(orderService.sumPriceBook(order.getBooks()));

            return new ResponseEntity<>(order, headers, HttpStatus.CREATED);

    }


    /** Change object "Order" */
    @ApiOperation(value = "Change order")
    @PatchMapping(value = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Order> updateOrder(@RequestBody @Valid OrderDTO order) {
        HttpHeaders headers = new HttpHeaders();

        if(order == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Order order1= this.orderService.save(order);

        order1.setTotalPayment(orderService.sumPriceBook(order1.getBooks()));


        return new ResponseEntity<>(order1, headers, HttpStatus.OK);
    }

    /** Delete object "Order" by id */
    @ApiOperation(value = "Delete order by id")
    @DeleteMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Order> deleteOrder(@PathVariable(value = "id") Long id) {

        Order order = this.orderService.getById(id);

        if(order == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.orderService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /** Gets all objects "Order" */
    @ApiOperation(value = "Get all orders")
    @GetMapping(value = "",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Order>> getAllOrders() {

        List<Order> orderList = this.orderService.getAll();

        if (orderList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(orderList, HttpStatus.OK);
    }

}
