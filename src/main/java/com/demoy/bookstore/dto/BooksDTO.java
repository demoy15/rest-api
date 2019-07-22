package com.demoy.bookstore.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
public class BooksDTO implements Serializable {

    private Long id;



    @JsonIgnore
    @NotNull
    private String title;


    @JsonIgnore
    @NotNull
    private String author;
}
