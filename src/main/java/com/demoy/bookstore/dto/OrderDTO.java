package com.demoy.bookstore.dto;


import com.demoy.bookstore.mapper.OrderMapperImpl;
import com.demoy.bookstore.model.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO extends OrderMapperImpl {

    private Long id;

    private StatusEnum orderStatus;

    private Long personId;

    private List<BookDTO> books;

}

