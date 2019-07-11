package com.ucx.training.shop.entity;

import com.ucx.training.shop.type.RecordStatus;
import jdk.jfr.consumer.RecordedClass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class LineItem extends BaseModel<Integer> {

    @ManyToMany(mappedBy = "lineItemList")
    //@JoinColumn(name = "Invoice", referencedColumnName = "id")
    private List<Invoice> invoice;

    @OneToOne
    @JoinColumn
    private Product product;
    private Integer quantity;

    public LineItem(Integer id, RecordStatus recordStatus,List<Invoice> invoice,Product product,Integer quantity){
        super(id,recordStatus);
        this.invoice = invoice;
        this.product = product;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return String.format("Product: %s,Quantity: %s",getProduct(),getQuantity());
    }
}
