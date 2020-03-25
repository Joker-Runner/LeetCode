package com.joker;

import java.util.Stack;

public class RemoveOuterParentheses {
    public static void main(String[] args) {
        String s = removeOuterParentheses("(()())(())(()(()))");
        System.out.println(s);
    }

    private static String removeOuterParentheses(String S) {
        StringBuilder stringBuilder = new StringBuilder();

        Stack<Character> characterStack = new Stack<>();
        boolean isOuter = true;
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if (!isOuter) {
                if (ch == '(') {
                    stringBuilder.append(characterStack.push(ch));
                } else {
                    if (!characterStack.empty()) {
                        characterStack.pop();
                        stringBuilder.append(')');
                    } else {
                        isOuter = true;
                    }
                }
            } else {
                isOuter = false;
            }
        }

        return stringBuilder.toString();
    }
}
