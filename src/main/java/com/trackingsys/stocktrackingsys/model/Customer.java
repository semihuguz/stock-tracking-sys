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
@Table(name = "customer")
public class Customer extends User {
    @Id
    @NotNull
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(strategy ="UUID", name = "org.hibernate.id.UUIDGenerator")
    @Column(name = "customerId")
    private String customerId;

    @NotNull
    @Column(name = "customerName")
    private String customerName;

    @NotNull
    @Column(name = "customerSurname")
    private String customerSurname;

    @NotNull
    @Column(name = "birthDate")
    private String birthDate;

    @NotNull
    @Column(name = "identityNumber")
    private String identityNumber;

}
