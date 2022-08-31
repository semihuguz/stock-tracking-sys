package com.trackingsys.stocktrackingsys.repository;

import com.trackingsys.stocktrackingsys.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Customer,String> {

}
