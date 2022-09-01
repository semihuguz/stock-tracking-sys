package com.trackingsys.stocktrackingsys.repository;

import com.trackingsys.stocktrackingsys.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, String> {
}
