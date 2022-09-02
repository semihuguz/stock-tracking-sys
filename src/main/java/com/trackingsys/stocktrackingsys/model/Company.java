package com.trackingsys.stocktrackingsys.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "company")
public class Company extends User{

    @GeneratedValue(generator = "UUID")
    @GenericGenerator(strategy ="UUID", name = "org.hibernate.id.UUIDGenerator")
    @Column(name = "companyId")
    private String companyId;

    @NotNull
    @Column(name = "companyName")
    private String companyName;

    @NotNull
    @Column(name = "companyPhoneNumber")
    private String companyPhoneNumber;

    @NotNull
    @Column(name = "companyAddress")
    private String companyAddress;

    @NotNull
    @Column(name = "taxNumber")
    private String taxNumber;

}
