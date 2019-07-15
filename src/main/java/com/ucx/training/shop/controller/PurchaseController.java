package com.ucx.training.shop.controller;

import com.ucx.training.shop.dto.CartDTO;
import com.ucx.training.shop.dto.InvoiceDTO;
import com.ucx.training.shop.dto.PurchaseDTO;
import com.ucx.training.shop.entity.Customer;
import com.ucx.training.shop.entity.Invoice;
import com.ucx.training.shop.entity.LineItem;
import com.ucx.training.shop.service.PurchaseService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Log4j2
@Controller
@RequestMapping("purchase")
public class PurchaseController {

    private PurchaseService purchaseService;

    public PurchaseController(PurchaseService purchaseService){
        this.purchaseService = purchaseService;
    }

    @PostMapping("addtocart")
    public Map<String,Integer> addToCart(@RequestBody CartDTO cartDTO){
        Map<String,Integer> resultMap = new HashMap<>();
        try {
            Integer invoiceId = purchaseService.addToCart(cartDTO.getProductId(), cartDTO.getQuantity(), cartDTO.getInvoiceId());
            resultMap.put("invoiceId", invoiceId);

        }catch (Exception e){
            log.error(e.getMessage());
        }
        return resultMap;
    }

    @PostMapping("buy")
    public InvoiceDTO buy(@RequestBody PurchaseDTO purchaseDTO) {
        InvoiceDTO invoiceDTO = new InvoiceDTO();

        try{
             Invoice invoice = purchaseService.buy(purchaseDTO.getCosumterId(),purchaseDTO.getInvoiceId());
             invoiceDTO.setCustomerName(invoice.getCustomer().getName());
             invoiceDTO.setInvoiceNumber(invoice.getInvoiceNumber());
             invoiceDTO.setTotal(invoice.getTotal());
        }catch(Exception ex){
            log.error(String.format("An error occured while purchasing:%n Customer ID : %d, Invoice: %d" + purchaseDTO.getCosumterId(),purchaseDTO.getInvoiceId()));
        }
        return invoiceDTO;

    }
}
