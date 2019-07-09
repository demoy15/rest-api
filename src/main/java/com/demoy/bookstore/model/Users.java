package com.demoy.bookstore.model;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;



@Data
@Entity
@Table(name = "users")
public class Users extends BaseEntity {


    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String lastName;



    protected Users(){
    }

    public Users(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }
}
