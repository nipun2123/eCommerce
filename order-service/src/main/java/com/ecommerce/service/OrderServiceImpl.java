package com.ecommerce.service;

import com.ecommerce.dto.OrderItemDto;
import com.ecommerce.dto.OrderRequest;
import com.ecommerce.model.Address;
import com.ecommerce.model.Customer;
import com.ecommerce.model.Order;
import com.ecommerce.model.OrderItem;
import com.ecommerce.repository.AddressRepository;
import com.ecommerce.repository.CustomerRepository;
import com.ecommerce.repository.OrderItemRepository;
import com.ecommerce.repository.OrderRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
@Transactional
public class OrderServiceImpl implements OrderService {


    private final CustomerRepository customerRepository;
    private final AddressRepository addressRepository;
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;


    @Override
    @Transactional
    public void placeOrder(OrderRequest orderRequest) {

        //check whether customer exit in the DB
        Customer customer = customerRepository.getReferenceByCustomerCode(orderRequest.getCustomerDto().getCustomerCode());

        //if not save customer
        if (customer == null) {

            //create customer obj
           customer = Customer.builder()
                    .customerCode(orderRequest.getCustomerDto().getCustomerCode())
                    .fname(orderRequest.getCustomerDto().getFname())
                    .lname(orderRequest.getCustomerDto().getLname())
                    .phoneNumber(orderRequest.getCustomerDto().getPhoneNumber())
                    .build();

            customerRepository.save(customer);
        }

        //check whether address exit in the DB
        Address address = addressRepository.getReferenceByAddressCode(orderRequest.getAddressDto().getAddressCode());

        //if not save address
        if (address == null) {

            address = Address.builder()
                    .addressCode(orderRequest.getAddressDto().getAddressCode())
                    .houseNo(orderRequest.getAddressDto().getHouseNo())
                    .street1(orderRequest.getAddressDto().getStreet1())
                    .street2(orderRequest.getAddressDto().getStreet2())
                    .city(orderRequest.getAddressDto().getCity())
                    .country(orderRequest.getAddressDto().getCountry())
                    .postalCode(orderRequest.getAddressDto().getPostalCode())
                    .build();

            addressRepository.save(address);
        }

        //map orderitemdto into orderitem
        List<OrderItem> orderItems = orderRequest.getOrderItemsDtos().stream().map(this::dtoToItem).toList();

        //check avaiability

        //call inventory

        //create order obj
        Order order = Order.builder()
                .orderNumber(geenerateOrderNumber())
                .orderTime(new Timestamp(System.currentTimeMillis()))
                .customer(customer)
                .address(address)
                .build();


        //save order
        orderRepository.save(order);

        for(OrderItem oi: orderItems){
            oi.setOrder(order);
            orderItemRepository.save(oi);
        }


        log.info("Order is saved! The id is {} ", order.getId());
    }

    private OrderItem dtoToItem(OrderItemDto orderItemDto) {

        //create orderitem obj
        return OrderItem.builder().itemCode(orderItemDto.getItemCode())
                .qty(orderItemDto.getQty())
                .price(orderItemDto.getPrice())
                .build();
    }

    private String geenerateOrderNumber() {

        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789";

        int len = 6;
        StringBuilder sb = new StringBuilder(len);

        for (int i = 0; i < len; i++) {

            int index = (int) (AlphaNumericString.length() * Math.random());

            sb.append(AlphaNumericString.charAt(index));
        }

        return sb.toString();
    }
}

