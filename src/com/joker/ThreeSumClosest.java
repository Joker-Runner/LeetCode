package com.joker;


import static java.lang.Math.abs;

public class ThreeSumClosest {

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 8, 16, 32, 64, 128};
        int sumClosest = threeSumClosest(nums, 82);
        System.out.println(sumClosest);
    }

    public static int threeSumClosest(int[] nums, int target) {
        int min = Math.abs((nums[0] + nums[1] + nums[2]) - target);
        int minSum = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                int temp = nums[i] + nums[j];
                for (int k = j + 1; k < nums.length; k++) {
                    int tempMin = Math.abs((temp + nums[k]) - target);
                    if (tempMin < min) {
                        min = tempMin;
                        minSum = temp + nums[k];
                        if (tempMin == 0)
                            return minSum;
                    }
                }
            }
        }

        return minSum;
    }
}
