package com.joe.leetcodetest;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    public static int romanToInt(String s) {

        Map<String,Integer> Roman = new HashMap<String, Integer>();
        Roman.put("IV",4);
        Roman.put("IX",9);
        Roman.put("XL",40);
        Roman.put("XC",90);
        Roman.put("CD",400);
        Roman.put("CM",900);
        Roman.put("I",1);
        Roman.put("V",5);
        Roman.put("X",10);
        Roman.put("L",50);
        Roman.put("C",100);
        Roman.put("D",500);
        Roman.put("M",1000);

        int ans = 0;
        for(int i = 0;i<s.length();i++){
            System.out.println("i :"+i);
            if (i+2<=s.length()&&Roman.containsKey(s.substring(i,i+2))){

                ans +=  Roman.get(s.substring(i, i + 2));

                System.out.println("s :"+s.substring(i, i+2)+" value :"+Roman.get(s.substring(i, i + 2)));
                i++;
            }else {
                System.out.println("s :"+s.substring(i, i+1)+" value :"+Roman.get(s.substring(i, i + 1)));
                ans += Roman.get(s.substring(i,i+1));
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }


}
