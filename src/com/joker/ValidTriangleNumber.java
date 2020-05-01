package com.joker;

import java.util.Arrays;

public class ValidTriangleNumber {
    public int triangleNumber(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                int[] side3Range = findRange(nums[i], nums[j]);
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[k] > side3Range[0] && nums[k] < side3Range[1])
                        count++;
                }
            }
        }
        return count;
    }

    private static int[] findRange(int side1, int side2) {
        return new int[]{side1 > side2 ? side1 - side2 : side2 - side1, side1 + side2};
    }


//////////////////////////////////////////

    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 3, 4};

        System.out.println(triangleNumberSort(nums));
    }

    public static int triangleNumberSort(int[] nums) {
        int count = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                int maxSide3 = nums[i] + nums[j];
                count += count(nums, j + 1, maxSide3);
            }
        }
        return count;
    }

    private static int count(int[] nums, int initStartIndex, int rightTarget) {
        if (nums[initStartIndex] >= rightTarget) {
            return 0;
        }

        int startIndex = initStartIndex, endIndex = nums.length - 1;

        while (startIndex < endIndex) {
            int mid = (startIndex + endIndex) / 2;
            if (nums[mid] == rightTarget) {
                while (--mid < startIndex || nums[mid] < rightTarget) {
                    return mid - startIndex + 1;
                }
            } else if (nums[mid] > rightTarget) {
                endIndex = mid - 1;
            } else if (nums[mid] < rightTarget) {
                startIndex = mid + 1;
            }
        }

        if (nums[startIndex] >= rightTarget) {
            return startIndex - initStartIndex;
        } else if(nums[endIndex] == rightTarget){
            return endIndex - initStartIndex;
        }else {
            return endIndex - initStartIndex + 1;
        }
    }
}
