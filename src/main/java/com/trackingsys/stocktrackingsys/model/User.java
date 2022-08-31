package com.trackingsys.stocktrackingsys.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.ZoneId;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(strategy = "UUID",name = "org.hibernate.id.UUIDGenerator")
    @Column(name = "usersId")
    private String userId;

    @Column(name = "userMail")
    private String mail;

    @Column(name = "userPassword")
    private String password;

    @Column(name = "creationDate")
    private LocalDateTime creationDate = LocalDateTime.now(ZoneId.of("Africa/Addis_Ababa"));

}
