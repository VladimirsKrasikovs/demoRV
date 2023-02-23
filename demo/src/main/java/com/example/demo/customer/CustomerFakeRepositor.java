package com.example.demo.customer;

import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository(value = "fake")
public class CustomerFakeRepositor implements CustomerRepo{
    @Override
    public List<Customer> getCustomer() {
        return Arrays.asList(
                new Customer(1l, "Mark Feigin", "password", "t@mail.com"),
                new Customer(2l, "Karina Levita", "Qwerty", "m@gmail.com")
        );
    }
}
