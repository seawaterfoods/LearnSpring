package com.joe.retailforest.test;

import com.joe.retailforest.item.RegisterForm;
import com.joe.retailforest.item.RetailForestRegisterForm;

public class ExtendTest {
    public static void main(String[] args) {

        RegisterForm r1=new RegisterForm();
        r1.setFirstName("aa");
        r1.setLastName("aa");
        r1.setTitleCode("122");

        RetailForestRegisterForm r2 = new RetailForestRegisterForm();

        r2.setFirstName("bb");
        r2.setLastName("bb");
        r2.setTitleCode("bb");
        r2.setGender("bb");


        System.out.println("r1:"+r1);
        System.out.println("r2:"+r2);

        RetailForestRegisterForm r3 = new RetailForestRegisterForm();
        r3=getExtend(r2);

        System.out.println(r3);
    }

    private static RetailForestRegisterForm getExtend(RegisterForm r1) {
        return (RetailForestRegisterForm) r1;
    }

}
