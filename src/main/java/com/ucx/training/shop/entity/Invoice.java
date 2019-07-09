package com.ucx.training.shop.entity;

import com.ucx.training.shop.type.RecordStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer invoiceNumber;
    @ManyToOne
    private Customer customer;
    @ManyToMany
    private List<LineItem> list = new ArrayList<>();

    private BigDecimal total;
    @Enumerated(EnumType.STRING)
    private RecordStatus recordStatus;





}
