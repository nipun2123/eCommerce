package com.ecommerce.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "customer")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Builder
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String customerCode;
    private String fname;
    private String lname;
    private String phoneNumber;
    @OneToMany(mappedBy = "customer",cascade = CascadeType.PERSIST)
    private List<Order> order;
}
