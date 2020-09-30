package com.joe.retailforest.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class regexTest {
    public static final Pattern MOBILE_REGEX = Pattern.compile("^09[0-9]{8}$");
    public static void main(String[] args) {

        String regex = "^09\\d{8}";
        String s = new String("0987654321");

        final Matcher matcher = MOBILE_REGEX.matcher("09876543211");

        System.out.println("matcher.matches():"+matcher.matches());
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(s);
        System.out.println(m.matches());    // => false
    }
}
