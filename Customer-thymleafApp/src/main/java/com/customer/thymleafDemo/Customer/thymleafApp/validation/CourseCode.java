package com.customer.thymleafDemo.Customer.thymleafApp.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CourseCodeConstrativeValidator.class) // which class will validate this or which class has the logic
@Target({ElementType.FIELD,ElementType.METHOD}) // where i can apply this annotation on
@Retention(RetentionPolicy.RUNTIME) // how long the annotation will be used

public @interface CourseCode {

    // define default course code

    public String value() default "course";

    // define default error message

    public String message() default "The course should start with course";

    // define default group

    public Class<?>[] groups () default {};

    // define payload

    public Class<? extends Payload>[] payload() default{};

}
