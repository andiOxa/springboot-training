package com.ucx.training.shop.config;

import com.ucx.training.shop.beans.TheBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean(name = "bean1")
    public TheBean getBean1(){
        return new TheBean();
    }

    @Bean(name = "bean2")
    public TheBean getBean2(){
        return new TheBean();
    }



}
