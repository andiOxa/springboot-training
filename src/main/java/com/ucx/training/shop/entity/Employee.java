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
public class Employee {

    @Id //Indicates that this field is Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Id generation strategy
    private Integer id;
    private String name;
    private String address;
    @Enumerated(EnumType.STRING)
    private RecordStatus recordStatus;


}
