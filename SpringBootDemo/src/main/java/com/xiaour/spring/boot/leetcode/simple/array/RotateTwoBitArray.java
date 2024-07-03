package com.xiaour.spring.boot.leetcode.simple.array;

import com.alibaba.fastjson.JSON;

/**
 * https://leetcode.cn/leetbook/read/top-interview-questions-easy/xnhhkv/
 * 旋转图像
 * 1、通过查询到规律，采用暴力解法进行处理
 * 2、发现暴力解法的逻辑连续处理 4 次后，就回到原点，因此从外圈到内圈进行处理，就可以不需要第二个二维数组完成处理。
 * @author rtw
 * @since 2024/6/30
 */
public class RotateTwoBitArray {

    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '4', '7'},
                {'8', '1', '3', '4'},
                {'4', '4', '0', '8'},
                {'2', '6', '7', '1'}
        };

        RotateTwoBitArray.rotateV2(board);
        System.out.println(JSON.toJSONString(board));
    }


    /**
     * 暴力解法
     * idea:找到规律，
     * @param board
     */
    public static void rotate(char[][] board) {
        // 图像的宽度
        int n = board.length;
        char[][] boardnew = new char[n][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                boardnew[j][n-1-i] = board[i][j];
            }
        }
        for (int i = 0; i < boardnew.length; i++) {
            for (int j = 0; j < boardnew[i].length; j++) {
                board[i][j] = boardnew[i][j];
            }
        }
    }


    /**
     * 从外圈到内圈，进行多次处理
     * @param board
     */
    public static void rotateV2(char[][] board) {
        // 图像的宽度
        int n = board.length;
        // 从最外圈到最内群逐步循环处理
        for (int i = 0; i < board.length/2; i++) {
            for (int j = i; j < board[i].length - 1 - i; j++) {
                // 按照暴力解法的逻辑关系，我们只需要交换 4 次就能完成一次完整的循环，也就是四块
                char temp = board[i][j];
                board[i][j] = board[n-1-j][i];
                board[n-1-j][i] = board[n-1-i][n-1-j];
                board[n-1-i][n-1-j] = board[j][n-1-i];
//                board[j][n-1-i] = board[i][j];
                board[j][n-1-i] = temp;
            }
        }
    }
}
