package com.trackingsys.stocktrackingsys.controller;

import com.trackingsys.stocktrackingsys.dto.CustomerDto;
import com.trackingsys.stocktrackingsys.dto.OrderDto;
import com.trackingsys.stocktrackingsys.model.Customer;
import com.trackingsys.stocktrackingsys.model.Order;
import com.trackingsys.stocktrackingsys.service.CustomerService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @PostMapping
    public ResponseEntity<CustomerDto> addCustomer (@RequestBody Customer customer){
        return ResponseEntity.ok(customerService.addCustomer(customer));
    }
    @GetMapping
    public ResponseEntity<List<CustomerDto>> getAllCustomer(){
        return ResponseEntity.ok(customerService.getAllCustomer());
    }
    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> getByCustomerId(@PathVariable("id") String customerId){
        return ResponseEntity.ok(customerService.getByCustomerId(customerId));
    }
    @DeleteMapping("/{id}")
    public void deleteByCustomerId (@PathVariable("id") String customerId){
        customerService.deleteByCustomerId(customerId);
    }
    @PutMapping("/{id}")
    public ResponseEntity<CustomerDto> updateCustomer(
        @RequestBody Customer customer,
        @PathVariable("id") String customerId) {
            return ResponseEntity.ok(customerService.updateCustomer(customer,customerId));
        }
    }
