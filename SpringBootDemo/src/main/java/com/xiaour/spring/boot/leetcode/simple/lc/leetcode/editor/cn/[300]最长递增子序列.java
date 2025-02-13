import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLIS(int[] nums) {
        dpTable = new int[nums.length];
        Arrays.fill(dpTable, 1);
       return dp(nums, nums.length);

    }

    int[] dpTable;

    // dpTable保存了nums[index]中前方的最长递增序列，也就是说第index节点上的最长序列就是左侧小于nums[index]上数字+1；
    public int dp(int[] nums, int index) {
        for (int i = 0; i < index; i++) {
            int max = 1;
            for (int j = i; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    max = Math.max(max, dpTable[j] + 1);
                }
            }
            dpTable[i] = max;
        }
        Arrays.sort(dpTable);
        return dpTable[dpTable.length - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
