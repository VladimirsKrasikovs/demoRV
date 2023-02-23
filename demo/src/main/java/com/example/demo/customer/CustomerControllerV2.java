package com.example.demo.customer;

import com.example.demo.exeption.ApiRequestException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(path = "api/v2/customer")
public class CustomerControllerV2 {

    private final CustomerService customerService;


    @Autowired
    public CustomerControllerV2(CustomerService customerService) {
       this.customerService = customerService;
    }

    @GetMapping
    List<Customer> getCustomers() {
        return customerService.getCustomer();
    }

    @GetMapping (path = "{customerId}")
    Customer getCustomer(@PathVariable("customerId") Long id) {
        return customerService.getCustomeri(id);

    }

    @GetMapping (path = "{customerId}/exception")
    Customer getCustomerException(@PathVariable("customerId") Long id) {
        throw new ApiRequestException(
                "ApiRequestException for customer " + id
        );

    }

    @PostMapping()
    void createNewCustomer (@Valid @RequestBody Customer customer){
        System.out.println("POST Request ....");
        System.out.println(customer);
    }

    @PutMapping()
    void updateCustomer (@RequestBody Customer customer){
        System.out.println("Update Request ....");
        System.out.println(customer);
    }


    @DeleteMapping(path = "{customerId}")
    void deleteCustomer(@PathVariable("customerId") Long id){
        System.out.println("DELETE Request FOR customer with ...." + id);

    }


}
