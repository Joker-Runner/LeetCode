package com.joker;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReverseWordsInAString {

    public static void main(String[] args) {
        String str = "the sky is blue";
        System.out.println(reverseWords(str));
    }

    private static String reverseWords(String s) {
        StringBuilder reversedStr = new StringBuilder();

        char[] chars = s.toCharArray();

        int cursor = 0;
        boolean isNotNull = false;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                if (cursor > 0) {
                    if (isNotNull)
                        chars[cursor++] = ' ';
                    else
                        isNotNull = true;
                    reversedStr.insert(0, Arrays.copyOf(chars, cursor));
                }
                cursor = 0;
            } else {
                chars[cursor++] = chars[i];
            }
        }

        if (cursor > 0) {
            if (chars[cursor - 1] != ' ' && isNotNull)
                chars[cursor++] = ' ';
            reversedStr.insert(0, Arrays.copyOf(chars, cursor));
        }

        return reversedStr.toString();
    }
}
