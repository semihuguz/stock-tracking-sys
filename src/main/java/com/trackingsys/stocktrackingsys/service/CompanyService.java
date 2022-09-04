package com.trackingsys.stocktrackingsys.service;

import com.trackingsys.stocktrackingsys.dto.CompanyDto;
import com.trackingsys.stocktrackingsys.dto.converter.CompanyConverterDto;
import com.trackingsys.stocktrackingsys.model.Company;
import com.trackingsys.stocktrackingsys.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CompanyService {
    private final CompanyRepository companyRepository;
    private final CompanyConverterDto companyConverterDto;

    public CompanyService(CompanyRepository companyRepository, CompanyConverterDto companyConverterDto) {
        this.companyRepository = companyRepository;
        this.companyConverterDto = companyConverterDto;
    }

    public CompanyDto addCompany(Company company) {
        return companyConverterDto.convertToDto(companyRepository.save(company));
    }

    public List<CompanyDto> getAllCompanies() {
        return companyConverterDto.convertToDto(companyRepository.findAll());
    }

    public CompanyDto getByIdCompany(String companyId) {
        return companyConverterDto.convertToDto(companyRepository.findById(companyId).orElse(null));
    }

    public Company deleteCompany(String companyId) {
        Company company = companyRepository.findById(companyId).orElse(null);
        companyRepository.deleteById(companyId);
        return company;
    }

    public CompanyDto updateCompany(Company company, String companyId) {
        Company updateCompany = companyRepository.findById(companyId).orElse(null);
        updateCompany.setCompanyName(company.getCompanyName());
        updateCompany.setCompanyAddress(company.getCompanyAddress());
        updateCompany.setCompanyPhoneNumber(company.getCompanyPhoneNumber());
        updateCompany.setMail(company.getMail());
        return companyConverterDto.convertToDto(companyRepository.save(updateCompany));

    }
}
