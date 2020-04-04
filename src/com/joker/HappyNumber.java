package com.joker;

import java.util.ArrayList;
import java.util.List;

public class HappyNumber {

    public static void main(String[] args) {
        boolean is =  isHappy(7);
        System.out.println(is);
    }

    static List<Integer> list = new ArrayList<>();

    public static boolean isHappy(int n) {
        while (true) {
            if(n == 1)
                return true;

            if (list.contains(n))
                return false;
            else {
                list.add(n);
                n = digitSquareSum(n);
            }
        }
    }

    private static int digitSquareSum(int n) {
        int sum = 0;
        for (; n > 0; n = n / 10) {
            int yushu = n % 10;
            sum += yushu * yushu;
        }
        return sum;
    }


    /**
     * 大神版本，也算得上那种快慢指针的逻辑
     * @param n
     * @return
     */
    boolean isHappyFasterVer(int n) {
        int slow, fast;
        slow = fast = n;
        do {
            slow = digitSquareSum(slow);
            fast = digitSquareSum(fast);
            fast = digitSquareSum(fast);
            if(fast == 1) return true;
        } while(slow != fast);
        return false;
    }

}
