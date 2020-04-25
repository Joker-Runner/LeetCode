package com.joker;

/**
 * 263. Ugly Number
 *
 * Write a program to check whether a given number is an ugly number.
 *
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 */
public class UglyNumber {

    public static void main(String[] args) {
        System.out.println(isUgly(6));
    }

    public static boolean isUgly(int num) {
        if (num == 1)
            return true;
        else if (num == 0)
            return false;
        if (num % 2 == 0 && isUgly(num / 2))
            return true;
        if (num % 3 == 0 && isUgly(num / 3))
            return true;
        if (num % 5 == 0 && isUgly(num / 5))
            return true;
        return false;
    }

}
