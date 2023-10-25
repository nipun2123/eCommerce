package com.ecommerce.service;

import com.ecommerce.dto.ProductRequest;
import com.ecommerce.dto.ProductResponse;

import java.util.List;

public interface ProductService {

    void addProduct(ProductRequest productRequest);

    List<ProductResponse> getAllProduct();
}
