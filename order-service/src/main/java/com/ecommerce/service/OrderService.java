package com.ecommerce.service;

import com.ecommerce.dto.OrderRequest;
import org.springframework.beans.factory.annotation.Autowired;

public interface OrderService {

    void placeOrder(OrderRequest orderRequest);
}
