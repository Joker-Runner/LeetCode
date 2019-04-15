package com.joker;

public class ToLowerCase {
    public static void main(String[] args) {
        String lowerCase = toLowerCase("Hello World");
        System.out.println(lowerCase);
    }

    private static String toLowerCase(String str) {
//        str.toLowerCase();

        StringBuffer sb = new StringBuffer();
        char[] chars = str.toCharArray();
        for (char ch : chars) {
            if (ch >= 'A' && ch <= 'Z') {
                char tempChar = ((char) (ch + ('a' - 'A')));
                sb.append(tempChar);
            } else {
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}
