package com.ecommerce;


import com.ecommerce.model.Inventory;
import com.ecommerce.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }


    @Bean
    public CommandLineRunner loadData(InventoryRepository inventoryRepository){

        return args -> {

            Inventory inventory1 = new Inventory();
            inventory1.setProductCode("ITM112233");
            inventory1.setQty(4);

            Inventory inventory2 = new Inventory();
            inventory2.setProductCode("ITM445566");
            inventory2.setQty(2);

            inventoryRepository.save(inventory1);
            inventoryRepository.save(inventory2);
        };

    }
}