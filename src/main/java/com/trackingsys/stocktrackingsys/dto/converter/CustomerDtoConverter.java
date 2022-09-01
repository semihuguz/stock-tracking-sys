package com.trackingsys.stocktrackingsys.dto.converter;

import com.trackingsys.stocktrackingsys.dto.CustomerDto;
import com.trackingsys.stocktrackingsys.model.Customer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerDtoConverter {
    public CustomerDto convertToDto(Customer customer){
        return CustomerDto.builder()
                .customerName(customer.getCustomerName())
                .customerSurname(customer.getCustomerSurname())
                .birthDate(customer.getBirthDate())
                .identityNumber(customer.getIdentityNumber())
                .build();
    }
    public List<CustomerDto> convertToDto(List<Customer> customers){
        return customers.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

}
