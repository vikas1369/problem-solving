package com.vikas.core.leetcode.slidingwindow;

import java.util.Arrays;

public class PermutationInString {
    public static void main(String[] args){

    }

    public boolean checkInclusion(String s1, String s2) {
        int[] s1Arr = new int[26];
        int[] s2Arr = new int[26];

        Arrays.fill(s1Arr,0);
        Arrays.fill(s2Arr,0);

        for(int i = 0;i< s1.length();i++){
            s1Arr[s1.charAt(0)-'a'] = s1Arr[s1.charAt(0)-'a'] + 1;
            s2Arr[s2.charAt(0)-'a'] = s2Arr[s2.charAt(0)-'a'] + 1;
        }

        int countMatches = 0;

        for(int i = 0;i< 26;i++){
            if(s1Arr[i] == s2Arr[i]){
                countMatches++;
            }
        }

        for(int i =0;i<s2.length()-s1.length();i++){
            if(countMatches == 26){
                return true;
            }

            int r = s2.charAt(i+s1.length())- 'a';
            int l = s2.charAt(i)-'a';

            s2Arr[r] += 1;
            if(s2Arr[r] == s1Arr[r]){
                countMatches++;
            }else if(s2Arr[r] == s1Arr[r]+1){
                countMatches--;
            }

            s1Arr[l] -= 1;
            if(s2Arr[l] == s1Arr[l]){
                countMatches++;
            }else if(s2Arr[l] == s1Arr[l]-1){
                countMatches--;
            }
        }

        return countMatches == 26;
    }
}
