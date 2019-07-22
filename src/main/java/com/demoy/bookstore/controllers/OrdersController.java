package com.demoy.bookstore.controllers;


import com.demoy.bookstore.dto.OrdersDTO;
import com.demoy.bookstore.model.Books;
import com.demoy.bookstore.model.Orders;
import com.demoy.bookstore.service.interfaces.BooksService;
import com.demoy.bookstore.service.interfaces.OrdersService;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.List;


@RestController
@RequestMapping("/api/v1/orders/")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private BooksService booksService;


    @ApiOperation(value = "Get order by id")
    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<OrdersDTO> getOrder(@PathVariable(value = "id") Long ordersId){
        if(ordersId==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }


        Orders orders = this.ordersService.getById(ordersId);

        OrdersDTO ordersDTO = convertToDto(orders);
        if(ordersDTO==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


        return new ResponseEntity<>(ordersDTO, HttpStatus.OK);
    }



    @ApiOperation(value = "Order creation")
    @PostMapping(value = "/post", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<OrdersDTO> saveOrder(@RequestBody OrdersDTO order) throws ParseException {

        if (order == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }


        Orders orders = convertToEntity(order);
        Orders ordersCreated = ordersService.save(orders);

        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(convertToDto(ordersCreated), headers, HttpStatus.CREATED);
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



    public OrdersDTO convertToDto(Orders orders) {
        OrdersDTO ordersDTO = modelMapper.map(orders, OrdersDTO.class);



        return ordersDTO;
    }

    public Orders convertToEntity(OrdersDTO ordersDTO) throws ParseException {
        Orders orders = modelMapper.map(ordersDTO, Orders.class);

        //orders.setBooks(ordersDTO.getBooks(booksService.getById(id)));

        if (ordersDTO.getBooks() != null) {
            Books oldBook = booksService.getById(orders.getId());
            orders.setId(oldBook.getId());

        }
        return orders;
    }
}
