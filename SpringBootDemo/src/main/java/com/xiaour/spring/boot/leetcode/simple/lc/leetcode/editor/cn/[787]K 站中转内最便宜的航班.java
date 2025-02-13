
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
    }

    public int dp(int n, int[][] flights, int src, int dst, int k, int index) {
        if (k == 0) {
            return Integer.MAX_VALUE;
        }
        if (flights[index][0] == src) {
            return flights[index][2];
        }


    }
}
//leetcode submit region end(Prohibit modification and deletion)
