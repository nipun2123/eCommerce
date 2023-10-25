package com.ecommerce.repository;

import com.ecommerce.model.Customer;
import com.ecommerce.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer getReferenceByCustomerCode(String customerCode);
}
