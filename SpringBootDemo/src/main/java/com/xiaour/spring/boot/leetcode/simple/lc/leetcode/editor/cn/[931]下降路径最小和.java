import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minFallingPathSum(int[][] matrix) {

        int[][] dp = new int[matrix.length][matrix.length];
        for (int[] dpX : dp) {
            Arrays.fill(dpX, Integer.MAX_VALUE);
        }
        for (int x = 0; x < matrix.length; x++) {
            for (int y = 0; y < matrix.length; y++) {
                // 终结条件
                if (x == 0) {
                    dp[x][y] = matrix[x][y];
                    continue;
                }
                int min = Integer.MAX_VALUE;
                int a = dp[x - 1][y];
                min = Math.min(min, a);
                if (y - 1 >= 0) {
                    min = Math.min(min, dp[x - 1][y - 1]);
                }
                if (y + 1 < matrix.length) {
                    min = Math.min(min, dp[x - 1][y + 1]);
                }
                dp[x][y] = min + matrix[x][y];
            }
        }

        int min = Integer.MAX_VALUE;
        for (int y = 0; y < matrix.length; y++) {
            min = Math.min(min, dp[matrix.length-1][y]);
        }

        return min;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
