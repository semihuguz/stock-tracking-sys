package com.trackingsys.stocktrackingsys.dto.converter;

import com.trackingsys.stocktrackingsys.dto.OrderDto;
import com.trackingsys.stocktrackingsys.model.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderConverterDto {
    public OrderDto converterDto(Order order){
        return OrderDto.builder()
                .orderNumber(order.getOrderNumber())
                .orderDate(order.getOrderDate())
                .build();
    }
    public List<OrderDto> converterDto(List<Order> order){
        return order.stream()
                .map(this::converterDto)
                .collect(Collectors.toList());
    }
}
