package com.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {
    private String addressCode;
    private String houseNo;
    private String street1;
    private String street2;
    private String city;
    private String country;
    private String postalCode;
}
