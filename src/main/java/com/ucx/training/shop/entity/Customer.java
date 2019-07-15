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
public class Customer extends BaseEntity<Integer> {

   private String name;


    @Override
    public String toString() {
        return String.format("%d,%s",1,this.getName());
    }
}
