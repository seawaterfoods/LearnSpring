package com.joe.retailforest.service.impl;

import com.joe.retailforest.item.RequestTradeInfo;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.logging.Logger;

public class CancelOrderNewebpayServiceImpl extends NewebpayServiceImpl{


    private static Logger logger = Logger.getLogger(CancelOrderNewebpayServiceImpl.class.getName());

    @Override
    public String approveTradeInfoString(RequestTradeInfo requestTradeInfo, String sKey, String ivParameter) {
        String result = "";
        Map<String, String> keyValues = new LinkedHashMap<>();
        try {
            keyValues = BeanUtils.describe(requestTradeInfo);
            StringBuilder stringBuilder = new StringBuilder();

//            List<String> sortList = getFiledName(requestTradeInfo);
            Iterator key = keyValues.keySet().iterator();
            Iterator values = keyValues.values().iterator();
            String name ="";
            String value ="";
            while (key.hasNext()){
                name = (String) key.next();
                value = (String) values.next();
                if (value!= null) {
                    stringBuilder.append(name.toUpperCase().charAt(0) + name.substring(1)).append("=").append(value).append("&");
                }
            };
            result = stringBuilder.toString();
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }

        logger.info("Result =============> " + result);
        System.out.println(result);
        return result;
    }

//    private static List<String> getFiledName(Object o) {
//        Field[] fields = o.getClass().getDeclaredFields();
//        List<String> fieldNames = new ArrayList<>();
//        for (int i = 0; i < fields.length; i++) {
//            fieldNames.add(fields[i].getName());
//        }
//        return fieldNames;
//    }
}
