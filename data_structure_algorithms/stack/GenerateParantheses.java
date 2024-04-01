package com.vikas.core.leetcode.stack;

import java.util.ArrayList;
import java.util.List;

public class GenerateParantheses {
    public static void main(String[] args){
        GenerateParantheses generateParantheses = new GenerateParantheses();
        System.out.println(generateParantheses.generateParenthesis(2));
    }

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        generate(list, n, 0, 0,"");
        return list;
    }

    private void generate(List<String> list, int n, int left, int right, String s) {
        if(s.length() == n*2){
            //System.out.println("String"+s);
            list.add(s);
            return;
        }

        if(left<n){
            generate(list, n, left+1, right, s+"(");
        }

        if(right<left){
            generate(list, n, left, right+1, s+")");
        }
    }
}
