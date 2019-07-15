package com.ucx.training.shop.entity;

import com.ucx.training.shop.type.RecordStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Product extends BaseEntity<Integer> {
    private String name;
    private BigDecimal unitPrice;
    private Integer stockQuantity;

    @Override
    public String toString() {
        return String.format("%s,%f,in stock: %b",getName(),getUnitPrice(),getStockQuantity());
    }
}
