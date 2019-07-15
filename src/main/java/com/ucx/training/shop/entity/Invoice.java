package com.ucx.training.shop.entity;

import com.ucx.training.shop.type.RecordStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Invoice extends BaseEntity<Integer> {


    private Integer invoiceNumber;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @OneToMany(mappedBy = "invoice",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<LineItem> lineItemList;
    private BigDecimal total;


    @Override
    public String toString() {
        return String.format("Invoice number: %d, Customer: %s, LineItem listLineItem: %s,Total: %f",getInvoiceNumber(),getCustomer(),getLineItemList(),getTotal());
    }
}
