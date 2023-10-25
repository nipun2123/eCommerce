package com.ecommerce.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "order")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String orderNumber;
    private Timestamp orderTime;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Customer customer;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Address address;
    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;
}
