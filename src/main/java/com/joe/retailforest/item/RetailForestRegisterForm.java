package com.joe.retailforest.item;

public class RetailForestRegisterForm extends RegisterForm {

    private String gender;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "RetailForestRegisterForm{" +
                "titleCode='" + getTitleCode() + '\'' +
                ", firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
