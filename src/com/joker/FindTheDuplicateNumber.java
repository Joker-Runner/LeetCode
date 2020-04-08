package com.joker;

/**
 * 287. Find the Duplicate Number
 */
public class FindTheDuplicateNumber {
    int result = 0;

    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j])
                    return nums[i];
            }
        }
        return 0;
    }
}
