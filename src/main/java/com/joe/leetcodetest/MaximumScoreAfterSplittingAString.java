package com.joe.leetcodetest;

public class MaximumScoreAfterSplittingAString {
    public static int maxScore(String s) {

        int ans=0;
        for (int j= 1;j<s.length();j++){
            int left = 0;
            int right = 0;
            System.out.println("j:"+j);
            for(int i = 0;i<j;i++){
                System.out.println("i:"+i);
                if(s.charAt(i)=='0'){
                    left++;
                }
            }
            for(int i=j;i<s.length();i++){
                if(s.charAt(i)=='1'){
                    right++;
                }
            }
            System.out.println("left:"+left+" right:"+right);
            if((left+right)>ans){
                ans=left+right;
            }
            System.out.println("ans:"+ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(maxScore("011101"));
    }
}
