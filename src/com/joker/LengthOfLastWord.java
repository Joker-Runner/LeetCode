package com.joker;

/**
 * 58. Length of Last Word
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word (last word means the last appearing word if we loop from left to right) in the string.
 *
 * If the last word does not exist, return 0.
 */
public class LengthOfLastWord {
    public static void main(String[] args) {
        System.out.println(lengthOfLastWordBetter("Hello world! "));
    }

    public static int lengthOfLastWord(String s) {
        char[] chars = s.toCharArray();
        int length = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == ' ') {
                if (length > 0)
                    return length;
                length = 0;
            } else {
                length++;
            }
        }
        return length;
    }

    /**
     * 这种方法不用存放所有的字符，对于超长字符串比较友好（不过也要看charAt的内部实现）
     * @param s
     * @return
     */
    public static int lengthOfLastWordBetter(String s) {
        int length = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (length > 0)
                    return length;
                length = 0;
            } else {
                length++;
            }
        }
        return length;
    }
}
