package com.customer.thymleafDemo.Customer.thymleafApp.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstrativeValidator implements ConstraintValidator<CourseCode,String> {

    private String coursePrefix;


    @Override
    public void initialize(CourseCode theCourseCode) {
        coursePrefix = theCourseCode.value();
    }

    @Override
    public boolean isValid(String courseCode, ConstraintValidatorContext constraintValidatorContext) { // the courseCode is the value we will get from the html form
        if(courseCode!=null)
            return courseCode.startsWith(coursePrefix);
        return false;
    }
}
