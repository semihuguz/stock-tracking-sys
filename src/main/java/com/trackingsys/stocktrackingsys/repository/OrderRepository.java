package com.trackingsys.stocktrackingsys.repository;

import com.trackingsys.stocktrackingsys.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,String> {
}
