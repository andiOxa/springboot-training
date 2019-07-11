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
public class Customer extends BaseModel<Integer>{

   private String name;

   public Customer(Integer id ,String name,RecordStatus recordStatus){
       super(id,recordStatus);
       this.name = name;
   }

    @Override
    public String toString() {
        return String.format("%d,%s",1,this.getName());
    }
}
