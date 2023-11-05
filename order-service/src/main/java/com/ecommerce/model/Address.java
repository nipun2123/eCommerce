package com.ecommerce.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "address")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Builder
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String addressCode;
    private String houseNo;
    private String street1;
    private String street2;
    private String city;
    private String country;
    private String postalCode;
    @OneToMany(mappedBy = "address",cascade = CascadeType.PERSIST)
    private List<Order> order;
}
