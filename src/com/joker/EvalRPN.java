package com.joker;

import java.util.Stack;
import java.util.regex.*;

public class EvalRPN {
    public static void main(String[] args) {
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(evalRPN(tokens));
    }

    private static int evalRPN(String[] tokens) {
        Stack<Integer> integerStack = new Stack<>();
        for (String token : tokens) {
            if (Pattern.matches("-*\\d+", token)) {
                integerStack.push(Integer.parseInt(token));
            } else {
                int num2 = integerStack.pop();
                int num1 = integerStack.pop();
                int val = 0;
                switch (token) {
                    case "+":
                        val = num1 + num2;
                        break;
                    case "-":
                        val = num1 - num2;
                        break;
                    case "*":
                        val = num1 * num2;
                        break;
                    case "/":
                        val = num1 / num2;
                        break;
                }
                integerStack.push(val);
            }
        }

        return integerStack.pop();
    }
}
