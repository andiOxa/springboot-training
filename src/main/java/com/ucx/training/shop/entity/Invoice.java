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
public class Invoice extends BaseModel<Integer> {


    private Integer invoiceNumber;
    @OneToOne
    @JoinColumn
    private Customer customer;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "invoice_lineitems",
            joinColumns = @JoinColumn(name = "invoice_id"),
            inverseJoinColumns = @JoinColumn(name = "lineitem_id"))
    private List<LineItem> lineItemList;

    private BigDecimal total;

    public Invoice(Integer id,RecordStatus recordStatus,Integer invoiceNumber,Customer customer,List<LineItem> lineItemList){
        super(id,recordStatus);
        this.invoiceNumber = invoiceNumber;
        this.customer = customer;
        this.lineItemList = lineItemList;

    }

    @Override
    public String toString() {
        return String.format("Invoice number: %d, Customer: %s, LineItem listLineItem: %s,Total: %f",getInvoiceNumber(),getCustomer(),getLineItemList(),getTotal());
    }
}
