package com.example.demo.customer;

import com.example.demo.DemoApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;


    @Autowired
    public CustomerController(CustomerService customerService) {
       this.customerService = customerService;
    }

    @GetMapping(value = "all")
    List<Customer> getCustomer() {
        return customerService.getCustomer();
    }

    @PostMapping()
    void createNewCustomer (@RequestBody Customer customer){
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
