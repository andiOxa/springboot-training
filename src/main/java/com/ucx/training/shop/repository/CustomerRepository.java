package com.ucx.training.shop.repository;

import com.ucx.training.shop.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
