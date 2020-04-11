package com.joker;

/**
 * 59. Spiral Matrix II
 * Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 */
public class SpiralMatrixII {

    public static void main(String[] args) {
//                {
//                {1, 2, 3, 4},
//                {12, 13, 14, 5},
//                {11, 16, 15, 6},
//                {10, 9, 8, 7}
//        };

        int[][] ints = GenerateMatrix(3);

    }

    public static int[][] GenerateMatrix(int n) {
        int[][] ints = new int[n][n];

        int direction = 2;//方向按照css的规则
        int no = 1;
        int x = 0, y = 0;
        while (no <= n * n) {
            ints[x][y] = no;
            no++;
            switch (direction) {
                case 1: {
                    x--;
                    if (x < 0 || ints[x][y] > 0) {
                        x++;
                        y++;
                        direction = 2;
                    }
                    break;
                }
                case 2: {
                    y++;
                    if (y >= n || ints[x][y] > 0) {
                        y--;
                        x++;
                        direction = 3;
                    }
                    break;
                }
                case 3: {
                    x++;
                    if (x >= n || ints[x][y] > 0) {
                        x--;
                        y--;
                        direction = 4;
                    }
                    break;
                }
                case 4: {
                    y--;
                    if (y < 0 || ints[x][y] > 0) {
                        y++;
                        x--;
                        direction = 1;
                    }
                    break;
                }
            }
        }

        return ints;
    }
}
