package com.example.springboot_practice;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype") //will now work here, use with @Bean annotation
public class BeanCreation {

    public void bean(){
        System.out.println("Bean created");
    }

    @PostConstruct
    public void afterInit(){
        System.out.println("Before paying");
    }

    @PreDestroy
    public void beforeDestroy(){
        System.out.println("After paying");
    }
}
