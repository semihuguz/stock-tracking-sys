package com.trackingsys.stocktrackingsys.service;

import com.trackingsys.stocktrackingsys.model.Order;
import com.trackingsys.stocktrackingsys.repository.OrderRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order addOrder(Order order) {
        return orderRepository.save(order);
    }

    public List<Order> getAllOrder() {
        return orderRepository.findAll();
    }

    public Order getOrderById(String orderId) {
        return orderRepository.findById(orderId).orElse(null);
    }

    public Order deleteOrderById(String orderId) {
        Order order =orderRepository.findById(orderId).orElse(null);
        orderRepository.deleteById(orderId);
        return order;
    }

    public Order updateByOrderId(Order order, String orderId) {
        Order updateOrder = orderRepository.findById(orderId).orElse(null);
        updateOrder.setOrderNumber(order.getOrderNumber());
        return orderRepository.save(updateOrder);
    }
}
