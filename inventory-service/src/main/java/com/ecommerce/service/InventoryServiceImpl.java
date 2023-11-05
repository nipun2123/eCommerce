package com.ecommerce.service;

import com.ecommerce.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class InventoryServiceImpl implements InventoryService{


    private final InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    @Override
    public boolean isInStock(String productCode) {
        return inventoryRepository.findByProductCode(productCode).isPresent();
    }
}
