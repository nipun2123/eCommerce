package com.ecommerce.dto;

import com.ecommerce.model.Address;
import com.ecommerce.model.Customer;
import com.ecommerce.model.OrderItem;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {

    private String orderNumber;
    private Timestamp orderTime;
    private Customer customer;
    private Address address;
    private List<OrderItem> orderItems;
}
