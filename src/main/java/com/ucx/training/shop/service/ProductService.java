package com.ucx.training.shop.service;

import com.ucx.training.shop.entity.Product;
import com.ucx.training.shop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ProductService extends BaseService<Product,Integer> {
    @Autowired
    private ProductRepository productRepository;


}
