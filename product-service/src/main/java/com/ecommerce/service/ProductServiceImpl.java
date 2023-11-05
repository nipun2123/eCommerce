package com.ecommerce.service;

import com.ecommerce.dto.ProductRequest;
import com.ecommerce.dto.ProductResponse;
import com.ecommerce.model.Product;
import com.ecommerce.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    @Override
    public void addProduct(ProductRequest productRequest) {

        //create product obj
        Product product = Product.builder()
                .name(productRequest.getName())
                .brand(productRequest.getBrand())
                .colors(productRequest.getColors())
                .price(productRequest.getPrice())
                .build();

        //save product obj
        productRepository.save(product);
        //log it
        log.info("Product is saved! The id is {} ", product.getId());
    }

    @Override
    public List<ProductResponse> getAllProduct() {
        //retrieve all products
        List<Product> products = productRepository.findAll();

        //map Product array into ProductResponse array
        return products.stream().map(this::mapProductResponse).toList();
    }

    private ProductResponse mapProductResponse(Product product) {
        //create and return ProductResponse obj
        return ProductResponse.builder()
                .name(product.getName())
                .brand(product.getBrand())
                .colors(product.getColors())
                .price(product.getPrice())
                .build();
    }
}
