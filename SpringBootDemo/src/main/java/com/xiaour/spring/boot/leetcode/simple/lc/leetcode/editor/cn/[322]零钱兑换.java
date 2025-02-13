import java.util.Arrays;

class Solution {
    public int coinChange(int[] coins, int amount) {
        return dp(coins, amount);
    }


    // 广度优先算法
    public int dp(int[] coins, Integer amount) {
        int[] dpTable = new int[amount + 1];
        Arrays.fill(dpTable, amount + 1);
        dpTable[0] = 0;

        for (int i = 1; i <= amount; i++) {
            // 几种选择
            for (int coin : coins) {
                if (i - coin < 0) {
                    continue;
                }
                // 如果dpTable[i + coin]没有访问过，则直接赋值
//                if (dpTable[i] == amount + 1) {
//                    dpTable[i] = 1 + dpTable[i - coin];
//                } else {
                    dpTable[i] = Math.min(dpTable[i], 1 + dpTable[i - coin]);
//                }
            }
        }

        return dpTable[amount] == amount + 1 ? -1 : dpTable[amount];
    }
}
//runtime:36 ms
//memory:44.9 MB
