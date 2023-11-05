package com.ecommerce.repository;

import com.ecommerce.model.Address;
import com.ecommerce.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address, Long> {
    Address getReferenceByAddressCode(String addressCode);
}
