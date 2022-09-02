package com.trackingsys.stocktrackingsys.service;

import com.trackingsys.stocktrackingsys.dto.CustomerDto;
import com.trackingsys.stocktrackingsys.dto.converter.CustomerDtoConverter;
import com.trackingsys.stocktrackingsys.model.Customer;
import com.trackingsys.stocktrackingsys.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerDtoConverter customerDtoConverterDto;
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerDtoConverter customerDtoConverterDto, CustomerRepository customerRepository) {
        this.customerDtoConverterDto = customerDtoConverterDto;
        this.customerRepository = customerRepository;
    }

    public CustomerDto addCustomer(Customer customer) {
        return customerDtoConverterDto.convertToDto(customerRepository.save(customer));
    }

    public List<CustomerDto> getAllCustomer() {
        return customerDtoConverterDto.convertToDto(customerRepository.findAll());
    }

    public CustomerDto getByCustomerId(String customerId) {
        return customerDtoConverterDto.convertToDto(customerRepository.findById(customerId).orElse(null));
    }

    public Customer deleteByCustomerId(String customerId) {
        Customer customer = customerRepository.findById(customerId).orElse(null);
        customerRepository.deleteById(customerId);
        return customer;
    }

    public CustomerDto updateCustomer(Customer customer, String customerId) {
        Customer updateCustomer = customerRepository.findById(customerId).orElse(null);
        updateCustomer.setCustomerName(updateCustomer.getCustomerName());
        updateCustomer.setCustomerSurname(updateCustomer.getCustomerSurname());
        updateCustomer.setMail(updateCustomer.getMail());
        updateCustomer.setPassword(updateCustomer.getPassword());
        return customerDtoConverterDto.convertToDto(customerRepository.save(updateCustomer));

    }
}
