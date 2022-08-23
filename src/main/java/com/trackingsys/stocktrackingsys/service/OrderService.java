package com.trackingsys.stocktrackingsys.service;

import com.trackingsys.stocktrackingsys.dto.OrderDto;
import com.trackingsys.stocktrackingsys.dto.converter.OrderConverterDto;
import com.trackingsys.stocktrackingsys.model.Order;
import com.trackingsys.stocktrackingsys.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderConverterDto orderConverterDto;

    public OrderService(OrderRepository orderRepository, OrderConverterDto orderConverterDto) {
        this.orderRepository = orderRepository;
        this.orderConverterDto = orderConverterDto;
    }

    public OrderDto addOrder(Order order) {
        return orderConverterDto.converterDto(orderRepository.save(order));
    }

    public List<OrderDto> getAllOrder() {
        return orderConverterDto.converterDto(orderRepository.findAll());
    }

    public OrderDto getOrderById(String orderId) {
        return orderConverterDto.converterDto(orderRepository.findById(orderId).orElse(null));
    }

    public Order deleteOrderById(String orderId) {
        Order order =orderRepository.findById(orderId).orElse(null);
        orderRepository.deleteById(orderId);
        return order;
    }

    public OrderDto updateByOrderId(Order order, String orderId) {
        Order updateOrder = orderRepository.findById(orderId).orElse(null);
        updateOrder.setOrderNumber(order.getOrderNumber());
        return orderConverterDto.converterDto(orderRepository.save(updateOrder));
    }
}
