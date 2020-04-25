package com.joker;

/**
 * 414. Third Maximum Number
 * <p>
 * Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number. The time complexity must be in O(n).
 */
public class ThirdMaximumNumber {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2, 5, 3, 5};
        System.out.println(thirdMax(nums));
    }

    public static int thirdMax(int[] nums) {
        if (nums.length > 3) {
            for (int i = 3; i < nums.length; i++) {
                if (nums[0] == nums[1] || nums[0] == nums[2]) {
                    nums[0] = nums[i];
                    continue;
                } else if (nums[1] == nums[2]) {
                    nums[1] = nums[i];
                    continue;
                }

                if (nums[i] == nums[0] || nums[i] == nums[1] || nums[i] == nums[2])
                    continue;

                int minIndex = 0;
                minIndex = nums[1] < nums[minIndex] ? 1 : minIndex;
                minIndex = nums[2] < nums[minIndex] ? 2 : minIndex;

                if (nums[i] > nums[minIndex]) {
                    nums[minIndex] = nums[i];
                }
            }
        }
        if (nums.length >= 3) {
            if (nums[0] == nums[1] || nums[0] == nums[2]) {
                return Math.max(nums[1], nums[2]);
            } else if (nums[1] == nums[2]) {
                return Math.max(nums[0], nums[1]);
            }
            return Math.min(Math.min(nums[0], nums[1]), nums[2]);
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        } else {
            return nums[0];
        }
    }
}
