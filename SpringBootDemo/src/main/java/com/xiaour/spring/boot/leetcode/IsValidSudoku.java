package com.xiaour.spring.boot.leetcode;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/valid-sudoku/
 * 有效的数独
 *
 * @author rtw
 * @since 2024/6/30
 */
public class IsValidSudoku {

    public static void main(String[] args) {
        char[][] board ={
        {'5', '3', '4', '.', '7', '.', '.', '.', '.'},
        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        boolean validSudoku = IsValidSudoku.isValidSudoku(board);
        System.out.println(JSON.toJSONString(validSudoku));
    }


    public static boolean isValidSudoku(char[][] board) {
        // 行上的数据情况
        int[][] rows = new int[10][10];
        // 列上的数据情况
        int[][] col = new int[10][10];
        // 小方格的数据情况
        int[][][] allBox = new int[3][3][10];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                // 遍历每一个数字
                if (board[i][j] != '.') {
                    int number = board[i][j] - '0';
                    rows[i][number]++;
                    col[j][number]++;
                    allBox[i/3][j/3][number]++;

                    if (rows[i][number] > 1 || col[j][number] > 1 || allBox[i/3][j/3][number] > 1) {
                        return false;
                    }
                }


            }
        }
        return true;
    }
}
