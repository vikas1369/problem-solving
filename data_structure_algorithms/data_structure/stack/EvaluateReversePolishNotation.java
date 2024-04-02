package com.vikas.core.leetcode.stack;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public static void main(String[] args){

    }
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();

        for(String token: tokens){
            if("+".equals(token)){
                int operand2 = Integer.parseInt(stack.pop());
                int operand1 = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(operand1+operand2));
            }else if("-".equals(token)){
                int operand2 = Integer.parseInt(stack.pop());
                int operand1 = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(operand1-operand2));
            }else if("*".equals(token)){
                int operand2 = Integer.parseInt(stack.pop());
                int operand1 = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(operand1*operand2));
            }else if("/".equals(token)){
                int operand2 = Integer.parseInt(stack.pop());
                int operand1 = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(operand1/operand2));
            }else{
                stack.push(token);
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
