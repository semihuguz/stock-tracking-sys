package com.trackingsys.stocktrackingsys.dto.converter;

import com.trackingsys.stocktrackingsys.dto.CompanyDto;
import com.trackingsys.stocktrackingsys.model.Company;
import org.springframework.stereotype.Component;

import java.awt.desktop.PrintFilesEvent;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CompanyConverterDto {
    public CompanyDto convertToDto(Company company){
        return CompanyDto.builder()
                .companyName(company.getCompanyName())
                .companyAddress(company.getCompanyAddress())
                .companyPhoneNumber(company.getCompanyPhoneNumber())
                .build();
    }

    public List<CompanyDto> convertToDto(List<Company> companies){
        return companies.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
}
