package com.ucx.training.shop.service;
import com.ucx.training.shop.entity.Customer;
import com.ucx.training.shop.entity.Invoice;
import com.ucx.training.shop.entity.LineItem;
import com.ucx.training.shop.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;


@Service
@Transactional
public class InvoiceService extends BaseService<Invoice,Integer> {

    @Autowired
    private InvoiceRepository invoiceRepository;

    public Invoice update(List<LineItem> list,Customer customer,Invoice invoice){
        if (list.isEmpty() || customer == null) {
            throw new IllegalArgumentException("Invalid argument");
        }
        if(customer == null){
            throw new IllegalArgumentException("Invalid argument");
        }

        BigDecimal total = list.stream().map(e -> e.getProduct().getUnitPrice()
                .multiply(BigDecimal.valueOf(e.getQuantity())))
                .reduce(BigDecimal.ZERO,(a,b)-> a.add(b));

        invoice.setInvoiceNumber((int) (Math.random() * 100 +1));
        invoice.setLineItemList(list);
        invoice.setCustomer(customer);
        invoice.setTotal(total);

        return invoice;
    }

    public Invoice print(Integer id){
        return findById(id);
    }

}

