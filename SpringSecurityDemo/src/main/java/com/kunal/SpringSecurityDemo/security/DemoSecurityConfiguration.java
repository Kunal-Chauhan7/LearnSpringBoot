package com.kunal.SpringSecurityDemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class DemoSecurityConfiguration {
    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){
        UserDetails kunal = User.builder()
                .username("kunal")
                .password("{noop}kunal123")
                .roles("ADMIN","MANAGER")
                .build();

        UserDetails khushi = User.builder()
                .username("khushi")
                .password("{noop}khushi123")
                .roles("EMPLOYEE","MANAGER")
                .build();

        return new InMemoryUserDetailsManager(kunal,khushi);
    }
}
