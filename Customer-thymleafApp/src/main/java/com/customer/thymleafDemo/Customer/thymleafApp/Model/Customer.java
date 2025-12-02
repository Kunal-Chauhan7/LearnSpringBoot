package com.customer.thymleafDemo.Customer.thymleafApp.Model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Customer {

    private String firstName;

    @NotNull(message = "This field is required!")
    @Size(min = 1 , message = "This field should have length of minimum of 1")
    private String lastName;

    @Min(value = 0,message = "The Value should be greater or equal than 0")
    @Max(value = 10 , message = "the value should be less than or equal to 10")
    private int pass;

    public int getPass() {
        return pass;
    }

    public void setPass(int pass) {
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
