package com.demoy.bookstore.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@Table(name="books")
public class Books extends BaseEntity{


    @Column(name = "title")
    private String title;


    @Column(name = "author")
    private String author;


    @JsonIgnore
    @ManyToMany(mappedBy = "books")
    List<Orders> orders;



    public Books(){
    }

    public Books(String title, String author) {
        this.title = title;
        this.author = author;
    }

}
