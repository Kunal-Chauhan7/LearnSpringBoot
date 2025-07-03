package com.kunal.myCoolApp.Common;

public class SwimCoach implements Coach {

    public SwimCoach() {
        System.out.println("Inside the Constructor" + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkOut() {
        return "Swim thousand meters as a warmup";
    }
}
