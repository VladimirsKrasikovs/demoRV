package com.example.demo.customer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerConfig {

    @Value("${app.useFakeCustomerRep:true}")
    private Boolean useFakeCustomerRepo;

    @Bean
    CommandLineRunner commandLineRunner(){
        return args -> {
            System.out.println("Command Line runner !");
        };
    }

    @Bean
    CustomerRepo customerRepo(){
        System.out.println("useFakeCustomerRep = " + useFakeCustomerRepo);
        return  new CustomerFakeRepositor();

    }
}
