package com.demoy.bookstore.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="book")
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_id")
    @SequenceGenerator(name = "book_id", sequenceName = "seq_book", allocationSize = 1, initialValue = 5)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;


    @Column(name = "price")
    private Long price;

    @JsonIgnore
    @ManyToMany(mappedBy = "books")
    private List<Order> orders;

}
