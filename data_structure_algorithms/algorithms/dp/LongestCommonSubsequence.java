package com.vikas.core.leetcode.dp;

public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        int[][] c = new int[m+1][n+1];

        for(int i =0;i<c.length;i++){
            c[i][0] = 0;
        }

        for(int i =0;i<c[0].length;i++){
            c[0][i] = 0;
        }

        for(int i =0;i<c.length;i++){
            for(int j=0;j<c[0].length;j++){
                if(text1.charAt(i) == text1.charAt(j)){
                    c[i][j] = c[i-1][j-1]+1;
                }else if(c[i][j-1]>=c[i-1][j]){
                    c[i][j]= c[i][j-1];
                }else{
                    c[i][i] = c[i-1][j];
                }
            }
        }

        return c[m][n];

    }
}
