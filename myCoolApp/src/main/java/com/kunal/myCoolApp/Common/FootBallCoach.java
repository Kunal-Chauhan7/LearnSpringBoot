package com.kunal.myCoolApp.Common;

import org.springframework.stereotype.Component;

@Component
public class FootBallCoach implements Coach {

    @Override
    public String getDailyWorkOut() {
        return "Do run !";
    }
}
