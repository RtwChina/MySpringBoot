
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int removeDuplicates(int[] nums) {
        int slow = 0;
        int fast = 1;
        while (fast < nums.length) {
            if (nums[slow] == nums[fast]) {
                fast++;
            } else {
                slow++;
                int temp = nums[fast];
                nums[fast] = nums[slow];
                nums[slow] = temp;
                fast++;
            }
        }
        return ++slow;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
