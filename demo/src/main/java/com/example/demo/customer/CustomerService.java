package com.example.demo.customer;

import com.example.demo.exeption.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class CustomerService {

    private final static Logger LOGGER =
            LoggerFactory.getLogger(CustomerService.class);


    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepo) {
        this. customerRepository = customerRepo;
    }


    List< Customer> getCustomer() {
        LOGGER.info("getCustomer was called");
        return  customerRepository.findAll();

    }

    Customer getCustomeri(Long id) {

        return customerRepository.findById(id)
                .orElseThrow(
                        ()-> new NotFoundException(
                        ("Customer with id " + id + "not found")));
    }
}
