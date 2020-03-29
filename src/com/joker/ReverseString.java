package com.joker;

/**
 * 344
 * Write a function that reverses a string. The input string is given as an array of characters char[].
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 */
public class ReverseString {
    public void reverseString(char[] s) {
        char temp;
        int length = s.length;
        for (int i = 0; i < length / 2; i++) {
            temp = s[i];
            s[i] = s[length - i - 1];
            s[length - i - 1] = temp;
        }
    }
}
