//making this class as config
package com.kunal.myCoolApp.config;

import com.kunal.myCoolApp.Common.Coach;
import com.kunal.myCoolApp.Common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// using this annotation to make this class as config

@Configuration
public class SportConfig {

    // defining the bean method to config the bean
    // using the @bean annotation

    @Bean("aqua") // making bean custom name
//    @Bean
    // bean id here is swimCoach
    // bean id defaults to the method name
    public Coach swimCoach(){
        return new SwimCoach();
    }

}
