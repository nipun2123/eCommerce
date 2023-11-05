package com.ecommerce.controller;

import com.ecommerce.dto.ProductRequest;
import com.ecommerce.dto.ProductResponse;
import com.ecommerce.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {


    private final ProductService productService;

    //end point for create product
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addProduct(@RequestBody ProductRequest productRequest){

        productService.addProduct(productRequest);
    }

    //end point for retrieve all products
    @GetMapping("/all_product")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts(){

       return productService.getAllProduct();
    }



}
