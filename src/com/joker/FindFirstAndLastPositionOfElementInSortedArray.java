package com.joker;

/**
 * 34. Find First and Last Position of Element in Sorted Array
 *
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * If the target is not found in the array, return [-1, -1].
 */
public class FindFirstAndLastPositionOfElementInSortedArray {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        int[] res = searchRangeBetter(nums, 3);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }

    public static int[] searchRange(int[] nums, int target) {

        if (nums.length == 0 || target < nums[0] || target > nums[nums.length - 1])
            return new int[]{-1, -1};

        int mid = nums.length / 2;
        int startIndex = 0, endIndex = nums.length - 1;

        while (startIndex + 1 < endIndex) {
            if (nums[mid] == target || nums[startIndex] == target || nums[endIndex] == target) {
                mid = nums[mid] == target ? mid : nums[startIndex] == target ? startIndex : endIndex;
                int midLeft = mid, midRight = mid;
                while (midLeft > 0 && nums[midLeft - 1] == target)
                    midLeft--;
                while (midRight < nums.length - 1 && nums[midRight + 1] == target)
                    midRight++;

                return new int[]{midLeft, midRight};
            } else if (nums[mid] > target) {
                endIndex = mid;
                mid = (startIndex + mid) / 2;
            } else {
                startIndex = mid;
                mid = (endIndex + mid) / 2;
            }
        }

        if (nums[startIndex] == target && nums[endIndex] == target) {
            return new int[]{startIndex, endIndex};
        } else if (nums[startIndex] == target) {
            return new int[]{startIndex, startIndex};
        } else if (nums[endIndex] == target) {
            return new int[]{endIndex, endIndex};
        }

        return new int[]{-1, -1};
    }

    public static int[] searchRangeBetter(int[] nums, int target) {

        if (nums.length == 0 || target < nums[0] || target > nums[nums.length - 1])
            return new int[]{-1, -1};

        int startIndex = 0, endIndex = nums.length - 1;

        while (startIndex < endIndex) {
            int mid = (startIndex + endIndex) / 2;
            if (nums[mid] == target) {
                int midLeft = mid, midRight = mid;
                while (midLeft > 0 && nums[midLeft - 1] == target)
                    midLeft--;// 注意，避免了陷入死循环！！！
                while (midRight < nums.length - 1 && nums[midRight + 1] == target)
                    midRight++;// 注意，避免了陷入死循环！！！

                return new int[]{midLeft, midRight};
            } else if (nums[mid] > target) {
                endIndex = mid - 1;
            } else if (nums[mid] < target) {
                startIndex = mid + 1;
            }
        }
        /**
         * 也可以把while循环改成<=，然后去掉这一段，不过那样LeetCode性能会变差一点儿
         */
        if (startIndex == endIndex && nums[startIndex] == target) {
            return new int[]{startIndex, endIndex};
        }
        return new int[]{-1, -1};
    }
}
