package com.ucx.training.shop.service;

import com.ucx.training.shop.type.RecordStatus;
import com.ucx.training.shop.entity.Employee;
import com.ucx.training.shop.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;

import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    public Employee save(Employee employee){

    return  employeeRepository.save(employee);
    }

    public Employee findbyID(Integer id){
        Optional<Employee> employee = employeeRepository.findById(id);
        if(employee.isPresent()){
            return employee.get();
        }
        else{
            return null;
        }

    }

    public Employee update(Employee employee, Integer id){
       Employee foundEmployee = findbyID(id);
        if(foundEmployee == null){
            throw new RuntimeException("Employee not found!");
        }else{
        foundEmployee.setName(employee.getName());
        foundEmployee.setAddress(employee.getAddress());
        return employeeRepository.save(foundEmployee);
        }

    }
    public void remove(Integer id){
        Employee employee = findbyID(id);
        if(employee == null){
            throw new RuntimeException("Employee not found");
        }else{
            employee.setRecordStatus(RecordStatus.INACTIVE);
            //employeeRepository.save(employee);
        }
    }

    public List<Employee> findAll(String direction,String ... properties){
       if(direction == null){
           throw new IllegalArgumentException("Direction can't be null");
       }else{
           return employeeRepository.findAll(Sort.by(Sort.Direction.valueOf(direction),properties));

       }
    }

            public List<Employee> findAllByNameAndAddress(String name,String address){
            if(name == null && address == null){
                throw new IllegalArgumentException("Null parameters cannot be given");
            }
            return employeeRepository.findAllByNameAndAddress(name,address);
            }

}
