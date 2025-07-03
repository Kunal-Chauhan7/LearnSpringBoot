package com.kunal.myCoolApp.Common;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Lazy
@Component
// making the bean as Protype
// @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class BasketBallCoach implements Coach{
    @Override
    public String getDailyWorkOut() {
        return "Do practice the shooting";
    }
}
