package com.vikas.core.leetcode.dp;

public class LongestPalindrom {
    public static void main(String[] args){

    }

    public String longestPalindrome(String s) {
        if(s.length()<=1){
            return s;
        }
        String odd = null;
        String even = null;
        String maxStr = s.substring(0,1);
        for(int i = 0;i<s.length();i++){
            odd = expandFromCenter(s, i, i);
            even = expandFromCenter(s, i, i+1);
            if(odd.length() > maxStr.length()){
                maxStr = odd;
            }

            if(even.length() > maxStr.length()){
                maxStr = even;
            }
        }
        return maxStr;
    }

    public String expandFromCenter(String s, int left, int right){
        while(left >=0 && right <s.length() && (s.charAt(left) == s.charAt(right))){
            left--;
            right++;
        }
        return s.substring(left+1, right);
    }
}
