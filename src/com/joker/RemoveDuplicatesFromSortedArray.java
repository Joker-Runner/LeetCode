package com.joker;

/**
 * 26. Remove Duplicates from Sorted Array
 */
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if(nums.length<=1)
            return nums.length;

        int realIndex =0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[realIndex]){
                nums[++realIndex]=nums[i];
            }
        }
        return ++realIndex;
    }
}
