package com.kunal.myCoolApp.rest;

import com.kunal.myCoolApp.Common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    // define a private field for dependency

//    @Value("${creator.name}")
//    private String creator;
//
//    private Coach myCoach;
//    private Coach myCoach2;

    // define a constructor for dependency injection

//    Constructor dependency injection
//    @Autowired
//    public DemoController(@Qualifier("basketBallCoach") Coach theCoach){
//        myCoach = theCoach;
//    }


//  Setter Injection
//    @Autowired
//    public void setMyCoach(Coach theCoach) {
//        myCoach = theCoach;
//    }



    // use of the primary annotation
//    @Autowired
//    public DemoController(Coach thisCoach){
//        myCoach = thisCoach;
//    }



//  checking bean scope default aka singleton case here

//    @Autowired
//    public DemoController(@Qualifier("basketBallCoach") Coach myCoach , @Qualifier("basketBallCoach") Coach myCoach2){
//        this.myCoach = myCoach;
//        this.myCoach2 = myCoach2;
//    }

//    @GetMapping("/Single")
//    public String getCoachBean(){
//        return  "" + (myCoach==myCoach2);
//    }



//    @GetMapping("/getworkout")
//    public String getDailyWorkOut(){
//        return myCoach.getDailyWorkOut() + " " + creator;
//    }




    // Using @Bean annotation by making a java bean config class

    // making an object to inject
    private Coach myCoach;

//    @Autowired
//    public DemoController( @Qualifier("swimCoach") Coach thisCoach) {
//        myCoach = thisCoach;
//    }

    @Autowired
    public DemoController( @Qualifier("aqua") Coach thisCoach) { // using the custom bean name to inject the bean
        myCoach = thisCoach;
    }


    @GetMapping("/getDailyWorkOut")
    public String getdailyWorkOut(){
        return myCoach.getDailyWorkOut();
    }

}
