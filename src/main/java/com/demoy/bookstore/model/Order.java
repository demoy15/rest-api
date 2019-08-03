package com.demoy.bookstore.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_id")
    @SequenceGenerator(name = "order_id", sequenceName = "seq_order", allocationSize = 1)
    private Long id;

    @Column(name = "person_id")
    private Long personId;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private StatusEnum orderStatus;

    private Long totalPayment;

    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinTable(name = "order_book",
    joinColumns = @JoinColumn(name = "orders_id"),
    inverseJoinColumns = @JoinColumn(name = "books_id"))
    private List<Book> books =new ArrayList<>();

}
