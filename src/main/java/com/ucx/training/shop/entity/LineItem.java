package com.ucx.training.shop.entity;

import com.ucx.training.shop.type.RecordStatus;
import jdk.jfr.consumer.RecordedClass;
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
public class LineItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Invoice invoice;

    @ManyToOne
    private Product product;
    private Integer quantity;
    @Enumerated(EnumType.STRING)
    private RecordStatus recordStatus;
}
