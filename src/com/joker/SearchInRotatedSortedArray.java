package com.joker;

import java.util.Arrays;

public class SearchInRotatedSortedArray {

    public static void main(String[] args) {

        int[] temp = new int[]{6, 7, 0, 1, 2, 3, 4, 5};
        System.out.println(findMaxIndex(temp));


        int[] nums = new int[]{57, 58, 59, 62, 63, 66, 68, 72, 73, 74, 75, 76, 77, 78, 80, 81, 86, 95, 96, 97, 98, 100, 101, 102, 103, 110, 119, 120, 121, 123, 125, 126, 127, 132, 136, 144, 145, 148, 149, 151, 152, 160, 161, 163, 166, 168, 169, 170, 173, 174, 175, 178, 182, 188, 189, 192, 193, 196, 198, 199, 200, 201, 202, 212, 218, 219, 220, 224, 225, 229, 231, 232, 234, 237, 238, 242, 248, 249, 250, 252, 253, 254, 255, 257, 260, 266, 268, 270, 273, 276, 280, 281, 283, 288, 290, 291, 292, 294, 295, 298, 299,
                4, 10, 13, 15, 16, 17, 18, 20, 22, 25, 26, 27, 30, 31, 34, 38, 39, 40, 47, 53, 54};


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
        if (nums.length <= 1) {
            return nums.length - 1;
        }
//        6, 7, 0, 1, 2, 3, 4, 5
        int startIndex = 0, endIndex = nums.length - 1;
        while (true) {
            int mid = (startIndex + endIndex) / 2 % nums.length;
//            int lastIndex = (mid + nums.length) % nums.length - 1;
//            int nextIndex = mid % nums.length + 1;
            int lastIndex = mid > 0 ? mid - 1 : nums.length - 1;
            int nextIndex = mid < nums.length - 1 ? mid + 1 : 0;
            if (nums[mid] > nums[lastIndex] && nums[mid] > nums[nextIndex])
                return mid;
            else if (nums[mid] > nums[lastIndex]) {
                if (mid == endIndex) {
                    startIndex = mid + 2;
                }
                startIndex = mid + 1;
            } else if (nums[mid] > nums[nextIndex]) {
                endIndex = mid - 1;
            } else {
                return mid - 1;
            }
        }
    }

}
