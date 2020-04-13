package com.joker;

/**
 * 84. Largest Rectangle in Histogram
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
 */
public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        int[] heights = new int[]{2,1,5,6,2,3};
        System.out.println(largestRectangleArea(heights));
    }

    public static int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int count = heights[i];
            for (int j = i - 1; j < i; j--) {
                if (j < 0 || heights[j] < heights[i])
                    break;
                else
                    count += heights[i];
            }
            for (int j = i + 1; j < heights.length; j++) {
                if (heights[j] < heights[i])
                    break;
                else
                    count += heights[i];
            }
            if (count > maxArea)
                maxArea = count;
        }
        return maxArea;
    }
}
