package com.ucx.training.shop.repository;

import com.ucx.training.shop.entity.Employee;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    List<Employee> findAllByNameAndAddress(String name,String address);

}
