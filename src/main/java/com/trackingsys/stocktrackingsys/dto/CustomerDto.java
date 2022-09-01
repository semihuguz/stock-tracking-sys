package com.trackingsys.stocktrackingsys.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CustomerDto {
    private String customerName;
    private String customerSurname;
    private String birthDate;
    private String identityNumber;
}
