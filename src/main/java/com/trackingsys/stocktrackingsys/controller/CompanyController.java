package com.trackingsys.stocktrackingsys.controller;


import com.trackingsys.stocktrackingsys.dto.CompanyDto;
import com.trackingsys.stocktrackingsys.model.Company;
import com.trackingsys.stocktrackingsys.service.CompanyService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/companies")
public class CompanyController {
    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping
    ResponseEntity<CompanyDto> addCompany(@RequestBody Company company){
        return ResponseEntity.ok(companyService.addCompany(company));
    }
    @GetMapping
    ResponseEntity<List<CompanyDto>> getAllCompanies(){
        return ResponseEntity.ok(companyService.getAllCompanies());
    }
    @GetMapping("/{id}")
    ResponseEntity<CompanyDto> getByIdCompany(@PathVariable("id")String companyId ){
        return ResponseEntity.ok(companyService.getByIdCompany(companyId));
    }

    @DeleteMapping("/{id}")
    private void deleteCompany(@PathVariable("id") String companyId){
        companyService.deleteCompany(companyId);
    }
    @PutMapping("/{id}")
    ResponseEntity<CompanyDto> updateCompany(
            @RequestBody Company company,
            @PathVariable("id") String companyId){
        return ResponseEntity.ok(companyService.updateCompany(company , companyId));
    }
}
