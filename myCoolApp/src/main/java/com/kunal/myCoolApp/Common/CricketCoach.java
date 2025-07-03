package com.kunal.myCoolApp.Common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

// this spring bean will be used if no qualifier is mentioned means it will act as default
@Primary
// spring bean annotation
@Component
public class CricketCoach implements Coach {

    @PostConstruct
    public void init(){
        System.out.println("I am in Init method or startup method");
    }

    @Override
    public String getDailyWorkOut() {
        return "Practice fast bowling for 15 minutes";
    }


    @PreDestroy
    public void destruction(){
        System.out.println("I am about to destroy the bean instance");
    }
}
