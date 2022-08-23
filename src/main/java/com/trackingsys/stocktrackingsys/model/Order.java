package com.trackingsys.stocktrackingsys.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @NotNull
    @Column(name = "order_id")
    private String orderId;

    @NotNull
    @Column(name = "order_number")
    private String orderNumber;

    @NotNull
    @Column(name = "order_date")
    private LocalDateTime orderDate = LocalDateTime.now();


}
