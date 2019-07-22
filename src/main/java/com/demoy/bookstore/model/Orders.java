package com.demoy.bookstore.model;

import com.demoy.bookstore.dto.BooksDTO;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "orders")
public class Orders extends BaseEntity{

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "status")
    private String orderStatus;


    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "orders_books",
    joinColumns = @JoinColumn(name = "orders_id"),
    inverseJoinColumns = @JoinColumn(name = "books_id"))
    private List<Books> books;


    @Column(name = "total_payment")
    private Long totalPay;



    protected Orders(){}

    public Orders(Long userId, String orderStatus, Long totalPay) {
        this.userId = userId;
        this.orderStatus = orderStatus;
        this.totalPay = totalPay;
    }
}
