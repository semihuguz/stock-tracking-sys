package com.trackingsys.stocktrackingsys.repository;

import com.trackingsys.stocktrackingsys.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {
}
