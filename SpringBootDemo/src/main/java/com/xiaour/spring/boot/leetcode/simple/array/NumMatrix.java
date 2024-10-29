package com.xiaour.spring.boot.leetcode.simple.array;

/**
 * 二维数组求和
 * https://leetcode.cn/problems/range-sum-query-2d-immutable/
 *
 * @author rtw
 * @since 2024/10/22
 */
public class NumMatrix {
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
                {-4,-5},
        };
        NumMatrix numMatrix = new NumMatrix(matrix);
//        System.out.println(numMatrix.sumRegion(0,0,0,0));
        System.out.println(numMatrix.sumRegion(0,0,0,1));
    }

    private int[][] preSum;
    public NumMatrix(int[][] matrix) {
        int x = matrix.length, y = matrix[0].length;
        if (x == 0 || y == 0)
            return;
        preSum = new int[x + 1][y + 1];
        for (int n = 1; n < x + 1; n++) {
            for (int m = 1; m < y + 1; m++) {
                preSum[n][m] = matrix[n - 1][m - 1] + preSum[n - 1][m] + preSum[n][m - 1] - preSum[n - 1][m - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return preSum[row2 + 1][col2 + 1] - preSum[row1][col2 + 1] - preSum[row2 + 1][col1] + preSum[row1][col1];
    }
}
