package com.joe.retailforest.test;

import com.joe.retailforest.item.Result;

import java.lang.reflect.Field;

public class getDeclaredFieldsTest {

    public static void main(String[] args) {
        Result result = new Result();

        for(String name:getFiledName(result)) {
            System.out.println(name.toUpperCase().charAt(0) + name.substring(1));
        }
    }

    private static String[] getFiledName(Object o){
        Field[] fields=o.getClass().getDeclaredFields();
        String[] fieldNames=new String[fields.length];
        for(int i=0;i<fields.length;i++){
            fieldNames[i]=fields[i].getName();
        }
        return fieldNames;
    }
}
