package com.trackingsys.stocktrackingsys.controller;

import com.trackingsys.stocktrackingsys.dto.OrderDto;
import com.trackingsys.stocktrackingsys.model.Order;
import com.trackingsys.stocktrackingsys.service.OrderService;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;


    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<OrderDto> addOrder(@RequestBody Order order){
        return ResponseEntity.ok(orderService.addOrder(order));
    }
    @GetMapping
    public ResponseEntity<List<OrderDto>> getAllOrder(){
        return ResponseEntity.ok(orderService.getAllOrder());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable("id")String orderId){
        return ResponseEntity.ok(orderService.getOrderById(orderId));
    }
    @DeleteMapping("/{id}")
    public void deleteOrderById(@PathVariable("id")String orderId){
        orderService.deleteOrderById(orderId);
    }

    @PutMapping("{id}")
    public ResponseEntity<Order> updateByOrderId(
            @RequestBody Order order,
            @PathVariable("id") String orderId){
        return ResponseEntity.ok(orderService.updateByOrderId(order, orderId));
    }
}
