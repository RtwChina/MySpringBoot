package com.xiaour.spring.boot.leetcode.simple.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author rtw
 * @since 2025/2/3
 */
public class ZiBeiBao {
    public static void main(String[] args) {
        int[] wt = new int[]{2,6,3};
        int[] val = new int[]{2,1,3};

        ZiBeiBao ziBeiBao = new ZiBeiBao();
        System.out.println(ziBeiBao.knapsack(6,3, wt, val));
    }
    private  HashMap<String,Integer>  mem = new HashMap<String,Integer>();



    int knapsack(int W, int N, int[] wt, int[] val) {
        List<int[]> list = new ArrayList<>();
        String s = new String();
        String[] split = s.split("-");
        assert N == wt.length;
        // base case 已初始化
        int[][] dp = new int[N + 1][W + 1];
        for (int i = 1; i <= N; i++) {
            for (int w = 1; w <= W; w++) {
                if (w - wt[i - 1] < 0) {
                    // 这种情况下只能选择不装入背包
                    dp[i][w] = dp[i - 1][w];
                } else {
                    // 装入或者不装入背包，择优
                    dp[i][w] = Math.max(
                            dp[i - 1][w - wt[i-1]] + val[i-1],
                            dp[i - 1][w]
                    );
                }
            }
        }

        return dp[N][W];
    }

}
