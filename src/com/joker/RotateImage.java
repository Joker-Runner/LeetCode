package com.joker;

/**
 * 48
 * You are given an n x n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise).
 */
public class RotateImage {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        rotate(matrix);
        System.out.println(matrix);

    }


    /**
     * 没想明白这个为啥没有还过去又换回来
     * @param matrix
     */
    public static void rotate1(int[][] matrix) {
        int n = matrix.length;
        int[][] newMatrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                newMatrix[j][n - i] = matrix[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = newMatrix[i][j];
            }
        }
    }

    /**
     *
     * @param matrix
     */
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        int tempValue;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n - i - 1; j++) {
                tempValue = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = tempValue;

//                matrix[j][n - i - 1] = matrix[i][j];
//                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
//                matrix[n - j - 1][n - (n - i - 1) - 1] = matrix[n - i - 1][n - j - 1];
//                => matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
//                matrix[n - (n - i - 1) - 1][n - (n - j - 1) - 1] = matrix[n - j - 1][n - (n - i - 1) - 1];
//                => matrix[i][j] = matrix[n - j - 1][i];
            }
        }
    }
}
