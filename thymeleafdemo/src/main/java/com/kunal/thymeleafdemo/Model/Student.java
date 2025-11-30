package com.kunal.thymeleafdemo.Model;

import java.util.List;

public class Student {
    private String firstName;
    private String lastName;
    private String country;
    private String favLanguage;
    private List<String> favOs;

    public List<String> getFavOs() {
        return favOs;
    }

    public void setFavOs(List<String> favOs) {
        this.favOs = favOs;
    }

    public String getFavLanguage() {
        return favLanguage;
    }

    public void setFavLanguage(String favLanguage) {
        this.favLanguage = favLanguage;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
