package com.joker;

public class PowerOfFour {
    public static void main(String[] args) {

        System.out.printf("%032x", Integer.MAX_VALUE);

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
        System.out.println(Integer.toBinaryString(Integer.MIN_VALUE));
        System.out.println(Integer.toBinaryString(1));
        System.out.println(Integer.toBinaryString(0));
        System.out.println(Integer.toBinaryString(-1));
        System.out.printf("%x", Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);

//        System.out.println("/////////////");
//        for (int i = 0; i < 100; i++) {
//            if ((i&(i-1)) == 0){//((i ^ (i - 1)) == (i + i - 1)) {
//                System.out.println(i);
//            }
//
//        }
//        System.out.println(isPowerOfFour(16));
    }

    public static boolean isPowerOfFour(int num) {
//        是2的幂并且-1能被三整除
        return num > 0 && (num & (num - 1)) == 0 && (num - 1) % 3 == 0;
    }
}
