package com.ecommerce.controller;


import com.ecommerce.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping("/{productCode}")
    @ResponseStatus(HttpStatus.OK)
    public boolean isInStock(@PathVariable("productCode") String productCode){
        return inventoryService.isInStock(productCode);
    }
}
