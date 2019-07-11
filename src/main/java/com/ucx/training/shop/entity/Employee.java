package com.ucx.training.shop.entity;

import com.ucx.training.shop.type.RecordStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Employee extends BaseModel<Integer> {
  // Id generation strategy
    private String name;
    private String address;

    public Employee(Integer id,RecordStatus recordStatus,String name,String address){
        super(id,recordStatus);
        this.name = name;
        this.address = address;
    }


}
