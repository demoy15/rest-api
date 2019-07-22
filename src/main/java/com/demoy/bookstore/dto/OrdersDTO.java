package com.demoy.bookstore.dto;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class OrdersDTO implements Serializable {
    private Long id;
    private Long userId;
    private String orderStatus;
    private Long totalPay;
    private List<BooksDTO> books;
}
