package com.joker;

import java.util.Arrays;

public class SearchInRotatedSortedArray {

    public static void main(String[] args) {

//        int[] temp = new int[]{6, 7, 0, 1, 2, 3, 4, 5};
//        System.out.println(findMaxIndex(temp));


        int[] nums = new int[]{3, 1};
        System.out.println(findMaxIndex(nums));

        System.out.println(search(nums, 30));
    }

    public static int search(int[] nums, int target) {
        if (nums.length == 0) return -1;

        int maxIndex = findMaxIndex(nums);

        int startIndex = -1 * (nums.length - (maxIndex + 1)), endIndex = maxIndex;

        while (startIndex <= endIndex) {
            int mid = (startIndex + endIndex) / 2;
            if (get(nums, mid) == target) {
                if (mid < 0) {
                    return nums.length + mid;
                } else return mid;
            } else if (get(nums, mid) > target) {
                endIndex = mid - 1;
            } else if (get(nums, mid) < target) {
                startIndex = mid + 1;
            }
        }
        return -1;
    }

    public static int get(int[] nums, int index) {
        if (index < 0)
            return nums[nums.length + index];
        else
            return nums[index];
    }

    public static int findMaxIndex(int[] nums) {
        if (nums.length <= 1 || nums[0] < nums[nums.length - 1]) {
            return nums.length - 1;
        }
        int startIndex = 0, endIndex = nums.length - 1;
        while (true) {
            int mid = (startIndex + endIndex) / 2;
            if (nums[startIndex] < nums[mid]) {//这个区间正序
                int nextIndex = mid < nums.length - 1 ? mid + 1 : 0;
                if (nums[mid] > nums[nextIndex]) {
                    return mid;
                } else {
                    startIndex = mid + 1;
                }
            } else {
                int nextIndex = endIndex < nums.length - 1 ? endIndex + 1 : 0;
                if (nums[endIndex] > nums[nextIndex])
                    return endIndex;
                else
                    endIndex = mid;
            }

        }
    }

}
