package com.kunal.chauhan.RestCRUD.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test") // request for /test goes here
public class DemoController {


    // code /hello end point
    @GetMapping("/hello")
    public String sayHello(){
        return "Hello World!";
    }
}
