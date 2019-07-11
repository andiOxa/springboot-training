package com.ucx.training.shop.controller;


import com.ucx.training.shop.entity.Customer;
import com.ucx.training.shop.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("shop/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public Customer create(@RequestBody Customer customer) {
        return customerService.save(customer);
    }

    @GetMapping
    public List<Customer> findAll() {
        return customerService.findAll();
    }

    @GetMapping("{id}")
    public Customer findById(@PathVariable Integer id) {
        return customerService.findById(id);
    }

    @PutMapping("{id}")
    public Customer update(@RequestBody Customer customer) {
        return customerService.update(customer,customer.getId());
    }

    @DeleteMapping("{id}")
    public void remove(@PathVariable Integer id) {
        customerService.remove(id);
    }

}
