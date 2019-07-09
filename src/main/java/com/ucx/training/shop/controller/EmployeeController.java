package com.ucx.training.shop.controller;

import com.ucx.training.shop.service.EmployeeService;
import com.ucx.training.shop.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("shop")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    //DTO

    //

    @PostMapping
    public Employee getEmployee(@RequestBody Employee employee){
        //Employee employee1 = new Employee();
       // employee1.setName(employee.getName());
        //employee1.setAddress(employee.getAddress());
        return employeeService.save(employee);

    }

    @GetMapping("{id}")
    public Employee find(@PathVariable Integer id){
        return employeeService.findbyID(id);
    }

    @PutMapping("{id}")
    public Employee updateEmployee(@PathVariable Integer id,@RequestBody Employee employee){
        return employeeService.update(employee,id);
    }

    @DeleteMapping("{id}")
    public void removeEmployee(@PathVariable Integer id){
         employeeService.remove(id);
    }

    @GetMapping
    public  List<Employee> findEmployees(@RequestParam(defaultValue = "ASC") String direction,@RequestParam (defaultValue = "id")String properties){
            return employeeService.findAll(direction,properties);
    }

}
