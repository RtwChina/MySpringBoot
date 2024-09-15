package com.xiaour.spring.boot.leetcode.simple.sortandsearch;

import java.util.Arrays;

/**
 * 322. 零钱兑换
 * https://leetcode.cn/problems/coin-change/
 *
 * @author rtw
 * @since 2024/9/8
 */
public class CoinChange {

    public static void main(String[] args) {

        CoinChange coinChange = new CoinChange();
        coinChange.array = new Integer[100 + 1];
        System.out.println(coinChange.iteration(new int[]{1, 2, 5}, 100));
    }

    Integer[] array;

    /**
     * 递归算法，但是会存在很多重复计算
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }
        Integer minNum = null;
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] > amount) {
                continue;
            }

            if (coins[i] == amount) {
                minNum = 1;
                continue;
            }
            if (coinChange(coins, amount - coins[i]) == -1) {
                continue;
            }

            if (minNum == null) {
                minNum = coinChange(coins, amount - coins[i]) + 1;
            } else {
                minNum = Math.min(coinChange(coins, amount - coins[i]) + 1, minNum);
            }
        }
        if (minNum == null) {
            return -1;
        }
        return minNum;
    }


    /**
     * 递归算法，备忘录模式
     *
     * @param coins
     * @param amount
     * @return
     */
    public int recursion(int[] coins, int amount) {
        if (amount < 0) {
            return -1;
        }

        if (amount == 0) {
            return 0;
        }

        if (array[amount] != null) {
            return array[amount];
        }

        Integer minNum = null;
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] > amount) {
                continue;
            }

            if (coins[i] == amount) {
                minNum = 1;
                continue;
            }
            int coResult = recursion(coins, amount - coins[i]);
            if (coResult == -1) {
                continue;
            }

            if (minNum == null) {
                minNum = coResult + 1;
            } else {
                minNum = Math.min(coResult + 1, minNum);
            }
        }

        if (minNum == null) {
            array[amount] = -1;
            return -1;
        }
        array[amount] = minNum;
        return minNum;
    }


    /**
     * 递归算法，备忘录模式
     *
     * @param coins
     * @param amount
     * @return
     */
    public int iteration(int[] coins, int amount) {
        Integer[] dp = new Integer[amount + 1];
        // 默认值是 amount +1,理论上的数量都不会超过该值。
        Arrays.fill(dp, amount+1);
        dp[0] = 0;

        for (int i = 0; i <= amount; i++) {
            for (int coin : coins) {
                if (coin > i) {
                    continue;
                }
                int num = dp[i - coin] + 1;
                dp[i] = Math.min(num, dp[i]);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
