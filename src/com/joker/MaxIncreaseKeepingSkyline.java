package com.joker;

import java.util.Arrays;
import java.util.Collections;

public class MaxIncreaseKeepingSkyline {
    public static void main(String[] args) {
        int[][] grid = {{3, 0, 8, 4}, {2, 4, 5, 7}, {9, 2, 6, 3}, {0, 3, 1, 0}};
        System.out.println(maxIncreaseKeepingSkyline(grid));
    }

    public static int maxIncreaseKeepingSkyline(int[][] grid) {
        int increaseHeight = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                increaseHeight += maxHeight(grid, i, j) - grid[i][j];
            }
        }

        return increaseHeight;
    }

    private static int maxHeight(int[][] grid, int i, int j) {
        int maxh = 0;
        for (int k = 0; k < grid[i].length; k++) {
            maxh = maxh < grid[i][k] ? grid[i][k] : maxh;
        }
        int maxV = 0;
        for (int[] ints : grid) {
            if (ints.length > j) {
                maxV = ints[j] > maxV ? ints[j] : maxV;
            }
        }
        return maxV > maxh ? maxh : maxV;
    }
}
