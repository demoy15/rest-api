package com.demoy.bookstore.mapper;

import com.demoy.bookstore.dto.BookDTO;
import com.demoy.bookstore.dto.OrderDTO;
import com.demoy.bookstore.model.Book;
import com.demoy.bookstore.model.Order;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-08-02T23:31:57+0300",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_181 (Oracle Corporation)"
)
@Component
public class OrderMapperImpl implements OrderMapper {

    @Override
    public Order toOrder(OrderDTO order) {
        if ( order == null ) {
            return null;
        }

        Order order1 = new Order();

        order1.setOrderStatus( order.getOrderStatus() );
        order1.setPersonId( order.getPersonId() );
        order1.setBooks( bookDTOListToBookList( order.getBooks() ) );
        order1.setId( order.getId() );

        return order1;
    }

    @Override
    public OrderDTO toDto(Order order) {
        if ( order == null ) {
            return null;
        }

        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setBooks( bookListToBookDTOList( order.getBooks() ) );
        orderDTO.setId( order.getId() );
        orderDTO.setPersonId( order.getPersonId() );
        orderDTO.setOrderStatus( order.getOrderStatus() );

        return orderDTO;
    }

    protected Book bookDTOToBook(BookDTO bookDTO) {
        if ( bookDTO == null ) {
            return null;
        }

        Book book = new Book();

        book.setId( bookDTO.getId() );

        return book;
    }

    protected List<Book> bookDTOListToBookList(List<BookDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Book> list1 = new ArrayList<Book>( list.size() );
        for ( BookDTO bookDTO : list ) {
            list1.add( bookDTOToBook( bookDTO ) );
        }

        return list1;
    }

    protected BookDTO bookToBookDTO(Book book) {
        if ( book == null ) {
            return null;
        }

        BookDTO bookDTO = new BookDTO();

        bookDTO.setId( book.getId() );

        return bookDTO;
    }

    protected List<BookDTO> bookListToBookDTOList(List<Book> list) {
        if ( list == null ) {
            return null;
        }

        List<BookDTO> list1 = new ArrayList<BookDTO>( list.size() );
        for ( Book book : list ) {
            list1.add( bookToBookDTO( book ) );
        }

        return list1;
    }
}
