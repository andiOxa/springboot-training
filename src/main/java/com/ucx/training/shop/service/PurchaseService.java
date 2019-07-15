package com.ucx.training.shop.service;

import com.ucx.training.shop.entity.Customer;
import com.ucx.training.shop.entity.Invoice;
import com.ucx.training.shop.entity.LineItem;
import com.ucx.training.shop.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PurchaseService {


   private LineItemService lineItemService;
   private CustomerService customerService;
   private InvoiceService invoiceService;
   private ProductService productService;

   private List<LineItem> lineItemList;

    public PurchaseService(LineItemService lineItemService, CustomerService customerService,InvoiceService invoiceService,ProductService productService){
        this.lineItemService = lineItemService;
        this.customerService = customerService;
        this.invoiceService = invoiceService;
        this.productService = productService;
    }

    public Integer addToCart(Integer product_id,Integer quantity,Integer invoice_id){
        Integer newInvoiceId;
        Product foundProduct = productService.findById(product_id);
        if(foundProduct == null) throw new RuntimeException("Product cannot be found!");
        if(quantity == null) throw new IllegalArgumentException("No quantity provided");
        if(foundProduct.getStockQuantity() < quantity) throw new RuntimeException("Product is out of stock");

        if(invoice_id == null){
            Invoice invoice = new Invoice();
           Invoice createdInvoice = invoiceService.save(invoice);
           lineItemService.create(foundProduct,quantity,createdInvoice);
           newInvoiceId = createdInvoice.getId();
        }else{
            Invoice foundInvoice = invoiceService.findById(invoice_id);
            if(foundInvoice == null) throw new RuntimeException("No such Invoice found");
            lineItemService.create(foundProduct,quantity,foundInvoice);
            newInvoiceId =invoice_id;
        }
        return newInvoiceId;
    }

    public Invoice buy(Integer customer_id,Integer invoice_id){
        Invoice foundInvoice = invoiceService.findById(invoice_id);
        if(foundInvoice== null) throw new RuntimeException("No such Invoice found");
        Customer foundCustomer = customerService.findById(customer_id);
        if(foundCustomer == null) throw new RuntimeException("No such Customer found");

        List<LineItem> list = lineItemService.findAllByInvoice(foundInvoice);
        Invoice generatedInvoice = invoiceService.update(list,foundCustomer,foundInvoice);
        Invoice printedInvoice = invoiceService.print(generatedInvoice.getId());

        return printedInvoice;
    }

//    public void addToCart(LineItem lineItem,List<LineItem> lineItems){
//        if(lineItem == null){
//            throw new IllegalArgumentException("Invalid argument : " + lineItem);
//        }
//        this.lineItemList = lineItems;
//        lineItemList.add(lineItem);
//    }
//
//    public void addToCart(Product product,Integer quantity){
//        if(product == null || quantity == null){
//            throw new IllegalArgumentException("Invalid arguments: " + product + " " + quantity);
//        }
//
//        LineItem lineItem = new LineItem();
//        lineItem.setProduct(product);
//        lineItem.setQuantity(quantity);
//        lineItemService.save(lineItem);
//
//    }
//
//    public Invoice buy(Customer customer){
//        if(customer == null){
//            throw new IllegalArgumentException("Invalid argument: " + customer);
//        }
//        if(lineItemList.isEmpty()){
//            throw new IllegalArgumentException("Invalid argument, list cannot be null");
//        }
//
//        Invoice invoice = new Invoice();
//        invoice.setCustomer(customer);
//        invoice.setLineItemList(lineItemList);
//        invoice.setTotal(BigDecimal.valueOf(8.5));
//        Invoice generatedInvoice = invoiceService.save(invoice);
//
//        for(LineItem lineItem : lineItemList){
//            lineItem.setInvoice(generatedInvoice);
//            lineItemService.save(lineItem);
//        }
//
//        return generatedInvoice;
//    }

}
