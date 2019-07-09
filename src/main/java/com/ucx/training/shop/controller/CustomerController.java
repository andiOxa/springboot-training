package com.ucx.training.shop.controller;


import com.ucx.training.shop.entity.Customer;
import com.ucx.training.shop.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer){
        return customerService.save(customer);

    }
    @GetMapping("{id}")
    public Customer findCustomer(@PathVariable Integer id){
            return customerService.findByID(id);

    }
}
