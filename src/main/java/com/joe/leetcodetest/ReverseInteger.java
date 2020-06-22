package com.joe.leetcodetest;

public class ReverseInteger {

        public static int reverse(int x) {
            int y=x<0?-x:x;
            String stringValue = Integer.toString(y);
            int[] array = new int[stringValue.length()];
            for(int i =0;i< array.length;i++){

                String s2 = stringValue.substring(array.length-i-1, array.length-i); // 利用 substring() 來捉每一個字元
                array[i]=Integer.parseInt(s2);
            }

            String s =new String();
            for(int num:array){
                System.out.println(num);
                s=s.concat(Integer.toString(num));
            }
            System.out.println("s:"+s);
            int ans = Integer.parseInt(s);
            ans = x<0?-ans:ans;
            return ans;
        }

    public static void main(String[] args) {
        System.out.println(reverse(-1234));
    }
}
