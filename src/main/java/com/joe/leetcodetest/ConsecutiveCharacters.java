package com.joe.leetcodetest;

public class ConsecutiveCharacters {

    public static int maxPower(String s) {
            int len = 0;
            int start = 1;
            int ans = 1;
            while(len<s.length()){
                if(len+1<s.length()&&s.charAt(len)==s.charAt(len+1)){
                    start++;
                }else{
                    if(start>ans){
                        ans=start;
                    }
                    start=1;
                }
                len++;
            }
            return ans;
    }

    public static void main(String[] args) {
        String str = "aaqqwwwsqa";
        System.out.println(maxPower(str));
        int len = 0;
        while(len+1<str.length()){
            System.out.println(str.charAt(len)==str.charAt(len+1));
            len++;
        }
    }
}
