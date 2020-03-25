package com.joker;

public class ToLowerCase {
    public static void main(String[] args) {
        String lowerCase = toLowerCase("Hello World");
        System.out.println(lowerCase);
    }

    private static String toLowerCase(String str) {

        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 'A' && chars[i] <= 'Z') {
                chars[i] = (char) (chars[i] + ('a' - 'A'));
            }
        }

        return new String(chars);
    }

//    private static String toLowerCase(String str) {
////        str.toLowerCase();
//
//        StringBuffer sb = new StringBuffer();
//        char[] chars = str.toCharArray();
//        for (char ch : chars) {
//            if (ch >= 'A' && ch <= 'Z') {
//                char tempChar = ((char) (ch + ('a' - 'A')));
//                sb.append(tempChar);
//            } else {
//                sb.append(ch);
//            }
//        }
//
//        return sb.toString();
//    }
}
