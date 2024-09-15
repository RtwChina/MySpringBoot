package com.xiaour.spring.boot.leetcode.simple.sortandsearch;

import com.alibaba.fastjson.JSON;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @author rtw
 * @since 2024/9/13
 */
public class Queen {

    public static void main(String[] args) {
        Queen queen = new Queen();
//        List<String> bord = new ArrayList<>();
//        bord.add(".Q..");
//        bord.add("....");
//        bord.add("....");
//        System.out.println(queen.isQueen(bord, 1, 0));

        System.out.println(JSON.toJSONString(queen.solveNQueens(4)));
        System.out.println(queen.ans);
    }


    // 输入棋盘边长 n，返回所有合法的放置
    public List<List<String>> solveNQueens(int n) {
        // 每个字符串代表一行，字符串列表代表一个棋盘
        // '.' 表示空，'Q' 表示皇后，初始化空棋盘
        List<String> board = new ArrayList<>();
        StringBuilder initLine = new StringBuilder();
        for (int i = 0; i < n; i++) {
            initLine.append(".");
        }
        for (int i = 0; i < n; i++) {
            board.add(initLine.toString());
        }
        backtrack(board, 0);
        return null;
    }

    List<List<String>> ans = new ArrayList<>();

    /**
     * ，
     *
     * @param bord 当前选择后的列表
     * @param row  已选择的行数
     * @return
     */
    public List<List<String>> backtrack(List<String> bord, int row) {
        if (bord.size() == row) {
            // 存在一个解，添加到答案里面
//            ans.add(bord);
            System.out.println(bord);
            return ans;
        }
        for (int i = 0; i < bord.get(row).length(); i++) {
            // 对每一行的每一列进行处理
            // 判断这个点是否符合规则，不符合则跳过这个点
            if (!isQueen(bord, row, i)) {
                continue;
            }
            // 做选择
            String s = bord.get(row);
            char[] chars = s.toCharArray();
            chars[i] = 'Q';
            bord.set(row, toStringChar(chars));
            // 下一行
            backtrack(bord, row+1);
            // 恢复当前点位的选择
            String s1 = bord.get(row);
            char[] chars1 = s1.toCharArray();
            chars1[i] = '.';
            bord.set(row, toStringChar(chars1));

        }
        return null;
    }


    public String toStringChar(char[] a) {
        // 转为字符串
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            sb.append(a[i]);
        }
        return sb.toString();
    }


    /**
     * 判断是否符合行列
     *
     * @param bord
     * @param row  行
     * @param col  列
     * @return true,可以放置
     */
    public boolean isQueen(List<String> bord, int row, int col) {
        // 判断垂直
        for (int i = 0; i <= row; i++) {
            String s = bord.get(i);
            char[] chars = s.toCharArray();
            if (chars[col] == 'Q') {
                return false;
            }
        }
        // 判断水平
        for (int i = 0; i <= col; i++) {
            String s = bord.get(row);
            char[] chars = s.toCharArray();
            if (chars[i] == 'Q') {
                return false;
            }
        }

        // 左上角
        int i = col;
        int j = row;
        while (i - 1 >= 0 && j - 1 >= 0) {
            char[] chars = bord.get(j - 1).toCharArray();
            if (chars[i - 1] == 'Q') {
                return false;
            }
            i--;
            j--;
        }


        // 右上角
        int i1 = col;
        int j1 = row;
        while (i1 + 1 >= 0 && j1 - 1 >= 0 && i1 + 1 < bord.get(0).length()) {
            char[] chars = bord.get(j1 - 1).toCharArray();
            if (chars[i1 + 1] == 'Q') {
                return false;
            }
            i1++;
            j1--;
        }
        return true;
    }

}
