package com.ucx.training.shop.service;

import com.ucx.training.shop.beans.TheBean;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


import javax.annotation.PostConstruct;

@Component
@Log4j2
public class BeanService {

    @Qualifier("bean1")
    @Autowired
    private TheBean bean;


//    public BeanService(TheBean bean){
//        this.bean = bean;
//    }


    @PostConstruct
    public void init(){
        bean.setName("Bean");
        log.info("Testing the bean: " + bean.getName());

    }
}
