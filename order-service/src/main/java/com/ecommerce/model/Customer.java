package com.ecommerce.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "customer")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Customer {

    @Id
    private long id;
    private String customerCode;
    private String fName;
    private String lName;
    private String phoneNumber;
    @OneToMany(mappedBy = "customer",cascade = CascadeType.PERSIST)
    private List<Order> order;
}
