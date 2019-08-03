package com.demoy.bookstore.mapper;


import com.demoy.bookstore.dto.OrderDTO;
import com.demoy.bookstore.model.Order;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderMapper ORDER_MAPPER = Mappers.getMapper(OrderMapper.class);

    /** Conversion object "OrderDTO" to "Order"*/
    @Mappings({
            @Mapping(target = "id",source = "order.id"),
            @Mapping(target = "personId", source = "order.personId"),
            @Mapping(target = "orderStatus",source = "order.orderStatus"),
            @Mapping(target = "books",source = "order.books")
    })
    Order toOrder(OrderDTO order);

    /** Conversion object "Order" to "OrderDTO"*/
    @InheritInverseConfiguration
    OrderDTO toDto(Order order);

}
