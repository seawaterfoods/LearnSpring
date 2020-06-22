package com.joe.leetcodetest;

import java.util.ArrayList;
import java.util.List;

public class BuildAnArrayWithStackOperations {
    public static List<String> buildArray(int[] target, int n) {
        List<String> ans = new ArrayList<String>();
        for(int i=0 ; i < target[target.length - 1] ;i++){
            int j=1;
            ans.add("Push");

            if(j<target[i]){
                ans.add("Pop");
            }
            j++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] target = {1,3};
        System.out.println(buildArray(target, 3));

    }
}
