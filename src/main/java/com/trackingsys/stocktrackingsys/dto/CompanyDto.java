package com.trackingsys.stocktrackingsys.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CompanyDto {
    private String companyName;
    private String companyPhoneNumber;
    private String companyAddress;
    private String taxNumber;

}
