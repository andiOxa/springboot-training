package com.ucx.training.shop.service;

import com.ucx.training.shop.entity.Customer;
import com.ucx.training.shop.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    public Customer save(Customer customer){
        return customerRepository.save(customer);
    }

    public Customer findByID(Integer id){
       Optional<Customer> customer =  customerRepository.findById(id);
        if(customer.isPresent()){
            return customer.get();
        }
        else{
            return null;
        }
    }
}
