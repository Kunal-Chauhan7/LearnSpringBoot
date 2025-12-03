package com.customer.thymleafDemo.Customer.thymleafApp.Model;

import jakarta.validation.constraints.*;

public class Customer {

    private String firstName;

    @NotNull(message = "This field is required!")
    @Size(min = 1 , message = "This field should have length of minimum of 1")
    private String lastName;

    @NotNull(message = "This field is required")
    @Min(value = 0,message = "The Value should be greater or equal than 0")
    @Max(value = 10 , message = "the value should be less than or equal to 10")
    private Integer pass;

    @Pattern(regexp = "^[a-zA-Z0-9]{5}" , message = "only 5 char/digits")
    private String postalCode;

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Integer getPass() {
        return pass;
    }

    public void setPass(Integer pass) {
        this.pass = pass;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
