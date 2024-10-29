package com.xiaour.spring.boot.leetcode.simple.array;

/**
 * 二维数组求和
 * https://leetcode.cn/problems/range-sum-query-2d-immutable/
 *
 * @author rtw
 * @since 2024/10/22
 */
public class NumMatrixV2 {
    int[][] preMatrix = null;

    public static void main(String[] args) {
//        int[][] matrix = new int[][]{
//                {3,0,1,4,2},
//                {5,6,3,2,1},
//                {1,2,0,1,5},
//                {4,1,0,1,7},
//                {1,0,3,0,5}
//        };
        int[][] matrix = new int[][]{
                {-4, -5}
        };
        NumMatrixV2 numMatrix = new NumMatrixV2(matrix);
//        System.out.println(numMatrix.sumRegion(0,0,0,0));
//        System.out.println(numMatrix.sumRegion(0,0,0,1));
        System.out.println(numMatrix.sumRegion(0, 1, 0, 1));
    }

    public NumMatrixV2(int[][] matrix) {
        // 行数MAX
        int m = matrix.length;
        // 列数MAX
        int n = matrix[0].length;
        preMatrix = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 这些主要是为了保证在边角的负数的处理，有些是直接通过 j=1,i=1来进行处理
                if (j == 0 && i == 0) {
                    preMatrix[i][j] = matrix[i][j];
                } else if (i == 0) {
                    preMatrix[i][j] = preMatrix[i][j - 1] + matrix[i][j];
                } else if (j == 0) {
                    preMatrix[i][j] = preMatrix[i - 1][j] + matrix[i][j];
                } else {
                    preMatrix[i][j] = preMatrix[i][j - 1] + preMatrix[i - 1][j] + matrix[i][j] - preMatrix[i - 1][j - 1];
                }
            }
        }

        System.out.println("SUCCESS");
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int pre1 = 0;
        int pre2 = 0;
        int pre3 = 0;
        if (col1 - 1 >= 0) {
            pre1 = preMatrix[row2][col1 - 1];
        }
        if (row1 - 1 >= 0) {
            pre2 = preMatrix[row1 - 1][col2];
        }
        if (row1 - 1 >= 0 && col1 - 1 >= 0) {
            pre3 = preMatrix[row1 - 1][col1 - 1];
        }
        return preMatrix[row2][col2]
                - pre1
                - pre2
                + pre3;
    }
}
